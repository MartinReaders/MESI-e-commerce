package fr.mesi.mesikabp.service;

import fr.mesi.mesikabp.model.User;
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

    public static final String exceptionUserAlreadyExists = "User already exists !";

    /*
    Retourne si oui ou non l'adresse email est déjà utilisée
     */
    @Override
    public boolean isAccountExist(User user) {
        return userRepository.findByLogin(user.getLogin()).isPresent();
    }

    @Override
    public void registerUser(User user) throws EntityExistsException {
        if(!isAccountExist(user)) {
            user.setPassword(passwordEncoder.encode(user.getPassword())); //On chiffre le mot de passe
            userRepository.save(user);
        } else {
            throw new EntityExistsException(exceptionUserAlreadyExists);
        }
    }

    @Override
    public boolean isCredentialsUserAreCorrect(User user) {
        Optional<User> userOpt = userRepository.findByLogin(user.getLogin());
        if(userOpt.isPresent()) {
            //Le mot de passe est correct
            //Mot de passe incorrect
            return user.getPassword().equals(userOpt.get().getPassword());
        } else {
            return false; //Compte n'existe pas
        }
    }
}
