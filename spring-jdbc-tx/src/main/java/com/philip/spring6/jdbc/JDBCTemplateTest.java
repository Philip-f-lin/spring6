package com.philip.spring6.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig(locations = "classpath:beans.xml")
public class JDBCTemplateTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    // 查詢：返回對象
    public void testSelectObject(){
        // 寫法一：
        /*String sql = "SELECT * FROM t_emp WHERE id = ? ";
        Emp empResult = jdbcTemplate.queryForObject(sql,
                (rs, rowNum) -> {
                    Emp emp = new Emp();
                    emp.setId(rs.getInt("id"));
                    emp.setName(rs.getString("name"));
                    emp.setAge(rs.getInt("age"));
                    emp.setSex(rs.getString("sex"));
                    return emp;
                }
                , 1);
        System.out.println(empResult);*/

        // 寫法二：
        String sql = "SELECT * FROM t_emp WHERE id = ? ";
        Emp emp = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Emp.class), 2);
        System.out.println(emp);
    }

    // 查詢：返回 list 集合
    @Test
    public void testSelectList(){
        String sql = "SELECT * FROM t_emp";
        List<Emp> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class));
        System.out.println(list);
    }

    // 查詢：返回單個值
    @Test
    public void testSelectValue(){
        String sql = "SELECT COUNT(*) FROM t_emp";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(count);

    }

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
