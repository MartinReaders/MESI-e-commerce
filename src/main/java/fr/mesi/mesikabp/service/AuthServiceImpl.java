package fr.mesi.mesikabp.service;

import fr.mesi.mesikabp.model.Utilisateur;
import fr.mesi.mesikabp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    /*
    Retourne si oui ou non l'adresse email est déjà utilisée
     */
    @Override
    public boolean isAccountExist(Utilisateur utilisateur) {
        return userRepository.findByLogin(utilisateur.getLogin()).isPresent();
    }

    @Override
    public void registerUser(Utilisateur utilisateur) throws EntityExistsException {
        if(!isAccountExist(utilisateur)) {
//            utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword())); //On chiffre le mot de passe
            userRepository.save(utilisateur);
        } else {
            throw new EntityExistsException("User already exists !");
        }
    }

    @Override
    public boolean isCredentialsUserAreCorrect(Utilisateur utilisateur) {
        Optional<Utilisateur> userOpt = userRepository.findByLogin(utilisateur.getLogin());
        if(userOpt.isPresent()) {
            if(utilisateur.getPassword().equals(userOpt.get().getPassword())) {
                //Le mot de passe est correct
                return true;
            } else {
                return false; //Mot de passe incorrect
            }
        } else {
            return false; //Compte n'existe pas
        }
    }
}
