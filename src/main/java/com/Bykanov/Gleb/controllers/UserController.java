package com.Bykanov.Gleb.controllers;

import com.Bykanov.Gleb.domain.entity.Role;
import com.Bykanov.Gleb.domain.entity.User;
import com.Bykanov.Gleb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
class UserController {
    @Autowired
    private UserService userService;

    @PreAuthorize( "hasAuthority('ADMIN')" )
    @GetMapping
    public String userList(Model model){
        model.addAttribute( "users", userService.findAll() );
        return "userList";
    }

    @PreAuthorize( "hasAuthority('ADMIN')" )
    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model){
        model.addAttribute( "user", user );
        model.addAttribute( "roles", Role.values() );
        return "userEdit";
    }

    @PreAuthorize( "hasAuthority('ADMIN')" )
    @PostMapping
    public String userSave(
            @RequestParam String  username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user){
        userService.saveUser(user, username, form);
        return "redirect:/user";
    }

    @GetMapping("profile")
    public String getProfile(Model model, @AuthenticationPrincipal User user){
        model.addAttribute( "username", user.getUsername() );
        model.addAttribute( "email", user.getMail() );
        return "profile";
    }

    @PostMapping("profile")
    public String updateProfile(
            @AuthenticationPrincipal User user,
            @RequestParam String password,
            @RequestParam String email){
        userService.updateProfile(user, password, email);
        return "redirect:/user/profile";
    }
}
