package com.example.app.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * @author dungn
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    HttpServletRequest request;

    @GetMapping("/index")
    public String dashboard() {
        return "admin/index";
    }

}
