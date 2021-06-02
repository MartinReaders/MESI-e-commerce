package fr.mesi.mesikabp.service;

import fr.mesi.mesikabp.dto.UserDto;
import fr.mesi.mesikabp.model.User;
import fr.mesi.mesikabp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapService modelMapService;

    public static final String EXCEPTION_USER_ALREADY_EXISTS = "User already exists !";

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
            throw new EntityExistsException(EXCEPTION_USER_ALREADY_EXISTS);
        }
    }

    @Override
    public boolean isCredentialsUserAreCorrect(User user) {
        Optional<User> userOpt = userRepository.findByLogin(user.getLogin());
        if(userOpt.isPresent()) {
            //Le mot de passe est correct
            //Mot de passe incorrect
            return passwordEncoder.matches(user.getPassword(), userOpt.get().getPassword());
        } else {
            return false; //Compte n'existe pas
        }
    }

    @Override
    public UserDto getUserInfoByLogin(String login) {
        if(login.isEmpty()) {
            return null;
        }

        Optional<User> userOpt = userRepository.findByLogin(login);

        return userOpt.map(user -> modelMapService.convertToDto(user)).orElse(null);
    }

    @Override
    public boolean isAuthenticated(HttpSession session) {
        return session.getAttribute("user") != null;
    }
}
