package com.mftplus.shopme.productPropertyValue.mapper;

import com.mftplus.shopme.productPropertyValue.PropertyValue;
import com.mftplus.shopme.productPropertyValue.dto.PropertyValueDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PropertyValueMapper {

    PropertyValueDto toDto(PropertyValue propertyValue);

    PropertyValue getPropertyValueDto(PropertyValueDto propertyValueDto);

    List<PropertyValueDto> toDtoAsList(List<PropertyValue> propertyValueList);

}
