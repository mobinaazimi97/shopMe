package com.mftplus.shopme.productPropertyValue.dto;

import com.mftplus.shopme.productPropertyValue.PropertyValue;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
public class PropertyValueDto {
    private Long id;
    private String propertyName;
    private String value;

    public PropertyValue getPropertyValue() {
        return PropertyValue.builder().id(id).propertyName(propertyName).value(value).build();
    }

}
