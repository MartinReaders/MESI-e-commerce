package fr.mesi.MESIKABP.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AuthController {

    @GetMapping(value = "/login")
    public String getConnectionPage() {
        return "Connexion";
    }

    @PostMapping(value = "/login")
    public /*String*/ void userConnection(ModelMap model, @RequestBody String mailAdress) {

    }
}
