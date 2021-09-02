package fr.mesi.mesikabp.repository;

import fr.mesi.mesikabp.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByCode(String codeProduit);
    @Query(value = "SELECT * FROM product WHERE idBrand = ?1 ORDER BY ?#{#pageable}"
            , countQuery = "SELECT count(*) FROM product WHERE idBrand = ?1"
            , nativeQuery = true)
    Page<Product> findAllByBrand(Long idBrand, Pageable pageable);

    @Query(value = "SELECT COUNT(idProduct) FROM score_user_product WHERE idProduct = :idProduct",
        nativeQuery = true)
    Integer countAllLike(@Param("idProduct") Long idProduct);
}
