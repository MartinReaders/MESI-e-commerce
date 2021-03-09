package fr.mesi.mesikabp.service;

import fr.mesi.mesikabp.model.User;
import fr.mesi.mesikabp.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.EntityExistsException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private final AuthService authService = new AuthServiceImpl();

    /*
     * Test de la méthode registerUser
     */
    @Test
    void shouldUserSaved() {
        final User user = new User();
        user.setLogin("test@test.ipilyon.net");

        Mockito.when(userRepository.findByLogin(user.getLogin())).thenReturn(Optional.empty());
        Mockito.when(userRepository.save(user)).thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        authService.registerUser(user);

        Mockito.verify(userRepository, Mockito.times(1)).save(Mockito.any(User.class));
    }

    /*
     * Test de la méthode registerUser avec exception EntityExistsException
     */
    @Test
    void shouldAccountExist() {
        final User user = new User();
        user.setLogin("test@test.ipilyon.net");
        Mockito.when(userRepository.findByLogin(user.getLogin())).thenReturn(Optional.of(user));

        assertThatThrownBy(() -> authService.registerUser(user))
        .isInstanceOf(EntityExistsException.class)
        .hasMessageContaining(AuthServiceImpl.EXCEPTION_USER_ALREADY_EXISTS);
    }

    @Test
    void shouldCredentialsAreCorrect() {
        final User user = new User();
        user.setPassword("IPIadmin");
        Mockito.when(userRepository.findByLogin(user.getLogin())).thenReturn(Optional.of(user));

        Boolean isCorrect = authService.isCredentialsUserAreCorrect(user);

        assertThat(isCorrect).isTrue();
    }

    @Test
    void shouldCredentialsArentCorrect() {
        final User user = new User();
        user.setLogin("test@test.ipilyon.net");
        user.setPassword("IPIadmin");
        final User fakeUser = new User();
        fakeUser.setLogin("test@test.ipilyon.net");
        fakeUser.setPassword("IPIADMIN");

        Mockito.when(userRepository.findByLogin(user.getLogin())).thenReturn(Optional.of(user));

        assertThat(authService.isCredentialsUserAreCorrect(fakeUser)).isFalse();
    }

    @Test
    void shouldCredentialsArentCorrectBecauseAccountDoesntExist() {
        final User user = new User();
        user.setLogin("test@test.ipilyon.net");
        user.setPassword("IPIadmin");

        Mockito.when(userRepository.findByLogin(user.getLogin())).thenReturn(Optional.empty());

        assertThat(authService.isCredentialsUserAreCorrect(user)).isFalse();
    }
}
