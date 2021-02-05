package fr.mesi.MESIKABP.service;

import fr.mesi.MESIKABP.model.Utilisateur;

import javax.persistence.EntityExistsException;

public interface AuthService {
    boolean isAccountExist(Utilisateur utilisateur);
    void registerUser(Utilisateur utilisateur) throws EntityExistsException;
    boolean isCredentialsUserAreCorrect(Utilisateur utilisateur);
}
