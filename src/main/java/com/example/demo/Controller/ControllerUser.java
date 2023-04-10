package com.example.demo.Controller;

import com.example.demo.Dto.dtoUser;
import com.example.demo.Model.Status;
import com.example.demo.Model.user.StatusRole;
import com.example.demo.Model.user.User;
import com.example.demo.Service.book.UserService;
import com.example.demo.repository.user.RoleRepository;
import com.example.demo.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ControllerUser {

    private UserService serviceUser;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    @Autowired
    public ControllerUser(UserService serviceUser, RoleRepository roleRepository, UserRepository userRepository) {
        this.serviceUser = serviceUser;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }


    @GetMapping("/profile")
    public String profile(Model model) {
        model.addAttribute("user", new dtoUser(SecurityContextHolder.getContext().getAuthentication(), serviceUser));
        return "/register";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new dtoUser());
        return "/register";
    }

    @PostMapping("/registerUser")
    public String registerUser(@RequestParam String fio,
                               @RequestParam String username,
                               @RequestParam String password,
                               @RequestParam String id,
                               @RequestParam String _csrf) {

        User u = new User();
        u.setFio(fio);
        u.setLogin(username);
        u.setPassword(password);
        u.setStatus(Status.ACTIVE);
        u.getRoles().add(roleRepository.findByName(StatusRole.USER));
        u.setId(Long.valueOf(id));

        if (!password.equals("")) serviceUser.save(u);

        return "redirect:/main";
    }
}
