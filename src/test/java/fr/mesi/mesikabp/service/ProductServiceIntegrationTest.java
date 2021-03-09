package fr.mesi.mesikabp.service;

import fr.mesi.mesikabp.model.Product;
import fr.mesi.mesikabp.repository.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class ProductServiceIntegrationTest {

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    @AfterEach
    void purgeBdd(){
        productRepository.deleteAll();
    }

    @Test
    void shouldCreateProductSuccess() {
        Product product = new Product();
        product.setCode("TEST");

        productService.createProduct(product);

        Optional<Product> productOptional = productRepository.findByCode("TEST");

        assertThat(productOptional).isPresent();
    }

    @Test
    void shouldCreateProductThrownEntityExistsException() {
        Product product = new Product();
        product.setCode("TEST");

        productService.createProduct(product);

        assertThatThrownBy(() -> productService.createProduct(product))
                .isInstanceOf(EntityExistsException.class)
                .hasMessageContaining(ProductServiceImpl.EXCEPTION_PRODUCT_CODE_ALREADY_EXISTS);
    }

    @Test
    void shouldGetProductByIdSuccess() {
        Product product = new Product();

        product = productRepository.save(product); //Premier produit donc a toujours le premier identifiant

        product = productService.getProductById(product.getId());

        assertThat(product).isNotNull();
    }

    @Test
    void shouldGetProductByIdThrownEntityNotFoundException() {
        Product product = new Product();

        product = productRepository.save(product); //Premier produit donc a toujours le premier identifiant

        assertThatThrownBy(() -> productService.getProductById(100L))
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessageContaining(ProductServiceImpl.EXCEPTION_PRODUCT_DOESNT_EXISTS);
    }
}
