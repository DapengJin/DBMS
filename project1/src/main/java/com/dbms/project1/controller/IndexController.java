/*
 * @Author: Jin X
 * @Date: 2020-02-17 17:53:49
 * @LastEditTime: 2020-02-17 18:10:09
 */

package com.dbms.project1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/index")
    public String start() {
        return "index";
    }
}