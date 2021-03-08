package fr.mesi.mesikabp.repository;

import fr.mesi.mesikabp.model.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BasketRepository extends JpaRepository<Basket, Long> {

    @Query(value = "SELECT basket.* FROM Basket basket" +
            " WHERE idUser = :idUser", nativeQuery = true)
    Optional<Basket> findBasketLinkToUser(@Param("idUser") Long idUser);
}
