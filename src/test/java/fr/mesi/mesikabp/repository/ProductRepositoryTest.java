package fr.mesi.mesikabp.repository;

import fr.mesi.mesikabp.model.Produit;
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
public class ProductRepositoryTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void shouldFindProductCodeSuccess() {
        final Produit product = new Produit();
        product.setCode("G603");
        entityManager.persist(product);
        entityManager.flush();

        Optional<Produit> productOpt = productRepository.findByCode(product.getCode());
        assertThat(productOpt).isNotEmpty();
        assertThat(productOpt.get().getCode()).isEqualTo(product.getCode());
    }

    @Test
    void shouldFindProductCodeNotSuccess() {
        final Produit product = new Produit();
        product.setCode("G603");
        entityManager.persist(product);
        entityManager.flush();

        Optional<Produit> productOpt = productRepository.findByCode("G605");
        assertThat(productOpt).isEmpty();
    }
}
