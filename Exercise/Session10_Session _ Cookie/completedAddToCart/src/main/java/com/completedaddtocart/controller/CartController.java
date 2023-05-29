package com.completedaddtocart.controller;

import com.completedaddtocart.model.Cart;
import com.completedaddtocart.model.Order;
import com.completedaddtocart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
public class CartController {
    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }

    @Autowired
    private IProductService productService;

    @GetMapping("/shopping-cart")
    public ModelAndView showCart (@SessionAttribute("cart") Cart cart){
        ModelAndView modelAndView = new ModelAndView("/cart");
        modelAndView.addObject("cart",cart);
        return modelAndView;
    }

    @GetMapping("/delete-item/{id}")
    public String deleteCart(@PathVariable("id") Long id, @SessionAttribute("cart") Cart cart) {
        cart.deleteItem(productService.findById(id));
        return "redirect:/shopping-cart";
    }

    @GetMapping("/order")
    public String order(@SessionAttribute("cart") Cart cart, Model model) {
        model.addAttribute("order", new Order(new HashMap<>(cart.getProducts()), cart.countTotalPayment()));
        cart.clearCart();
        return "/orderDetail";
    }
}
