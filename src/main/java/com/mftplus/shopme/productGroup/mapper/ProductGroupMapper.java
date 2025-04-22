package com.mftplus.shopme.productGroup.mapper;

import com.mftplus.shopme.productGroup.ProductGroup;
import com.mftplus.shopme.productGroup.dto.ProductGroupDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductGroupMapper {

    ProductGroupDto toDto(ProductGroup productGroup);

    ProductGroup getProductGroupDto(ProductGroupDto productGroupDto);

    List<ProductGroupDto> toDtoAsList(List<ProductGroup> productGroupList);

}
