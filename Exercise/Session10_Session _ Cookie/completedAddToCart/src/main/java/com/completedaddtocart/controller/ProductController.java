package com.completedaddtocart.controller;

import com.completedaddtocart.model.Cart;
import com.completedaddtocart.model.Product;
import com.completedaddtocart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
public class ProductController {

    @Autowired
    private IProductService productService;

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/")
    public String showIndex() {
        return "redirect:/shop";
    }

    @GetMapping("/shop")
    public ModelAndView showShop() {
        ModelAndView modelAndView = new ModelAndView("/shop");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id,
                            @ModelAttribute Cart cart,
                            @RequestParam("action") String action) {
        Product productOptional = productService.findById(id);
        if (productOptional == null) {
            return "/error.404";
        }
        if (action.equals("increase")) {
            cart.addProduct(productOptional);
            return "redirect:/shopping-cart";
        } else if (action.equals("decrease")) {
            cart.removeProduct(productOptional);
            return "redirect:/shopping-cart";
        }

        cart.addProduct(productOptional);
        return "redirect:/shop";
    }
}
