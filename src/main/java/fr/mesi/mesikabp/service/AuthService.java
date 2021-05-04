package fr.mesi.mesikabp.service;

import fr.mesi.mesikabp.model.User;

import javax.persistence.EntityExistsException;

public interface AuthService {
    boolean isAccountExist(User user);
    void registerUser(User user) throws EntityExistsException;
    boolean isCredentialsUserAreCorrect(User user);
    User getUserInfoByLogin(String login);
}
