package com.mftplus.shopme.product;

import com.mftplus.shopme.product.dto.ProductDto;
import com.mftplus.shopme.product.mapper.ProductMapper;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductDto save(ProductDto productDto) {
        Product product = productMapper.getProductDto(productDto);
        Product saved = productRepository.save(product);
        return productMapper.toDto(saved);
    }

    public ProductDto update(Long id, ProductDto productDto) {
        Product existProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Product updatedEntity = productMapper.getProductDto(productDto);
        updatedEntity.setId(existProduct.getId());

        Product updated = productRepository.save(updatedEntity);
        return productMapper.toDto(updated);
    }

    public List<ProductDto> findAll() {
        return productMapper.toDtoAsList(productRepository.findAll());
    }

    public ProductDto findById(Long id) {
        return productRepository.findById(id)
                .map(productMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Product not found By Id"));
    }

    public void logicalRemove(Long id) {
        productRepository.logicalRemove(id);
    }
}
