package com.weather.controller;

import com.weather.dto.request.SignInForm;
import com.weather.dto.request.SignUpForm;
import com.weather.dto.response.JwtResponse;
import com.weather.dto.response.ResponseMessage;
import com.weather.model.Role;
import com.weather.model.RoleName;
import com.weather.model.User;
import com.weather.security.jwt.JwtProvider;
import com.weather.security.userprincipal.UserPrincipal;
import com.weather.service.IRoleService;
import com.weather.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/signUp")
    public ResponseEntity<ResponseMessage> doSignUp(@Valid @RequestBody SignUpForm signUpForm) {
        if (userService.existsByUsername(signUpForm.getUsername())) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(
                    ResponseMessage.builder()
                            .status("Not Acceptable")
                            .message("This username had been taken!")
                            .build()
            );
        }

        if (userService.existsByEmail(signUpForm.getEmail())) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(
                    ResponseMessage.builder()
                            .status("Not Acceptable")
                            .message("This email had been taken!")
                            .build()
            );
        }

        Role userrole = roleService.findByName(RoleName.USER)
                .orElseThrow(() -> new RuntimeException("Role NOT FOUND"));

        Set<Role> roles = new HashSet<>();
        roles.add(userrole);

        User user = User.builder()
                .name(signUpForm.getName())
                .username(signUpForm.getUsername())
                .password(passwordEncoder.encode(signUpForm.getPassword()))
                .email(signUpForm.getEmail())
                .roles(roles)
                .build();

        userService.save(user);
        return ResponseEntity.status(HttpStatus.OK).body(
                ResponseMessage.builder()
                        .status("OK")
                        .message("Account had been create!")
                        .build()
        );
    }


    @PostMapping("/signIn")
    public ResponseEntity<JwtResponse> doSignIn(@Valid @RequestBody SignInForm SignInForm) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        SignInForm.getUsername(),
                        SignInForm.getPassword()
                ));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtProvider.generateToken(authentication);
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        return ResponseEntity.status(HttpStatus.OK).body(
                JwtResponse.builder()
                        .token(token)
                        .name(userPrincipal.getName())
                        .roles(userPrincipal.getAuthorities())
                        .build()
        );
    }

}
