package com.example.kursachdb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "Main page");
        return "about";
    }

    @GetMapping("/blog")
    public String blog(Model model) {
        model.addAttribute("title", "Main page");
        return "blog";
    }

    @GetMapping("/blog-details")
    public String blog_details(Model model) {
        model.addAttribute("title", "Main page");
        return "blog-details";
    }

    @GetMapping("/car-details")
    public String car_details(Model model) {
        model.addAttribute("title", "Main page");
        return "car-details";
    }

    @GetMapping("/cars")
    public String cars(Model model) {
        model.addAttribute("title", "Main page");
        return "cars";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("title", "Main page");
        return "contact";
    }

    @GetMapping("/faq")
    public String faq(Model model) {
        model.addAttribute("title", "Main page");
        return "faq";
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("title", "Main page");
        return "index";
    }

    @GetMapping("/team")
    public String team(Model model) {
        model.addAttribute("title", "Main page");
        return "team";
    }

    @GetMapping("/terms")
    public String terms(Model model) {
        model.addAttribute("title", "Main page");
        return "terms";
    }

    @GetMapping("/testimonials")
    public String testimonials(Model model) {
        model.addAttribute("title", "Main page");
        return "testimonials";
    }

}
