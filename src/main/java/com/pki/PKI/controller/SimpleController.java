package com.pki.PKI.controller;

import com.pki.PKI.domain.User;
import com.pki.PKI.repository.UserRepository;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Controller
public class SimpleController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping(value = "/content")
    public String user(Principal principal, ModelMap model) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        String user = mapper.writeValueAsString(principal);
        int index1 = user.indexOf("email");
        int index2 = user.indexOf("verified_email");

        String email = user.substring(index1+8,index2-3);
        List<User> users = userRepository.findAll();

        model.addAttribute("email", email);
        model.addAttribute("users", users);
        
        return "content";
    }

    @GetMapping(value="/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "index";
    }
}
