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
    @Query(value = "SELECT p FROM Product p WHERE idBrand = ?1")
    Page<Product> findAllByBrand(Long idBrand, Pageable pageable);

    @Query(value = "SELECT p FROM Product p WHERE idTypeProduct = ?1")
    Page<Product> findAllByType(Long idType, Pageable pageable);

    @Query(value = "SELECT p FROM Product p WHERE idTypeProduct = ?1 AND idBrand = ?2")
    Page<Product> findAllByTypeAndBrand(Long idType, Long idBrand, Pageable pageable);


    @Query(value = "SELECT COUNT(idProduct) FROM score_user_product WHERE idProduct = :idProduct",
        nativeQuery = true)
    Integer countAllLike(@Param("idProduct") Long idProduct);
}
