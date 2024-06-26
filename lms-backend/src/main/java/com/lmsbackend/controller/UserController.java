package com.lmsbackend.controller;

import com.lmsbackend.dao.LibrarianDAO;
import com.lmsbackend.dao.MemberDAO;
import com.lmsbackend.dao.UserDAO;
import com.lmsbackend.dto.ResponseDTO;
import com.lmsbackend.entity.Librarian;
import com.lmsbackend.entity.Member;
import com.lmsbackend.entity.Role;
import com.lmsbackend.entity.User;
import com.lmsbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public String saveUser(@ModelAttribute User user, @RequestParam(value = "member_type", required = false) String memberType, @RequestParam(value = "files", required = false) MultipartFile[] files) {
        String res = userService.saveUser(user, files, memberType);
        if (res.equals("Email already existed")) {
            return res;
        }
        return res;
    }

    @PostMapping("/login")
    public ResponseDTO loginUser(@RequestParam("email") String email, @RequestParam("password") String password) {
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
        ResponseDTO res = userService.loginUser(email, password);
        if (res.getUser() == null) {
            return res;
        } else if (res.getMessage().equals("Wrong email or password, try again")) {
            return res;
        }
        return res;
    }

    @PostMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
