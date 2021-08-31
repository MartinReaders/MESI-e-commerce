package fr.mesi.mesikabp.service;

import fr.mesi.mesikabp.model.User;
import fr.mesi.mesikabp.repository.BasketRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
class BasketServiceTest {

    @Mock
    private BasketRepository basketRepository;

    @InjectMocks
    private BasketService basketService = new BasketServiceImpl();

//    @Test
//    void shouldAddProductToBasketSuccessWithAlreadyBasket() {
//        User user = new User();
//        user.setId(1L);
//        Product product = new Product();
//        product.setId(100L);
//        product.setCode("LOGITECH");
//        Basket basket = new Basket();
//        basket.setId(10L);
//
//        Mockito.when(basketRepository.findBasketLinkToUser(Mockito.anyLong())).thenReturn(Optional.of(basket));
//        Mockito.when(linkBasketProductRepository.findBasketLine(Mockito.anyLong(), Mockito.anyLong()))
//                .thenReturn(Optional.empty());
//
//        basketService.addProductToBasket(user, product);
//
//        Mockito.verify(linkBasketProductRepository, Mockito.times(1))
//                .save(Mockito.any(LinkBasketProduct.class));
//    }
//
//    @Test
//    void shouldAddProductToBasketSuccessWithoutBasket() {
//        User user = new User();
//        user.setId(1L);
//        Product product = new Product();
//        product.setId(100L);
//        product.setCode("LOGITECH");
//        Basket basket = new Basket();
//        basket.setId(1000L);
//
//        Mockito.when(basketRepository.findBasketLinkToUser(Mockito.anyLong())).thenReturn(Optional.empty());
//
//        Mockito.when(basketRepository.save(Mockito.any(Basket.class))).thenReturn(basket);
//        Mockito.when(linkBasketProductRepository.findBasketLine(Mockito.anyLong(), Mockito.anyLong()))
//                .thenReturn(Optional.empty());
//
//        basketService.addProductToBasket(user, product);
//
//        Mockito.verify(basketRepository, Mockito.times(1)).save(Mockito.any(Basket.class));
//        Mockito.verify(linkBasketProductRepository, Mockito.times(1))
//                .save(Mockito.any(LinkBasketProduct.class));
//    }
//
//    @Test
//    void shouldAddProductToBasketThrownEntityExistsException() {
//        User user = new User();
//        user.setId(1L);
//        Product product = new Product();
//        product.setId(100L);
//        product.setCode("LOGITECH");
//        Basket basket = new Basket();
//        basket.setId(1000L);
//        LinkBasketProduct linkBasketProduct = new LinkBasketProduct();
//
//        Mockito.when(basketRepository.findBasketLinkToUser(Mockito.anyLong())).thenReturn(Optional.of(basket));
//
//        Mockito.when(linkBasketProductRepository.findBasketLine(Mockito.anyLong(), Mockito.anyLong()))
//                .thenReturn(Optional.of(linkBasketProduct));
//
//        assertThatThrownBy(() -> basketService.addProductToBasket(user, product))
//                .isInstanceOf(EntityExistsException.class)
//                .hasMessageContaining(BasketServiceImpl.EXCEPTION_PRODUCT_ALREADY_IN_BASKET);
//    }
//
//    @Test
//    void shouldDeleteProductToBasketSuccess() {
//        User user = new User();
//        user.setId(1L);
//        Product product = new Product();
//        product.setId(100L);
//        product.setCode("LOGITECH");
//        Basket basket = new Basket();
//        basket.setId(1000L);
//        LinkBasketProduct linkBasketProduct = new LinkBasketProduct();
//
//        Mockito.when(basketRepository.findBasketLinkToUser(Mockito.anyLong())).thenReturn(Optional.of(basket));
//
//        Mockito.when(linkBasketProductRepository.findBasketLine(Mockito.anyLong(), Mockito.anyLong()))
//                .thenReturn(Optional.of(linkBasketProduct));
//
//        basketService.deleteProductToBasket(user, product);
//
//        Mockito.verify(linkBasketProductRepository, Mockito.times(1))
//                .delete(Mockito.any(LinkBasketProduct.class));
//    }
//
//    @Test
//    void shouldDeleteProductToBasketThrownEntityNotFoundExceptionBecauseBasketDoesntExist() {
//        User user = new User();
//        user.setId(1L);
//        Product product = new Product();
//        product.setId(100L);
//        product.setCode("LOGITECH");
//        Basket basket = new Basket();
//        basket.setId(1000L);
//
//        Mockito.when(basketRepository.findBasketLinkToUser(Mockito.anyLong())).thenReturn(Optional.empty());
//
//        assertThatThrownBy(() -> basketService.deleteProductToBasket(user, product))
//                .isInstanceOf(EntityNotFoundException.class)
//                .hasMessageContaining(BasketServiceImpl.EXCEPTION_BASKET_DOESNT_EXISTS);
//    }
//
//    @Test
//    void shouldDeleteProductToBasketThrownEntityNotFoundExceptionBecauseProductDoesntExistInBasket() {
//        User user = new User();
//        user.setId(1L);
//        Product product = new Product();
//        product.setId(100L);
//        product.setCode("LOGITECH");
//        Basket basket = new Basket();
//        basket.setId(1000L);
//
//        Mockito.when(basketRepository.findBasketLinkToUser(Mockito.anyLong())).thenReturn(Optional.of(basket));
//        Mockito.when(linkBasketProductRepository.findBasketLine(Mockito.anyLong(), Mockito.anyLong()))
//                .thenReturn(Optional.empty());
//
//        assertThatThrownBy(() -> basketService.deleteProductToBasket(user, product))
//                .isInstanceOf(EntityNotFoundException.class)
//                .hasMessageContaining(BasketServiceImpl.EXCEPTION_PRODUCT_NOT_IN_BASKET);
//    }
//
//    @Test
//    void shouldDumpBasketSuccess() {
//        User user = new User();
//        user.setId(1L);
//        Basket basket = new Basket();
//        basket.setId(1000L);
//
//        Mockito.when(basketRepository.findBasketLinkToUser(Mockito.anyLong())).thenReturn(Optional.of(basket));
//
//        basketService.dumpBasket(user);
//
//        Mockito.verify(linkBasketProductRepository, Mockito.times(1))
//                .deleteAllBasketLineOfBasket(Mockito.anyLong());
//    }

    @Test
    void shouldDumpBasketThrownEntityNotFoundExceptionBecauseBasketDoesntExists() {
        User user = new User();
        user.setId(1L);

        Mockito.when(basketRepository.findBasketLinkToUser(Mockito.anyLong())).thenReturn(Optional.empty());

        assertThatThrownBy(() -> basketService.dumpBasket(user))
                .isInstanceOf(EntityNotFoundException.class)
                .hasMessageContaining(BasketServiceImpl.EXCEPTION_BASKET_DOESNT_EXISTS);
    }
}
