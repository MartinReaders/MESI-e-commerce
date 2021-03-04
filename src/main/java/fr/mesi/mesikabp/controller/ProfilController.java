package fr.mesi.mesikabp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProfilController {

    @GetMapping("/profile/{id}")
    public String getProfilPage(final ModelMap model, @PathVariable Long id) {
        return "profile";
    }

    @GetMapping("/profile/{idProfile}/order/{idOrder}")
    public String getOrderPage(final ModelMap model, @PathVariable Long idProfile, @PathVariable Long idOrder) {
        return "profile";
    }
}
