package fr.mesi.MESIKABP.service;

import fr.mesi.MESIKABP.model.Utilisateur;
import fr.mesi.MESIKABP.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    /*
    Retourne si oui ou non l'adresse email est déjà utilisée
     */
    public boolean isAccountExist(Utilisateur utilisateur) {
        return userRepository.findByLogin(utilisateur.getLogin()).isPresent();
    }

    public void registerUser(Utilisateur utilisateur) {

    }

    public boolean isCredentialsUserAreCorrect(Utilisateur utilisateur) {
        return false;
    }
}
