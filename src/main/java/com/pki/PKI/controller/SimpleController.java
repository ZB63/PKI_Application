package com.pki.PKI.controller;

import com.pki.PKI.domain.User;
import com.pki.PKI.repository.UserRepository;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

@RestController
public class SimpleController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/content")
    public String user(Principal principal) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        String user = mapper.writeValueAsString(principal);
        int index1 = user.indexOf("email");
        int index2 = user.indexOf("verified_email");

        String email = user.substring(index1+8,index2-3);
        List<User> users = userRepository.findAll();

        ModelAndView model = new ModelAndView("content");

        model.addObject("email", email);
        model.addObject("users", users);

        //return "Zalogowano jako: " + email + "<br/><a href = \"logout\">Wyloguj!</a>";
        return "redirect:/content.jsp";
    }

    @GetMapping(value="/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }
}
