package fr.mesi.mesikabp.service;

import fr.mesi.mesikabp.dto.ProductDto;
import fr.mesi.mesikabp.dto.UserDto;
import fr.mesi.mesikabp.model.Product;
import fr.mesi.mesikabp.model.User;

public interface ModelMapService {
    UserDto convertToDto(User user);

    User convertToDao(UserDto userDto);

    ProductDto convertToDto(Product product);

    Product convertToDao(ProductDto productDto);
}
