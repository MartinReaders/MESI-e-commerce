package fr.mesi.mesikabp.service;

import fr.mesi.mesikabp.model.Product;
import fr.mesi.mesikabp.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private final ProductService productService = new ProductServiceImpl();

    @Test
    void shouldCreateProductSuccess() {
        final Product product = new Product();
        product.setCode("G603");

        Mockito.when(productRepository.findByCode(product.getCode())).thenReturn(Optional.empty());
//        https://stackoverflow.com/questions/36615330/mockito-doanswer-vs-thenreturn
//        Mockito.when(productRepository.save(product)).thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        productService.createProduct(product);

        Mockito.verify(productRepository, Mockito.times(1)).save(Mockito.any(Product.class));
    }

    @Test
    void shouldCreateProductThrownEntityExistException() {
        final Product product = new Product();
        product.setCode("G603");
        Mockito.when(productRepository.findByCode(product.getCode())).thenReturn(Optional.of(product));

        assertThatThrownBy(() -> productService.createProduct(product))
                .isInstanceOf(EntityExistsException.class)
                .hasMessageContaining(ProductServiceImpl.EXCEPTION_PRODUCT_CODE_ALREADY_EXISTS);
    }

    @Test
    void shouldGetProductByIdSuccess() {
        final Product product = new Product();

        Mockito.when(productRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(product));

        productService.getProductById(1L);

        Mockito.verify(productRepository, Mockito.times(1)).findById(Mockito.anyLong());
    }

    @Test
    void shouldGetProductByIdThrownEntityNotFoundException() {
        Mockito.when(productRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());

        assertThatThrownBy(() -> productService.getProductById(1L))
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessageContaining(ProductServiceImpl.EXCEPTION_PRODUCT_DOESNT_EXISTS);
    }

    @Test
    void shouldGetProductByFilterSuccess() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product());
        productList.add(new Product());
        productList.add(new Product());
        productList.add(new Product());
        productList.add(new Product());

        Page<Product> productPage = new PageImpl<>(productList);

        Mockito.when(productRepository.findAll(PageRequest.of(1, 5))).thenReturn(productPage);

        Page<Product> page = productService.getProductByFilter(1, 5, 0L, 0L);
        assertThat(page).hasSize(5);
    }

    @Test
    void shouldGetProductByFilterThrownIllegalArgumentExceptionBecausePageIsNegative() {
        assertThatThrownBy(() -> productService.getProductByFilter(-1, 1, 0L, 0L))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ProductServiceImpl.EXCEPTION_NEGATIVE_PAGE);
    }

    @Test
    void shouldGetProductByFilterThrownIllegalArgumentExceptionBecauseSizeIsUnderOne() {
        assertThatThrownBy(() -> productService.getProductByFilter(0, 0, 0L, 0L))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ProductServiceImpl.EXCEPTION_SIZE_PAGE_NULL);
    }

    @Test
    void shouldDeleteProductSuccess() {
        Product product = new Product();
        product.setId(1L);

        Mockito.when(productRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(product));

        productService.deleteProduct(product.getId());

        Mockito.verify(productRepository, Mockito.times(1))
                .delete(Mockito.any(Product.class));
    }

    @Test
    void shouldDeleteProductThrownEntityNotFoundException() {
        Product product = new Product();
        product.setId(1L);

        Mockito.when(productRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());

        assertThatThrownBy(() -> productService.deleteProduct(product.getId()))
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessageContaining(ProductServiceImpl.EXCEPTION_PRODUCT_DOESNT_EXISTS);
    }
}
