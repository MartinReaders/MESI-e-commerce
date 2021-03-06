package fr.mesi.mesikabp.repository;

import fr.mesi.mesikabp.model.Product;
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
class ProductRepositoryTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void shouldFindProductCodeSuccess() {
        final Product product = new Product();
        product.setCode("G603");
        entityManager.persist(product);
        entityManager.flush();

        Optional<Product> productOpt = productRepository.findByCode(product.getCode());
        assertThat(productOpt).isNotEmpty();
        assertThat(productOpt.get().getCode()).isEqualTo(product.getCode());
    }

    @Test
    void shouldFindProductCodeNotSuccess() {
        final Product product = new Product();
        product.setCode("G603");
        entityManager.persist(product);
        entityManager.flush();

        Optional<Product> productOpt = productRepository.findByCode("G605");
        assertThat(productOpt).isEmpty();
    }
}
