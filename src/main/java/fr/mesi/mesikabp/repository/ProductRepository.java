package fr.mesi.mesikabp.repository;

import fr.mesi.mesikabp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByCode(String codeProduit);
}
