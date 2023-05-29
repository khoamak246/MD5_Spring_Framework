package com.signin_outsecurity.controller;


import com.signin_outsecurity.security.userprincipal.UserPrincipal;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthRouterController {

    private UserPrincipal getUserPrincipal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return null;
        }
        return (UserPrincipal) authentication.getPrincipal();
    }

    @GetMapping("/")
    public String routerPage() {
        return "redirect:/signup";
    }

    @GetMapping("/signup")
    public String showSignUpPage() {
        return "/signup";
    }

    @GetMapping("/admin")
    public String showAdminPage() {
        System.out.println(getUserPrincipal());
        return "/admin";
    }

    @GetMapping("/signin")
    public String showLoginPage() {
        return "/login";
    }

    @GetMapping("/accessDenied")
    public String showAccessDenied() {
        return "/accessDenied";
    }
    @GetMapping("/home")
    public String showHome() {
        return "/homepage";
    }



}
