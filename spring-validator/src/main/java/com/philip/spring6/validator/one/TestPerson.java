package com.philip.spring6.validator.one;

import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

// 校驗測試
public class TestPerson {
    public static void main(String[] args) {
        // 創建 Person 對象
        Person person = new Person();
        // 創建 Person 對應 DataBinder
        DataBinder dataBinder = new DataBinder(person);
        // 設置校驗器
        dataBinder.setValidator(new PersonValidator());
        // 調用方法執行校驗
        dataBinder.validate();
        // 輸出校驗結果
        BindingResult bindingResult = dataBinder.getBindingResult();
        System.out.println(bindingResult);
    }
}
