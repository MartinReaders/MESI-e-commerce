package fr.mesi.mesikabp.repository;

import fr.mesi.mesikabp.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    void shouldFindUserSuccess() {
        final User user = new User();
        user.setLogin("test@test.ipilyon.net");
        entityManager.persist(user);
        entityManager.flush();

        Optional<User> userFound = userRepository.findByLogin(user.getLogin());

        assertThat(userFound).isNotEmpty(); //Ne doit pas être vide
        assertThat(userFound.get().getLogin()).isEqualTo(user.getLogin()); //Doit être égale a la valeur attendue
    }

    @Test
    void shouldFindUserNotSuccess() {
        final User user = new User();
        user.setLogin("test@test.ipilyon.net");
        entityManager.persist(user);
        entityManager.flush();

        Optional<User> userFound = userRepository.findByLogin("test@teste.ipilyon.net");

        assertThat(userFound).isEmpty(); //Doit être vide
    }
}
