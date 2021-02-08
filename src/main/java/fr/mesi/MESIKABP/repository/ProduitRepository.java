package fr.mesi.MESIKABP.repository;


import fr.mesi.MESIKABP.model.Produit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends CrudRepository<Produit, Long> {


}
