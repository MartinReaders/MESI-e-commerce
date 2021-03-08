package fr.mesi.mesikabp.repository;

import fr.mesi.mesikabp.model.Basket;
import fr.mesi.mesikabp.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BasketRepositoryTest {

    @Autowired
    private BasketRepository basketRepository;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    @AfterEach
    void purgeBdd(){
        basketRepository.deleteAll();
    }

    @Test
    void shouldfindBasketLinkToUserSuccess() {
        User userDao = new User();
        userDao = userRepository.save(userDao);

        Basket basketDao = new Basket();
        basketDao.setUser(userDao);

        basketRepository.save(basketDao);

        Optional<Basket> basketOptional = basketRepository.findBasketLinkToUser(userDao.getId());

        assertThat(basketOptional.isPresent()).isTrue();
    }
}
