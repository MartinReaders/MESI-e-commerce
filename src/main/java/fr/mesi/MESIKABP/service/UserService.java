package fr.mesi.MESIKABP.service;

import fr.mesi.MESIKABP.model.Utilisateur;
import fr.mesi.MESIKABP.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        final Optional<Utilisateur> optionalUtilisateur = userRepository.findByLogin(login);
        if(optionalUtilisateur.isPresent()) {
            return optionalUtilisateur.get();
        } else {
            throw new UsernameNotFoundException("L'utilisateur " + login + " n'existe pas !");
        }
    }

    public void registerUser(Utilisateur user) {
        final String encryptedPassword = bCryptPasswordEncoder.encode(user.getPassword());

        user.setPassword(encryptedPassword);

        final Utilisateur createdUser = userRepository.save(user);

        //ConfirmationToken
    }
}
