package com.example.app.controller;

import com.example.app.entity.AccountEntity;
import com.example.app.service.CustomUserDetailsService;
import com.example.app.utils.JwtTokenUtil;
import com.example.app.utils.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("account", new AccountEntity());
        return "account/login";
    }

    @PostMapping("/login")
    public String authenticateUser(@ModelAttribute("account") LoginRequest loginAccount,
                                   RedirectAttributes redirectAttributes,
                                   HttpServletResponse response) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginAccount.getUsername(), loginAccount.getPassword())
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwt = jwtTokenUtil.generateToken((UserDetails) authentication.getPrincipal());
            response.addHeader("Authorization", "Bearer " + jwt);

            return "redirect:/login-success";
        } catch (AuthenticationException e) {
            redirectAttributes.addFlashAttribute("error", "Invalid username or password");
            return "redirect:/login";
        }
    }

    @GetMapping("/login-success")
    public String loginSuccess(Authentication authentication) {
        String role = authentication.getAuthorities().iterator().next().getAuthority();
        if (role.equals("ROLE_CUSTOMER")) {
            return "redirect:/home";
        } else if (role.equals("ROLE_ADMIN") || role.equals("ROLE_STAFF")) {
            return "redirect:/admin/index";
        }
        return "redirect:/home";
    }
}