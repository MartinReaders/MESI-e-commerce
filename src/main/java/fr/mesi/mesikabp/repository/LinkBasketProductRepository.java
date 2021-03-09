package fr.mesi.mesikabp.repository;

import fr.mesi.mesikabp.model.LinkBasketProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LinkBasketProductRepository extends JpaRepository<LinkBasketProduct, Long> {

    @Query(value = "SELECT pb.* FROM product_basket pb" +
            "WHERE idBasket = :idBasket AND idProduct = :idProduct", nativeQuery = true)
    Optional<LinkBasketProduct> findBasketLine(@Param("idBasket") Long idBasket, @Param("idProduct") Long idProduct);

    @Query(value = "DELETE FROM product_basket " +
            "WHERE idBasket = :idBasket", nativeQuery = true)
    void deleteAllBasketLineOfBasket(@Param("idBasket") Long idBasket);
}
