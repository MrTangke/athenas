package com.alibaba.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class TestController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @ResponseBody
    @RequestMapping("hello")
    public String hello() {
        String sql = "select * from alipay";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        maps.forEach(map -> {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                System.out.println("输出 -> " + entry.getKey() + "::" + entry.getValue());
            }
        });
        return "Hello SpringBoot!";
    }
}
