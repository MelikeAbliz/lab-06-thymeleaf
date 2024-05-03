package com.cydeo.controller;

import com.cydeo.service.CartService;
import com.cydeo.service.impl.CartServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Controller
@AllArgsConstructor
public class CartController {
    private CartService cartService;
    @GetMapping("/cart")
    private String showCart(Model model){

        model.addAttribute("cart", CartServiceImpl.CART);
        return "/cart/show-cart";
    }
    @GetMapping("/addToCart/{productId}/{quantity}")
    public String addCart(@PathVariable("productId")UUID productId,
                          @PathVariable("quantity")Integer quantity){
        cartService.addToCart(productId, quantity);
        return "redirect:/cart";
    }

    @GetMapping("/delete/{productId}")
    public String deleteProductFromCart(@PathVariable("productId")UUID productId){
        cartService.deleteFromCart(productId);
        return "redirect:/cart";
    }
}
