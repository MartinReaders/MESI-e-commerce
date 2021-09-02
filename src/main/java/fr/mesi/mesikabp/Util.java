package fr.mesi.mesikabp;

import fr.mesi.mesikabp.dto.UserDto;
import fr.mesi.mesikabp.model.Brand;
import fr.mesi.mesikabp.model.TypeProduct;
import org.springframework.ui.ModelMap;

import java.util.List;

public class Util {
    public static void putValueForHeader(ModelMap modelHeader, UserDto userDto, int nbProduct, List<Brand> brandList, List<TypeProduct> typeProductList) {
        modelHeader.put("user", userDto);
        modelHeader.put("nbProduct", nbProduct);
        modelHeader.put("listBrand", brandList);
        modelHeader.put("listTypeProduct", typeProductList);
    }
}
