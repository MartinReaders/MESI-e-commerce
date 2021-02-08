package fr.mesi.mesikabp.repository;


import fr.mesi.mesikabp.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends CrudRepository<Product, Long> {


}
