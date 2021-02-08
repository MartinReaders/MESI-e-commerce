package fr.mesi.mesikabp.repository;

import fr.mesi.mesikabp.model.Utilisateur;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldFindUserSuccess() {
        final Utilisateur user = new Utilisateur();
        user.setLogin("test@test.ipilyon.net");
        entityManager.persist(user);
        entityManager.flush();

        Optional<Utilisateur> userFound = userRepository.findByLogin(user.getLogin());

        assertThat(userFound).isNotEmpty(); //Ne doit pas être vide
        assertThat(userFound.get().getLogin()).isEqualTo(user.getLogin()); //Doit être égale a la valeur attendue
    }

    @Test
    public void shouldFindUserNotSuccess() {
        final Utilisateur user = new Utilisateur();
        user.setLogin("test@test.ipilyon.net");
        entityManager.persist(user);
        entityManager.flush();

        Optional<Utilisateur> userFound = userRepository.findByLogin("test@teste.ipilyon.net");

        assertThat(userFound).isEmpty(); //Doit être vide
    }
}
