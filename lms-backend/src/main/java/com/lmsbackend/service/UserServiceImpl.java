package com.lmsbackend.service;

import com.lmsbackend.dao.LibrarianDAO;
import com.lmsbackend.dao.MemberDAO;
import com.lmsbackend.dao.UserDAO;
import com.lmsbackend.dto.LibrarianDTO;
import com.lmsbackend.dto.MemberDTO;
import com.lmsbackend.dto.ResponseDTO;
import com.lmsbackend.entity.Librarian;
import com.lmsbackend.entity.Member;
import com.lmsbackend.entity.Role;
import com.lmsbackend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private MemberDAO memberDAO;

    @Autowired
    private LibrarianDAO librarianDAO;

    private static final String UPLOAD_DIR = System.getProperty("user.home") + "/lms/static/external-images/user";

    public String hashPassword(String password) {
        String encryptedPassword = null;
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(password.getBytes());
            byte[] bytes = m.digest();
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            encryptedPassword = s.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encryptedPassword;
    }
    @Override
    @Transactional
    public String saveUser(User user, MultipartFile[] files, String memberType){
        User emailExist = userDAO.findUserByEmail(user.getEmail());
        if (emailExist != null) {
            return "Email already existed.";
        } else {
            if (files != null && files.length > 0) {
                for (MultipartFile file : files) {
                    if (!file.isEmpty()) {
                        try {
                            String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
                            Files.createDirectories(Paths.get(UPLOAD_DIR));
                            file.transferTo(new File(UPLOAD_DIR + "/" + fileName));
                            user.setUserImg("/external-images/user/" + fileName);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("Empty file received: " + file.getName());
                    }
                }
            }
            String password = user.getPassword();
            String encryptedPassword = hashPassword(password);
            user.setPassword(encryptedPassword);
            User userData = userDAO.save(user);
            Role userRole = user.getRole();
            int id = userData.getId();
            LocalDate currentDate = LocalDate.now();
            if (userRole.equals(Role.MEMBER)) {
                LocalDate expiredDate = currentDate.plusYears(1);
                Member member1 = new Member(memberType, currentDate, expiredDate, userData);
                memberDAO.save(member1);
            } else if (userRole.equals(Role.LIBRARIAN)) {
                Librarian librarian1 = new Librarian(currentDate, userData);
                librarianDAO.save(librarian1);
            }
            return "User created successfully";
        }
    }

    @Override
    public ResponseDTO loginUser(String email, String password) {
        User user = userDAO.findUserByEmail(email);
        String encryptedPassword = hashPassword(password);
        ResponseDTO responseDTO = new ResponseDTO();
        if (user == null) {
            responseDTO.setMessage("Email not found");
            responseDTO.setUser(user);
            responseDTO.setStatus("403");
            return responseDTO;
        } else {
            if (!encryptedPassword.equals(user.getPassword())) {
                responseDTO.setMessage("Wrong email or password, try again");
                responseDTO.setStatus("401");
                return responseDTO;
            };
        }
        responseDTO.setToken(hashPassword(user.getEmail()));
        responseDTO.setMessage("Login Successful");
        responseDTO.setStatus("200");
        if (user.getRole().equals(Role.MEMBER)) {
            MemberDTO memberDTO = new MemberDTO();
            memberDTO.setId(user.getId());
            memberDTO.setEmail(user.getEmail());
            memberDTO.setUsername(user.getUsername());
            memberDTO.setName(user.getName());
            memberDTO.setPhone(user.getPhone());
            memberDTO.setAddress(user.getAddress());
            memberDTO.setUserImg(user.getUserImg());
            memberDTO.setMemberType(user.getMember().getMemberType());
            memberDTO.setMemberStartDate(user.getMember().getStartDate());
            memberDTO.setMemberExpireDate(user.getMember().getEndDate());
            memberDTO.setRole(String.valueOf(user.getRole()));
            responseDTO.setMemberDTO(memberDTO);
        } else if (user.getRole().equals(Role.LIBRARIAN)) {
            LibrarianDTO librarianDTO = new LibrarianDTO();
            librarianDTO.setId(user.getId());
            librarianDTO.setEmail(user.getEmail());
            librarianDTO.setUsername(user.getUsername());
            librarianDTO.setName(user.getName());
            librarianDTO.setPhone(user.getPhone());
            librarianDTO.setUserImg(user.getUserImg());
            librarianDTO.setRole(String.valueOf(user.getRole()));
            librarianDTO.setEmploymentDate(user.getLibrarian().getEmploymentDate());
            responseDTO.setLibrarianDTO(librarianDTO);
        }
            return responseDTO;
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

}
