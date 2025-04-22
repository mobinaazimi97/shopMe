package com.mftplus.shopme.product.dto;

import com.mftplus.shopme.product.Product;
import com.mftplus.shopme.productGroup.dto.ProductGroupDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
public class ProductDto {
    private Long id;
    private String productName;
    private Float price;
    private String code;
    private ProductGroupDto productGroupDto;

    public Product getProduct() {
        return Product.builder().
                id(id)
                .productName(productName)
                .price(price)
                .code(code)
//                .productGroup(productGroupDto)
//                .productGroup(productGroupDto.getProductGroup())
                .build();
    }

}
