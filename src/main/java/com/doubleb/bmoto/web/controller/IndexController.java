package com.doubleb.bmoto.web.controller;

import com.doubleb.bmoto.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    private ProductService productService;

    @GetMapping("/index")
    public String showIndexPage(Model model) {
        model.addAttribute("justArrivedProducts", productService.getJustArrivedProducts());
        return "index";
    }

    @GetMapping("/about")
    public String showAboutPage() {
        return "about";
    }

    @GetMapping("/sidebar")
    public String showSideBarPage() {
        return "dashboard/side-bar-menu";
    }

    @GetMapping("/contact")
    public String showContactPage() {
        return "contact";
    }
}
