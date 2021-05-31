package fr.mesi.mesikabp.controller;


import fr.mesi.mesikabp.model.Brand;
import fr.mesi.mesikabp.model.Product;
import fr.mesi.mesikabp.repository.BrandRepository;
import fr.mesi.mesikabp.repository.ProductRepository;
import fr.mesi.mesikabp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/home2")
public class HomeController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BrandRepository brandRepository;


    /**
     * listeBarand(pour le moment liste de toutes les marques)
     */
    @RequestMapping(method = RequestMethod.GET, value = "")
    public String ListeBrand(final ModelMap model,
                              @RequestParam Integer page,
                              @RequestParam Integer size,
                              @RequestParam String sortProperty,
                              @RequestParam String sortDirection) {
        Page<Brand> brands = brandRepository.findAll(PageRequest.of(page, size, Sort.Direction.fromString(sortDirection), sortProperty));
        if (!brands.isEmpty()) {
            model.put("brand", brands);
            model.put("start", (page) * size + 1);
            model.put("end", (page) * size + brands.getNumberOfElements());
            model.put("totalBrand", brands.getTotalElements());
            model.put("previousPage", page - 1);
            model.put("currentPage", page);
            model.put("nextPage", page + 1);
            model.put("isLastPage", brands.isLast());
        } else {

        }

        return "home2";
    }



    /**
     * listeBestProduct(pour le moment juste une liste de 10 produits peu importe lesquels)
     *
     */

    @RequestMapping(method = RequestMethod.GET, value = "")
    public String ListeBestProduct(final ModelMap model,
                             @RequestParam Integer page,
                             @RequestParam Integer size,
                             @RequestParam String sortProperty,
                             @RequestParam String sortDirection) {
        Page<Product> products = productRepository.findAll(PageRequest.of(page, 10, Sort.Direction.fromString(sortDirection), sortProperty));
        if (!products.isEmpty()) {
            model.put("products", products);
            model.put("start", (page) * size + 1);
            model.put("end", (page) * size + products.getNumberOfElements());
            model.put("totalProducts", products.getTotalElements());
            model.put("previousPage", page - 1);
            model.put("currentPage", page);
            model.put("nextPage", page + 1);
            model.put("isLastPage", products.isLast());
        } else {

        }

        return "home2";
    }



}
