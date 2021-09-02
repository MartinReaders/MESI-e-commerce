package fr.mesi.mesikabp.repository;

import fr.mesi.mesikabp.model.Product;
import fr.mesi.mesikabp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLogin(String login);

    @Query(value = "SELECT product.* FROM score_user_product " +
            "INNER JOIN product ON product.idProduct = score_user_product.idProduct WHERE score_user_product.idUser = :idUser"
        , nativeQuery = true)
    List<Product> findAllProductLikeByUser(@Param("idUser") Long idUser);
}
