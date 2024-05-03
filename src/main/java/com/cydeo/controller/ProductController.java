package com.cydeo.controller;

import com.cydeo.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping("/list")
    private String getList(Model model){

        model.addAttribute("products",productService.listProducts());
        return "/product/list";
    }
}
