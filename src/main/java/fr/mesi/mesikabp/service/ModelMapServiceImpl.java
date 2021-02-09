package fr.mesi.mesikabp.service;

import fr.mesi.mesikabp.dto.ProductDto;
import fr.mesi.mesikabp.dto.UserDto;
import fr.mesi.mesikabp.model.Product;
import fr.mesi.mesikabp.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModelMapServiceImpl implements ModelMapService {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto convertToDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public User convertToDao(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }

    @Override
    public ProductDto convertToDto(Product product) {
        return modelMapper.map(product, ProductDto.class);
    }

    @Override
    public Product convertToDao(ProductDto productDto) {
        return modelMapper.map(productDto, Product.class);
    }
}
