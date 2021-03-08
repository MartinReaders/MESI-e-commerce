package fr.mesi.mesikabp.controller;

import fr.mesi.mesikabp.dto.UserDto;
import fr.mesi.mesikabp.model.User;
import fr.mesi.mesikabp.service.AuthService;
import fr.mesi.mesikabp.service.ModelMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.EntityExistsException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private ModelMapService modelMapService;

    @GetMapping(value = "/home")
    public String getHomePage(HttpServletRequest request, final ModelMap model) {
        UserDto userDto = (UserDto) request.getSession().getAttribute("user");
        if(userDto != null) {
            return "home";
        } else {
            return "redirect:login";
        }
    }

    //-----------------------------------LOGIN------------------------------------------------------------------------//
    @GetMapping(value = "/login")
    public String getConnectionPage(HttpServletRequest request, final ModelMap model) {
        UserDto userDto = (UserDto) request.getSession().getAttribute("user");
        if(userDto != null) {
            return "redirect:home";
        } else {
            UserDto user = new UserDto();
            model.addAttribute("userForm", user);
            return "authentification";
        }
    }




//    @PostMapping("/authentif")
//    public String postForm(@ModelAttribute("userForm") User user) {
//        return "home";
//    }


    @PostMapping(value = "/login")
    public String userConnection(HttpServletRequest request, final ModelMap model, @ModelAttribute("userForm") UserDto userDto) {
        //Liste des erreurs a passé au template
        List<String> errors = new ArrayList<>();
        User userDao = modelMapService.convertToDao(userDto);
        if(authService.isCredentialsUserAreCorrect(userDao)) {
            //Mot de passe et login sont correctes
            //rediriger vers /home
            request.getSession().setAttribute("user", userDto);
            return "redirect:home";
        } else {
            errors.add("Le mot de passe ou le login est incorrect !");
            System.out.println("Le mot de passe ou le login est incorrect !");
            model.put("errors", errors);
            model.put("userForm", userDto);
            return "authentification";
        }
    }

    //-----------------------------------LOGOUT-----------------------------------------------------------------------//
    @GetMapping(value = "/logout")
    public String userDisconnection(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(request.isRequestedSessionIdValid() && session != null) {
            session.invalidate();
        }
        //Rediriger vers le /login
        return "redirect:login";
    }

    //-----------------------------------REGISTER---------------------------------------------------------------------//
    @GetMapping(value = "/register")
    public String getRegisterPage() {
        return "register";
    }

    /*
     * Si erreur passé au model un tableau de chaine contenant les erreurs
     * Faire la vérification du mot de passe (taille etc) coté client
     * Le mot de passe doit être crypté coté client ???
     */
    @PostMapping(value = "/register")
    public String userRegister(final ModelMap model, @RequestBody UserDto userDto) {
        List<String> errors = new ArrayList<>();
        User userDao = modelMapService.convertToDao(userDto);
        try {
            //On tente d'enregistrer l'utilisateur
            authService.registerUser(userDao);
        } catch(EntityExistsException e) {
            //On ajoute l'erreur de l'exception a la liste
            errors.add(e.getMessage());
            model.put("errors", errors);
            return "register";
        }
        return "login"; //Création de compte réussie
    }


}
