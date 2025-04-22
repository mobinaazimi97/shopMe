package com.mftplus.shopme.productGroup.dto;

import com.mftplus.shopme.groupProperty.dto.GroupPropertyDto;
import com.mftplus.shopme.productGroup.ProductGroup;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
//@ToString
public class ProductGroupDto {

    private Long id;
    private String name;
//    private ProductGroupDto parent;
    private List<ProductGroupDto> childList;
    private GroupPropertyDto groupPropertyDto;

    public ProductGroup getProductGroup() {
        return ProductGroup.builder()
                .id(this.id)
                .pGroupName(this.name)
                .groupProperty(this.groupPropertyDto != null ? this.groupPropertyDto.getGroupProperty() : null)
//                .parent(this.parent != null ? this.parent.getProductGroup() : null) // Recursive parent conversion
                .childList(
                        this.childList != null ?
                                this.childList.stream().map(ProductGroupDto::getProductGroup).collect(Collectors.toList())  // Recursive child conversion
                                : Collections.emptyList()
                )
                .build();
    }

    public static ProductGroupDto fromProductGroup(ProductGroup productGroup) {
        if (productGroup == null) return null;

        return ProductGroupDto.builder()
                .id(productGroup.getId())
                .name(productGroup.getPGroupName())
                .childList(
                        productGroup.getChildList() != null ?
                                productGroup.getChildList().stream()
                                        .map(ProductGroupDto::fromProductGroup)
                                        .collect(Collectors.toList())
                                : Collections.emptyList()
                )
                .build();
    }


    @Override
    public String toString() {
//        String parentDetails = (parent != null) ? "Parent(Name: " + parent.getName() + ", ID: " + parent.getId() + ")" : "No Parent";
        String childDetails = (childList != null && !childList.isEmpty()) ?
                childList.stream().map(child -> "Child(Name: " + child.getName() + ", ID: " + child.getId() + ")").collect(Collectors.joining(", "))
                : "No Children";

        return "ProductGroupDto(GroupProperty:" + groupPropertyDto + ",  ID: " + id + ", Name: " + name + ", " + childDetails + ")";

    //+ parentDetails + ", "
    }

}
