package com.mftplus.shopme.productPropertyValue;

import com.mftplus.shopme.productPropertyValue.dto.PropertyValueDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/values")
public class PropertyValueController {

    private final PropertyValueService propertyValueService;

    public PropertyValueController(PropertyValueService propertyValueService) {
        this.propertyValueService = propertyValueService;
    }

    @GetMapping
    public List<PropertyValueDto> getPropertyValues() {
        return propertyValueService.findAll();
    }
}
