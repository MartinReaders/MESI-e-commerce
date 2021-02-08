package fr.mesi.mesikabp.repository;

import fr.mesi.mesikabp.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Produit, Long> {
    Optional<Produit> findByCode(String codeProduit);
}
