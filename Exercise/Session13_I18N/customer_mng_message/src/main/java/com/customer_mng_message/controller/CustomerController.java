package com.customer_mng_message.controller;


import com.customer_mng_message.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("customers")
public class CustomerController {

    @ModelAttribute("customers")
    public List<Customer> setupCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, "Nhan", 18));
        customers.add(new Customer(2, "Nam", 19));
        customers.add(new Customer(3, "Chinh", 20));
        return customers;
    }

    @GetMapping("/")
    public String showIndex(@ModelAttribute("customers") List<Customer> customers, Model model) {
        model.addAttribute("customers", customers);
        return "/index";
    }

    @GetMapping("/delete/{index}")
    public String doDelete(@PathVariable int index,
                           @ModelAttribute("customers") List<Customer> customers) {
        customers.remove(index);
        return "redirect:/";
    }
}
