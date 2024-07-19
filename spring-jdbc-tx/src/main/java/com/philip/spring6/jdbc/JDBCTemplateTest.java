package com.philip.spring6.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:beans.xml")
public class JDBCTemplateTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 添加 修改 刪除
    @Test
    public void testUpdate(){
        /*
        // 1 添加操作
        // 第一步 編寫 sql 語句
        String sql = "INSERT INTO t_emp VALUES(null, ?, ?, ?)";

        // 第二步 調用 jdbcTemplate 的方法，傳入相關參數
        //int rows = jdbcTemplate.update(sql, "Amy", 20, "女");

        Object[] params = {"Andy", 40, "男"};
        int rows = jdbcTemplate.update(sql, params);
        System.out.println(rows);
        */

        /*
        // 修改操作
        String sql = "UPDATE t_emp set NAME = ? WHERE id = ?";
        int rows = jdbcTemplate.update(sql, "Apple...", 3);
        System.out.println(rows);
        */

        // 刪除操作
        String sql = "DELETE FROM t_emp WHERE id = ?";
        int rows = jdbcTemplate.update(sql, 3);
        System.out.println(rows);


    }
}
