package com.mftplus.shopme.productGroup;

import com.mftplus.shopme.productGroup.dto.ProductGroupDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pGroups")
public class ProductGroupController {
    private final ProductGroupService productGroupService;

    public ProductGroupController(ProductGroupService productGroupService) {
        this.productGroupService = productGroupService;
    }

    @GetMapping
    public ResponseEntity<List<ProductGroupDto>> getAll() {
        return ResponseEntity.ok(productGroupService.findAll());

    }
}
