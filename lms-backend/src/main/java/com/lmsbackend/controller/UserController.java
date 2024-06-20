package com.lmsbackend.controller;

import com.lmsbackend.dao.LibrarianDAO;
import com.lmsbackend.dao.MemberDAO;
import com.lmsbackend.dao.UserDAO;
import com.lmsbackend.entity.Librarian;
import com.lmsbackend.entity.Member;
import com.lmsbackend.entity.Role;
import com.lmsbackend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private MemberDAO memberDAO;

    @Autowired
    private LibrarianDAO librarianDAO;

    @PostMapping("/create")
    public ResponseEntity<String> saveUser(@RequestBody User user, @RequestParam(value = "member_type", required = false) String memberType) {
        User userData = userDAO.save(user);
        Role userRole = user.getRole();
        System.out.println(userData);
        String member = "Standard";
        int id = userData.getId();
        LocalDate currentDate = LocalDate.now();
        if (userRole.equals(Role.MEMBER)) {
            LocalDate expiredDate = currentDate.plusYears(1);
            Member member1 = new Member(member, currentDate, expiredDate, userData);
            memberDAO.save(member1);
            return ResponseEntity.ok("Member Created Successfully");
        } else if (userRole.equals(Role.LIBRARIAN)) {
            Librarian librarian1 = new Librarian(currentDate, userData);
            librarianDAO.save(librarian1);
            return ResponseEntity.ok("Librarin Created Successfully");
        }
//        userRole.equals(Role.LIBRARIAN) ? memberDAO.save() : "";
        return ResponseEntity.ok("User Created Successfully");
    }

    @PostMapping("/all")
    public List<User> getAllUsers() {
        return userDAO.findAll();
    }
}
