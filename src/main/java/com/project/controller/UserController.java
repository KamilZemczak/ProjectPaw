package com.project.controller;

import com.project.dao.RoleRepository;
import com.project.model.Role;
import com.project.model.User;
import com.project.service.PlayerService;
import com.project.service.PlayerpointsService;
import com.project.service.SecurityService;
import com.project.service.UserService;
import com.project.validator.UserValidator;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    
    
     @Autowired
    private PlayerService playerService;
    
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
    
    @Autowired
    private RoleRepository roleRepository;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
         userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findOne(1));
        userForm.setRoles(roles);
        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

          return "redirect:/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Niewłaściwe hasło lub login.");

        if (logout != null)
            model.addAttribute("message", "Wylogowanie powiodło sie.");

        return "login";
    }
     @RequestMapping(value = "/pointss")
    public String allGames(HttpServletRequest request) {
        
      request.setAttribute("players", playerService.findAll());
        request.setAttribute("mode", "MODE_PLAYER");
      
        return "pointss";
    }
}
