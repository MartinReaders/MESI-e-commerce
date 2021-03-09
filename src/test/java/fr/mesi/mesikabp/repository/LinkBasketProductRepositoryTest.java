package fr.mesi.mesikabp.repository;

import fr.mesi.mesikabp.model.Basket;
import fr.mesi.mesikabp.model.LinkBasketProduct;
import fr.mesi.mesikabp.model.Product;
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
class LinkBasketProductRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BasketRepository basketRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private LinkBasketProductRepository linkBasketProductRepository;

    @BeforeEach
    @AfterEach
    void purgeBdd(){
        linkBasketProductRepository.deleteAll();
    }

    @Test
    void shouldFindBasketLineSuccess() {
        User userDao = new User();
        userDao = userRepository.save(userDao);

        Basket basketDao = new Basket();
        basketDao.setUser(userDao);

        basketDao = basketRepository.save(basketDao);

        Product product = new Product();
        product = productRepository.save(product);

        LinkBasketProduct linkBasketProduct = new LinkBasketProduct();
        linkBasketProduct.setBasket(basketDao);
        linkBasketProduct.setProduct(product);
        linkBasketProductRepository.save(linkBasketProduct);

        Optional<LinkBasketProduct> linkBasketProductOptional = linkBasketProductRepository
                .findBasketLine(basketDao.getId(), product.getId());

        assertThat(linkBasketProductOptional).isPresent();
    }

    @Test
    void shouldDeleteAllBasketLineOfBasketSuccess() {
        User userDao = new User();
        userDao = userRepository.save(userDao);

        Basket basketDao = new Basket();
        basketDao.setUser(userDao);

        basketDao = basketRepository.save(basketDao);

        Product firstProduct = new Product();
        firstProduct = productRepository.save(firstProduct);

        Product secondProduct = new Product();
        secondProduct = productRepository.save(secondProduct);

        LinkBasketProduct firstLinkBasketProduct = new LinkBasketProduct();
        firstLinkBasketProduct.setBasket(basketDao);
        firstLinkBasketProduct.setProduct(firstProduct);
        linkBasketProductRepository.save(firstLinkBasketProduct);

        LinkBasketProduct secondLinkBasketProduct = new LinkBasketProduct();
        secondLinkBasketProduct.setBasket(basketDao);
        secondLinkBasketProduct.setProduct(secondProduct);
        linkBasketProductRepository.save(secondLinkBasketProduct);

        linkBasketProductRepository.deleteAllBasketLineOfBasket(basketDao.getId());

        assertThat(linkBasketProductRepository.findBasketLine(basketDao.getId(), firstProduct.getId())).isEmpty();
        assertThat(linkBasketProductRepository.findBasketLine(basketDao.getId(), secondProduct.getId())).isEmpty();
    }
}
