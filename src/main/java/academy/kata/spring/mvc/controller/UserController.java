package academy.kata.spring.mvc.controller;

import academy.kata.spring.mvc.model.User;
import academy.kata.spring.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

        @GetMapping("/signup")
        public String showSignUpForm(User user) {
            return "add-user";
        }

        @PostMapping("/adduser")
        public String addUser(User user, Model model) {
            userService.save(user);
            return "redirect:/index";
        }
    @GetMapping("/index")
    public String showUserList(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        User user = userService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));

        model.addAttribute("user", user);
        return "update_user";
    }
    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id, User user, Model model) {
        userService.save(user);
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id, Model model) {
        User user = userService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userService.delete(user.getId());
        return "redirect:/index";
    }
    }
