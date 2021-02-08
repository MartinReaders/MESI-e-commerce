package fr.mesi.mesikabp.repository;


import fr.mesi.mesikabp.model.Produit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends CrudRepository<Produit, Long> {


}
