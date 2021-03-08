package fr.mesi.mesikabp.service;

import fr.mesi.mesikabp.model.Basket;
import fr.mesi.mesikabp.model.LinkBasketProduct;
import fr.mesi.mesikabp.model.Product;
import fr.mesi.mesikabp.model.User;
import fr.mesi.mesikabp.repository.BasketRepository;
import fr.mesi.mesikabp.repository.LinkBasketProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityExistsException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
public class BasketServiceTest {

    @Mock
    private BasketRepository basketRepository;

    @Mock
    private LinkBasketProductRepository linkBasketProductRepository;

    @InjectMocks
    private BasketService basketService = new BasketServiceImpl();

    @Test
    void shouldAddProductToBasketSuccessWithAlreadyBasket() {
        User user = new User();
        user.setId(1L);
        Product product = new Product();
        product.setId(100L);
        product.setCode("LOGITECH");
        Basket basket = new Basket();
        basket.setId(10L);

        Mockito.when(basketRepository.findBasketLinkToUser(Mockito.anyLong())).thenReturn(Optional.of(basket));
        Mockito.when(linkBasketProductRepository.findBasketLine(Mockito.anyLong(), Mockito.anyLong()))
                .thenReturn(Optional.empty());

        basketService.addProductToBasket(user, product);

        Mockito.verify(linkBasketProductRepository, Mockito.times(1))
                .save(Mockito.any(LinkBasketProduct.class));
    }

    @Test
    void shouldAddProductToBasketSuccessWithoutBasket() {
        User user = new User();
        user.setId(1L);
        Product product = new Product();
        product.setId(100L);
        product.setCode("LOGITECH");
        Basket basket = new Basket();
        basket.setId(1000L);

        Mockito.when(basketRepository.findBasketLinkToUser(Mockito.anyLong())).thenReturn(Optional.empty());

        Mockito.when(basketRepository.save(Mockito.any(Basket.class))).thenReturn(basket);
        Mockito.when(linkBasketProductRepository.findBasketLine(Mockito.anyLong(), Mockito.anyLong()))
                .thenReturn(Optional.empty());

        basketService.addProductToBasket(user, product);

        Mockito.verify(basketRepository, Mockito.times(1)).save(Mockito.any(Basket.class));
        Mockito.verify(linkBasketProductRepository, Mockito.times(1))
                .save(Mockito.any(LinkBasketProduct.class));
    }

    @Test
    void shouldAddProductToBasketThrownEntityExistsException() {
        User user = new User();
        user.setId(1L);
        Product product = new Product();
        product.setId(100L);
        product.setCode("LOGITECH");
        Basket basket = new Basket();
        basket.setId(1000L);
        LinkBasketProduct linkBasketProduct = new LinkBasketProduct();

        Mockito.when(basketRepository.findBasketLinkToUser(Mockito.anyLong())).thenReturn(Optional.of(basket));

        Mockito.when(linkBasketProductRepository.findBasketLine(Mockito.anyLong(), Mockito.anyLong()))
                .thenReturn(Optional.of(linkBasketProduct));

        assertThatThrownBy(() -> basketService.addProductToBasket(user, product))
                .isInstanceOf(EntityExistsException.class)
                .hasMessageContaining("Le produit est déjà dans votre panier !");
    }
}
