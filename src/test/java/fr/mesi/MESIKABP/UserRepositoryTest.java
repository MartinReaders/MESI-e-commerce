package fr.mesi.MESIKABP;

import fr.mesi.MESIKABP.model.Utilisateur;
import fr.mesi.MESIKABP.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldFindUserSuccess() {
        String login = "test@test.ipilyon.net";
        final Utilisateur user = new Utilisateur(null, login, "test", 1);
        entityManager.persist(user);
        entityManager.flush();

        Optional<Utilisateur> userFound = userRepository.findByLogin(login);

        assertThat(userFound).isNotEmpty(); //Ne doit pas être vide
        assertThat(userFound.get().getLogin()).isEqualTo(login); //Doit être égale a la valeur attendue
    }

    @Test
    public void shouldFindUserNotSuccess() {
        String goodLogin = "test@test.ipilyon.net";
        String badLogin = "test@teste.ipilyon.net";
        final Utilisateur user = new Utilisateur(null, goodLogin, "test", 1);
        entityManager.persist(user);
        entityManager.flush();

        Optional<Utilisateur> userFound = userRepository.findByLogin(badLogin);

        assertThat(userFound).isEmpty(); //Doit être vide
    }
}
