package fr.mesi.mesikabp.service;

import fr.mesi.mesikabp.model.User;
import fr.mesi.mesikabp.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityExistsException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class AuthServiceIntegrationTest {

    @Autowired
    private AuthServiceImpl authService;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    @AfterEach
    void purgeBdd(){
        userRepository.deleteAll();
    }

    @Test
    void shouldUserSaved() {
        User user = new User();
        user.setLogin("test@test.ipilyon.net");
        user.setPassword("IPITEST");

        authService.registerUser(user);

        Optional<User> userSaved = userRepository.findByLogin(user.getLogin());
        assertThat(userSaved).isPresent();
    }

    @Test
    void shouldAccountExist() {
        final User user = new User();
        user.setLogin("test@test.ipilyon.net");

        userRepository.save(user);

        assertThatThrownBy(() -> authService.registerUser(user))
                .isInstanceOf(EntityExistsException.class)
                .hasMessageContaining(AuthServiceImpl.EXCEPTION_USER_ALREADY_EXISTS);
    }
}
