package com.philip.bean;

import java.io.File;
import java.io.IOException;
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
    //public AnnotationApplicationContext(String basePackage) throws IOException {
    public static void AnnotationApplicationContext1(String basePackage) throws IOException {
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
    }
    // 包掃描過程，實例化
    private static void loadBean(File file) {
        //1 判斷是否是個文件夾

        //2 獲取文件夾內所有內容

        //3 如果文件夾裡面為空，直接返回

        //4 如果文件夾不為空，遍歷文件夾中所有內容

        //4.1 遍歷得到每個File對象，繼續判斷，如果還是文件夾，遞歸

        //4.2 遍歷得到File對象不是文件夾，是文件時

        //4.3 得到包路徑+類名稱部分 => 字符串截取

        //4.4 判斷當前文件類型是否.class

        //4.5 如果是.class類型，把路徑/替換成.   把.class去掉
        // ex: com.philip.spring6.service.UserServiceImpl

        //4.6 判斷類上面是否有註解，@Bean，如果有實例化過程

        //4.7 把對象實例化後，放到map集合beanFactory
    }

    public static void main(String[] args) throws IOException {
        AnnotationApplicationContext1("com.philip");
    }
}
