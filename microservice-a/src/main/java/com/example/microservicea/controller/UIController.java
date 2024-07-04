package com.example.microservicea.controller;

import com.example.microservicea.client.MicroserviceBClient;
import com.example.microservicea.model.AstronomyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ui")
public class UIController {

    @Autowired
    private MicroserviceBClient microserviceBClient;

    @GetMapping("/index")
    public String showAstronomyData(Model model) {
        AstronomyData data = microserviceBClient.getAstronomyData().getBody();
        model.addAttribute("title", data.getTitle());
        model.addAttribute("url", data.getUrl());
        model.addAttribute("explanation", data.getExplanation());
        return "index";
    }
}
