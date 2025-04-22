package com.mftplus.shopme.groupProperty.mapper;

import com.mftplus.shopme.groupProperty.GroupProperty;
import com.mftplus.shopme.groupProperty.dto.GroupPropertyDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GroupPropertyMapper {

    GroupPropertyDto toDto(GroupProperty groupProperty);

    GroupProperty getPropertyDto(GroupPropertyDto groupPropertyDto);

    List<GroupPropertyDto> toDtoAsList(List<GroupProperty> groupPropertyList);
}
