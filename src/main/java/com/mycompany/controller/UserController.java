package com.mycompany.controller;

import com.mycompany.models.User;
import com.mycompany.service.UserNotFoundException;
import com.mycompany.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userservice;

    @GetMapping("/users")
    public String showUserList(Model model) {
        List<User> users = userservice.listAll();
        model.addAttribute("listUser", users);
        return "users";
    }

    @GetMapping("/users/new")
    public String showNewForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("pageTitle", "Add new users");
        return "user_form";
    }
    @PostMapping("/users/save")
    public String saveUser(User user, RedirectAttributes ra) {
        userservice.save(user);
        ra.addFlashAttribute("message", "The user has been saved successfully");
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra)   {
        try {
            User user = userservice.getById(id);
            model.addAttribute("user", user);
            model.addAttribute("pageTitle", "Edit users ID " + id);
            return "user_form";
        }
        catch (UserNotFoundException e) {
            return "redirect:/users";
        }
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, RedirectAttributes ra) throws UserNotFoundException {
        try {
            userservice.deleteById(id);
            ra.addFlashAttribute("message", "The user has been deleted successfully!");
            return "redirect:/users";
        }
        catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/users";
        }
    }
}
