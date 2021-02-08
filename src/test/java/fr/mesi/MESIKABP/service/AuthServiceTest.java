package fr.mesi.MESIKABP.service;

import fr.mesi.MESIKABP.model.Utilisateur;
import fr.mesi.MESIKABP.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityExistsException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private final AuthService authService = new AuthServiceImpl();

    /*
     * Test de la méthode registerUser
     */
    @Test
    void shouldUserSaved() {
        final Utilisateur user = new Utilisateur();
        user.setLogin("test@test.ipilyon.net");

        Mockito.when(userRepository.findByLogin(user.getLogin())).thenReturn(Optional.empty());
        Mockito.when(userRepository.save(user)).thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        authService.registerUser(user);

        Mockito.verify(userRepository, Mockito.times(1)).save(Mockito.any(Utilisateur.class));
    }

    /*
     * Test de la méthode registerUser avec exception EntityExistsException
     */
    @Test
    void shouldAccountExist() {
        final Utilisateur user = new Utilisateur();
        user.setLogin("test@test.ipilyon.net");
        Mockito.when(userRepository.findByLogin(user.getLogin())).thenReturn(Optional.of(user));

        assertThatThrownBy(() -> authService.registerUser(user))
        .isInstanceOf(EntityExistsException.class)
        .hasMessageContaining("User already exists !");
    }

    @Test
    void shouldCredentialsAreCorrect() {
        final Utilisateur user = new Utilisateur(null, "test@test.ipilyon.net", "IPIadmin", 1);
        user.setPassword("IPIadmin");
        Mockito.when(userRepository.findByLogin(user.getLogin())).thenReturn(Optional.of(user));

        Boolean isCorrect = authService.isCredentialsUserAreCorrect(user);

        assertThat(isCorrect).isTrue();
    }

    @Test
    void shouldCredentialsArentCorrect() {
        final Utilisateur user = new Utilisateur();
        user.setLogin("test@test.ipilyon.net");
        user.setPassword("IPIadmin");
        final Utilisateur fakeUser = new Utilisateur();
        fakeUser.setLogin("test@test.ipilyon.net");
        fakeUser.setPassword("IPIADMIN");

        Mockito.when(userRepository.findByLogin(user.getLogin())).thenReturn(Optional.of(user));

        assertThat(authService.isCredentialsUserAreCorrect(fakeUser)).isFalse();
    }

    @Test
    void shouldCredentialsArentCorrectBecauseAccountDoesntExist() {
        final Utilisateur user = new Utilisateur();
        user.setLogin("test@test.ipilyon.net");
        user.setPassword("IPIadmin");

        Mockito.when(userRepository.findByLogin(user.getLogin())).thenReturn(Optional.empty());

        assertThat(authService.isCredentialsUserAreCorrect(user)).isFalse();
    }
}
