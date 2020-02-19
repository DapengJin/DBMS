/*
 * @Author: Jin X
 * @Date: 2020-02-17 14:14:28
 * @LastEditTime: 2020-02-19 13:54:49
 */
package com.dbms.project1.controller;

import com.dbms.project1.Repository.MysqlRepository;
import com.dbms.project1.Repository.RedshiftRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/sql")
public class SqlController {

    @Autowired
    RedshiftRepository redshiftRepository;
    @Autowired
    MysqlRepository mysqlRepository;
    
    @GetMapping
    public String check() {
        return "Hello Spring";
    }

    @GetMapping(path="/getaisles")
    public String getaisles() {
        return mysqlRepository.getaisles();
    }

    @PostMapping(path="/e")
    public String jgetdata(@RequestParam("type") String type, @RequestParam("sql") String sql) {
        System.out.println(type+"  :  "+sql);
        if (type.equals("mysql")) {
            return mysqlRepository.getdata(sql);
        }
        if (type.equals("redshift")) {
            return redshiftRepository.getdata(sql);
        }
        return "[{\"error\":NULL}]";
    }
}