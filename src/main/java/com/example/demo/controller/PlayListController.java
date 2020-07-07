package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class PlayListController {
    @RequestMapping(value = "/playlistadd", method = RequestMethod.GET)
    public String PlayListAdd(){

        return null;
    }
}
