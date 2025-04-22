package com.mftplus.shopme.productPropertyValue;

import com.mftplus.shopme.productPropertyValue.dto.PropertyValueDto;
import com.mftplus.shopme.productPropertyValue.mapper.PropertyValueMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PropertyValueService {
    private final PropertyValueRepository propertyValueRepository;
    private final PropertyValueMapper propertyValueMapper;

    public PropertyValueService(PropertyValueRepository propertyValueRepository, PropertyValueMapper propertyValueMapper) {
        this.propertyValueRepository = propertyValueRepository;
        this.propertyValueMapper = propertyValueMapper;
    }

    public PropertyValueDto save(PropertyValueDto propertyValueDto) {
        PropertyValue propertyValue = propertyValueMapper.getPropertyValueDto(propertyValueDto);
        PropertyValue saved = propertyValueRepository.save(propertyValue);
        return propertyValueMapper.toDto(saved);
    }

    public PropertyValueDto update(Long id, PropertyValueDto propertyValueDto) {
        PropertyValue existValue = propertyValueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product PropertyValue not found"));
        PropertyValue updatedPropertyValue = propertyValueMapper.getPropertyValueDto(propertyValueDto);
        updatedPropertyValue.setId(existValue.getId());
        PropertyValue updated = propertyValueRepository.save(updatedPropertyValue);
        return propertyValueMapper.toDto(updated);
    }

    public List<PropertyValueDto> findAll() {
        return propertyValueMapper.toDtoAsList(propertyValueRepository.findAll());
    }

    public PropertyValueDto findById(Long id) {
        return propertyValueRepository.findById(id)
                .map(propertyValueMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Product Property Value not found"));
    }

    public void logicalRemove(Long id) {
        propertyValueRepository.logicalRemove(id);
    }
}
