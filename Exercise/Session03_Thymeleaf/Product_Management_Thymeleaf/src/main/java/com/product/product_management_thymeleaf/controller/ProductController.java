package com.product.product_management_thymeleaf.controller;

import com.product.product_management_thymeleaf.model.Product;
import com.product.product_management_thymeleaf.service.IProductService;
import com.product.product_management_thymeleaf.service.impl.ProductServiceIMPL;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping({"/", "/product"})
public class ProductController {
    private IProductService productService = new ProductServiceIMPL();

    @GetMapping("/")
    public String index(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "/index";
    }

    @GetMapping("/product/create")
    public String create(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "/create";
    }

    @PostMapping("/product/save")
    public String save(@ModelAttribute("product") Product product) {
        product.setId(productService.findAll().get(productService.findAll().size() - 1).getId() + 1);
        productService.save(product);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable long id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "/edit";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable long id, @ModelAttribute("product") Product product) {
        Product existProduct = productService.findById(id);
        existProduct.setId(id);
        existProduct.setName(product.getName());
        existProduct.setPrice(product.getPrice());
        existProduct.setStock(product.getStock());
        productService.update(existProduct);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(Model model, @PathVariable long id) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "/delete";
    }

    @PostMapping("/confirm/{id}")
    public String delete(@PathVariable long id) {
        productService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable long id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "/view";
    }
}
