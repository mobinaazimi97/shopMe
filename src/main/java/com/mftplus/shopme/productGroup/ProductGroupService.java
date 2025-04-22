package com.mftplus.shopme.productGroup;

import com.mftplus.shopme.productGroup.dto.ProductGroupDto;
import com.mftplus.shopme.productGroup.mapper.ProductGroupMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProductGroupService {
    private final ProductGroupRepository productGroupRepository;
    private final ProductGroupMapper productGroupMapper;

    public ProductGroupService(ProductGroupRepository productGroupRepository, ProductGroupMapper productGroupMapper) {
        this.productGroupRepository = productGroupRepository;
        this.productGroupMapper = productGroupMapper;
    }


    public ProductGroupDto save(ProductGroupDto productGroupDto) {
        ProductGroup entity = productGroupMapper.getProductGroupDto(productGroupDto);
        ProductGroup saved = productGroupRepository.save(entity);
        return productGroupMapper.toDto(saved);
    }


    public ProductGroupDto update(Long id, ProductGroupDto productGroupDto) {
        ProductGroup existProductGroup = productGroupRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product Group not found"));
        ProductGroup updatedProductGroup = productGroupMapper.getProductGroupDto(productGroupDto);
        updatedProductGroup.setId(existProductGroup.getId());
        ProductGroup updated = productGroupRepository.save(updatedProductGroup);
        return productGroupMapper.toDto(updated);
    }

    private ProductGroup addChildList(ProductGroup parent) {
        // پیدا کردن فرزندهای این parent
        List<ProductGroup> children = productGroupRepository.findAllByParentId(parent.getId());
        parent.setChildList(children);  // پر کردن childList برای هر parent

        // به‌طور بازگشتی برای هر فرزند، childList اونها رو هم پر می‌کنیم
        for (ProductGroup child : children) {
            addChildList(child);
        }

        return parent; // برگرداندن parent با childList پر شده
    }

    public List<ProductGroupDto> findAll() {
        List<ProductGroup> roots = productGroupRepository.findAll();
        return roots.stream()
                .map(ProductGroupDto::fromProductGroup)
                .collect(Collectors.toList());
//        return productGroupMapper.toDtoAsList(productGroupRepository.findAll());
    }

    public ProductGroupDto findById(Long id) {
        return productGroupRepository.findById(id)
                .map(productGroupMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Product Group not found"));
    }

    public void logicalRemove(Long id) {
        productGroupRepository.logicalRemove(id);
    }
}
