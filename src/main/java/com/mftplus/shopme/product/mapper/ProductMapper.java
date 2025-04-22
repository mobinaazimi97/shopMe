package com.mftplus.shopme.product.mapper;

import com.mftplus.shopme.product.Product;
import com.mftplus.shopme.product.dto.ProductDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDto toDto(Product product);

    Product getProductDto(ProductDto productDto);

    List<ProductDto> toDtoAsList(List<Product> productList);

}
