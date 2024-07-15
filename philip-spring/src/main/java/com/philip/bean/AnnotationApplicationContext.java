package com.philip.bean;

import com.philip.anno.Bean;
import com.philip.anno.Di;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class AnnotationApplicationContext implements ApplicationContext{

    // 創建map集合，放bean對象
    private Map<Class, Object> beanFactory = new HashMap<>();
    private static String rootPath;
    @Override
    public Object getBean(Class clazz) {
        return beanFactory.get(clazz);
    }

    // 創建有參數構造，傳遞包路徑，設置包掃描規則
    // 當前包及其子包，哪個類有@Bean註解，把這個類通過反射實例化
    public AnnotationApplicationContext(String basePackage) throws Exception {
        // com.philip
        // 1 把.替換成/
        String packagePath = basePackage.replaceAll("\\.", "/");

        // 2 獲取包絕對路徑
        Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(packagePath);
        while(urls.hasMoreElements()){
            URL url = urls.nextElement();
            String filePath = URLDecoder.decode(url.getFile(), "utf-8");

            // 獲取包前面路徑，字符串截取
            rootPath = filePath.substring(0, filePath.length() - packagePath.length());

            // 包掃描
            loadBean(new File(filePath));
            System.out.println(filePath);
        }

        // 屬性注入
        loadDi();
    }

    // 包掃描過程，實例化
    private void loadBean(File file) throws Exception {
        //1 判斷是否是個文件夾
        if(file.isDirectory()){
            //2 獲取文件夾內所有內容
            File[] listedFiles = file.listFiles();
            //3 如果文件夾裡面為空，直接返回
            if (listedFiles == null || listedFiles.length == 0){
                return;
            }
            //4 如果文件夾不為空，遍歷文件夾中所有內容
            for (File childrenFile : listedFiles) {
                //4.1 遍歷得到每個File對象，繼續判斷，如果還是文件夾，遞歸
                if(childrenFile.isDirectory()){
                    loadBean(childrenFile);
                }else {
                    //4.2 遍歷得到File對象不是文件夾，是文件時
                    //4.3 得到包路徑+類名稱部分 => 字符串截取
                    String pathWithClass = childrenFile.getAbsolutePath().substring(rootPath.length() - 1);
                    //4.4 判斷當前文件類型是否.class
                    if(pathWithClass.contains(".class")){
                        //4.5 如果是.class類型，把路徑/替換成.   把.class去掉
                        // ex: com.philip.spring6.service.UserServiceImpl
                        String allName = pathWithClass.replaceAll("/", ".").replace(".class", "");
                        if (allName.startsWith(".")) {
                            allName = allName.substring(1);
                        }
                        //4.6 判斷類上面是否有註解，@Bean，如果有實例化過程
                        //4.6.1 獲取類的class
                        Class<?> clazz = Class.forName(allName);
                        //4.6.2 判斷不是接口

                        if(!clazz.isInterface()){
                            //4.6.3 判斷類上面是否有註解@Bean
                            Annotation annotation = clazz.getAnnotation(Bean.class);
                            if(annotation != null){
                                //4.6.4 實例化
                                Object newInstance = clazz.getConstructor().newInstance();
                                //4.7 把對象實例化後，放到map集合beanFactory
                                //4.7.1 判斷當前類如果有接口，讓接口class作為map的key
                                if(clazz.getInterfaces().length > 0){
                                    beanFactory.put(clazz.getInterfaces()[0], newInstance);
                                }else {
                                    beanFactory.put(clazz, newInstance);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    // 屬性注入
    private void loadDi() throws IllegalAccessException {
        // 實例化對象在 beanFactory 的 map 集合裡面
        // 1 遍歷 beanFactory 的 map 集合
        for (Map.Entry<Class, Object> entry : beanFactory.entrySet()) {
            // 2 獲取 map 集合每個對象(value), 將每個對象的屬性獲取到
            Object bean = entry.getValue();
            // 獲取對象的 Class 類型
            Class<?> clazz = bean.getClass();
            // 獲取對象的所有屬性
            Field[] declaredFields = clazz.getDeclaredFields();
            // 3 遍歷每個對象的屬性數組，得到每個屬性
            for (Field declaredField : declaredFields) {
                // 4 判斷屬性上面是否有 @Di 註解
                Di di = declaredField.getAnnotation(Di.class);
                if (di != null) {
                    // 如果是私有屬性，將其設置為可訪問
                    declaredField.setAccessible(true);
                    // 5 如果有 @Di 註解，進行屬性注入
                    // 將對應類型的對象注入當前屬性
                    // 例如，如果當前的 bean 是 UserServiceImpl，
                    // clazz 是 UserServiceImpl 的 Class 對象，
                    // declaredField.getType() 會返回屬性的類型，例如 UserDao，
                    // beanFactory.get(declaredField.getType()) 會返回 UserDao 的實例
                    // (總結：根據類型找到對象，進行注入)
                    declaredField.set(bean, beanFactory.get(declaredField.getType()));
                }
            }
        }
    }
}
