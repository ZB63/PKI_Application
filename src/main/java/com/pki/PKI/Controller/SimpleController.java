package com.pki.PKI.Controller;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

@RestController
public class SimpleController {

    @GetMapping(value = "/user")
    public String user(Principal principal) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        String user = mapper.writeValueAsString(principal);
        int index1 = user.indexOf("email");
        int index2 = user.indexOf("verified_email");

        String email = user.substring(index1+8,index2-3);

        return "Zalogowano jako: " + email + "<br/><a href = \"logout\">Wyloguj!</a>";
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
