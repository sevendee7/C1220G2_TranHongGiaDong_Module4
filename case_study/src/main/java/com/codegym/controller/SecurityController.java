package com.codegym.controller;

import com.codegym.model.entity.Role;
import com.codegym.model.entity.User;
import com.codegym.service.employee.IEmployeeService;
import com.codegym.service.employee.IRoleService;
import com.codegym.service.employee.IUserService;
import com.codegym.ultil.EncrypPasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashSet;
import java.util.Set;

@Controller
public class SecurityController {
    private final IRoleService roleService;

    private final IUserService userService;

    private final IEmployeeService employeeService;

    @Autowired
    public SecurityController(IRoleService roleService, IUserService userService, IEmployeeService employeeService) {
        this.roleService = roleService;
        this.userService = userService;
        this.employeeService = employeeService;
    }

    @ModelAttribute
    public void detail(Model model) {
        model.addAttribute("roles", roleService.findAll());
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "authentication/login";
        }
        return "redirect:/";
    }

    @GetMapping("/register")
    public ModelAndView getRegisterPage() {
        return new ModelAndView("authentication/authorize", "user", new User());
    }

    @PostMapping("/register")
    public String registerUser(@Validated @ModelAttribute("registerUser") User registerUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "authentication/register";
        } else {
            User user = new User();
            user.setUsername(registerUser.getUsername());
            user.setPassword(EncrypPasswordUtils.EncrypPasswordUtils(registerUser.getPassword()));
            Role roleEntity = roleService.findByName("ROLE_MEMBER");
            Set<Role> listRoles = new HashSet<>();
            listRoles.add(roleEntity);
            user.setRoles(listRoles);
            userService.save(user);
            return "redirect:/login";
        }
    }

    @GetMapping("/403")
    public String getPage403() {
        return "authentication/403";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
            Cookie cookie = new Cookie("remember-me", "");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        }
        return "redirect:/";
    }
}
