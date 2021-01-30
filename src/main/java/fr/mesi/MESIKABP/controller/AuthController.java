package fr.mesi.MESIKABP.controller;

import fr.mesi.MESIKABP.model.Utilisateur;
import fr.mesi.MESIKABP.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.view.RedirectView;

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
        return "Connexion";
    }

    @PostMapping(value = "/login")
    public void userConnection(ModelMap model, @RequestBody Utilisateur utilisateur) {
        if(authService.isCredentialsUserAreCorrect(utilisateur)) {
            //Mot de passe et login sont correctes
            //rediriger vers /home
        } else {

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
        return "Register";
    }

    /*
     * Si erreur passé au model un tableau de chaine contenant les erreurs
     * Faire la vérification du mot de passe (taille etc) coté client
     * Le mot de passe doit être crypté coté client ???
     */
    @PostMapping(value = "/register")
    public void userRegister(ModelMap model, @RequestBody Utilisateur utilisateurRegister) {
        List<String> errors = new ArrayList<>();
        if(!authService.isAccountExist(utilisateurRegister)) {
            //L'adresse email n'est pas utilisée alors on peut continuer dans le process
            authService.registerUser(utilisateurRegister);
        } else {
            //A mettre dans une constante ou faire une chaine a formatter
            errors.add("L'adresse email est déjà utilisée !");
        }
    }
}
