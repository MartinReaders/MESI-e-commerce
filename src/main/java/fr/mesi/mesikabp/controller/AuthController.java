package fr.mesi.mesikabp.controller;

import fr.mesi.mesikabp.model.User;
import fr.mesi.mesikabp.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.view.RedirectView;

import javax.persistence.EntityExistsException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AuthController {

    @Autowired
    private AuthService authService;

    //-----------------------------------LOGIN------------------------------------------------------------------------//
    @GetMapping(value = "/login")
    public String getConnectionPage() {
        return "authentification";
    }

    @PostMapping(value = "/login")
    public String userConnection(final ModelMap model, @RequestBody User user) {
        List<String> errors = new ArrayList<>();
        if(authService.isCredentialsUserAreCorrect(user)) {
            //Mot de passe et login sont correctes
            //rediriger vers /home
            return "home";
        } else {
            System.out.println("Erreur");
            errors.add("Le mot de passe ou le login est incorrect !");
            model.put("errors", errors);
            model.put("login", user.getLogin());
            return "authentification";
        }
    }

    //-----------------------------------LOGOUT-----------------------------------------------------------------------//
    @GetMapping(value = "/logout")
    public RedirectView userDisconnection(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if(request.isRequestedSessionIdValid() && session != null) {
            session.invalidate();
        }
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            cookie.setMaxAge(0);
            cookie.setValue(null);
            cookie.setPath("/");
            response.addCookie(cookie);
        }
        //Rediriger vers le /login
        return new RedirectView("/login");
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
    public String userRegister(final ModelMap model, @RequestBody User userRegister) {
        List<String> errors = new ArrayList<>();
        try {
            //On tente d'enregistrer l'utilisateur
            authService.registerUser(userRegister);
        } catch(EntityExistsException e) {
            //On ajoute l'erreur de l'exception a la liste
            errors.add(e.getMessage());
            model.put("errors", errors);
            return "register";
        }
        return "login"; //Création de compte réussie
    }
}
