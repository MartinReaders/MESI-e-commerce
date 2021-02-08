package fr.mesi.mesikabp.controller;


import fr.mesi.mesikabp.model.Produit;
import fr.mesi.mesikabp.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Controller
@RequestMapping("/produits")
public class ProduitController {


    @Autowired
    private ProduitRepository produitRepository;


    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public String getProduitParId(@PathVariable Long id, final ModelMap model){
        Optional<Produit> produitOptional = produitRepository.findById(id);
        if(produitOptional.isEmpty()){
            throw new EntityNotFoundException("Produit " + id + " n'a pas ete trouve ! ");
        }
        model.put("produit", produitOptional.get());
        return "detaileProduit";
    }

}
