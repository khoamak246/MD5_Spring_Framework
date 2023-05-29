package com.signin_outsecurity.controller;


import com.signin_outsecurity.dto.request.SignInForm;
import com.signin_outsecurity.dto.request.SignUpForm;
import com.signin_outsecurity.dto.respone.JwtResponse;
import com.signin_outsecurity.dto.respone.ResponseMessage;
import com.signin_outsecurity.model.Role;
import com.signin_outsecurity.model.RoleName;
import com.signin_outsecurity.model.User;
import com.signin_outsecurity.security.jwt.JwtProvider;
import com.signin_outsecurity.security.userprincipal.UserPrincipal;
import com.signin_outsecurity.service.role.IRoleService;
import com.signin_outsecurity.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @PostMapping("/signup")
    public ResponseEntity<ResponseMessage> registerUser(
            @Valid @RequestBody SignUpForm signUpForm) {
        if (userService.existsByUsername(signUpForm.getUsername())) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseMessage("Fail", "Username is already taken!")
            );
        }

        if (userService.existsByEmail(signUpForm.getEmail())) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseMessage("Fail", "Email is already taken!")
            );
        }

        String passwordAfterEncoder = passwordEncoder.encode(signUpForm.getPassword());

        Role UserRole = roleService.findByName(RoleName.USER)
                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
        Set<Role> roles = new HashSet<>();
        roles.add(UserRole);

        User newUser = new User(
                signUpForm.getName(),
                signUpForm.getUsername(),
                signUpForm.getEmail(),
                passwordAfterEncoder,
                roles
        );

        userService.save(newUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ResponseMessage("OK", "User registered successfully!")
        );

    }

    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody SignInForm signInForm) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        signInForm.getUsername(),
                        signInForm.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwtToken = jwtProvider.generateToken(authentication);
        UserPrincipal userDetails = (UserPrincipal) authentication.getPrincipal();
        return ResponseEntity.ok(
                new JwtResponse(
                        jwtToken,
                        userDetails.getId(),
                        userDetails.getName(),
                        userDetails.getEmail(),
                        userDetails.getAuthorities()
                )
        );
    }

}
