package com.mftplus.shopme.groupProperty.dto;

import com.mftplus.shopme.groupProperty.GroupProperty;
import com.mftplus.shopme.productPropertyValue.dto.PropertyValueDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
public class GroupPropertyDto {
    private Long groupId;
    private String groupName;
    private PropertyValueDto propertyValueDto;

    public GroupProperty getGroupProperty() {
        return GroupProperty.builder()
                .id(groupId)
                .groupName(groupName)
                .propertyValue(this.propertyValueDto != null ? this.propertyValueDto.getPropertyValue() : null)

//                .propertyValue(propertyValueDto.getPropertyValue())
                .build();
    }

    public static GroupPropertyDto fromGroupProperty(GroupProperty groupProperty){
        return GroupPropertyDto.builder()
                .groupId(groupProperty.getId())
                .groupName(groupProperty.getGroupName())
                .build();

    }


}
