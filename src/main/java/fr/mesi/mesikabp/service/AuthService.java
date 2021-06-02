package fr.mesi.mesikabp.service;

import fr.mesi.mesikabp.dto.UserDto;
import fr.mesi.mesikabp.model.User;

import javax.persistence.EntityExistsException;
import javax.servlet.http.HttpSession;

public interface AuthService {
    boolean isAccountExist(User user);
    void registerUser(User user) throws EntityExistsException;
    boolean isCredentialsUserAreCorrect(User user);
    UserDto getUserInfoByLogin(String login);
    boolean isAuthenticated(HttpSession session);
}
