package com.mftplus.shopme;

import com.mftplus.shopme.groupProperty.GroupPropertyService;
import com.mftplus.shopme.groupProperty.dto.GroupPropertyDto;
import com.mftplus.shopme.product.ProductService;
import com.mftplus.shopme.product.dto.ProductDto;
import com.mftplus.shopme.productGroup.ProductGroup;
import com.mftplus.shopme.productGroup.ProductGroupService;
import com.mftplus.shopme.productGroup.dto.ProductGroupDto;
import com.mftplus.shopme.productPropertyValue.PropertyValueRepository;
import com.mftplus.shopme.productPropertyValue.PropertyValueService;
import com.mftplus.shopme.productPropertyValue.dto.PropertyValueDto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductTest implements CommandLineRunner {
    private final GroupPropertyService groupPropertyService;
    private final ProductService productService;
    private final PropertyValueService propertyValueService;
    private final ProductGroupService productGroupService;
    private final PropertyValueRepository propertyValueRepository;

    public ProductTest(GroupPropertyService groupPropertyService, ProductService productService, PropertyValueService propertyValueService, ProductGroupService productGroupService, PropertyValueRepository propertyValueRepository) {
        this.groupPropertyService = groupPropertyService;
        this.productService = productService;
        this.propertyValueService = propertyValueService;
        this.productGroupService = productGroupService;
        this.propertyValueRepository = propertyValueRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//        ProductDto productDto = ProductDto.builder().productName("laptop").code("123").price(2F).build();
//        productService.save(productDto);
//        System.out.println("Product DTO Saved :"+productDto);
//        System.out.println("Product By Name :"+productService.findByName("laptop"));
//        System.out.println("Product By Id :"+productService.findById(1L));
//        productService.logicalRemove(1L);
//        productService.logicalRemove(1L);
//        System.out.println("Product By Id after logical remove :"+productService.findById(1L));
//        System.out.println("Product Removed By Id :"+productDto.getProduct().getId());
//        System.out.println("All Products :"+productService.findAll());

        PropertyValueDto propertyValueDto = PropertyValueDto.builder()
                .propertyName("Ram :")
                .value("64")
                .build();
        propertyValueService.save(propertyValueDto);

        PropertyValueDto propertyValueDto1 = PropertyValueDto.builder()
                .propertyName("Cpu :")
                .value("8")
                .build();
        propertyValueService.save(propertyValueDto1);

//        System.out.println("Property Value Dto Saved :"+propertyValueDto);
//        System.out.println("Property Value Dto By ID :"+propertyValueService.findById(1L));
//        System.out.println("Property Value Dto Get All :"+propertyValueService.findAll());
//        System.out.println("Property Found :"+propertyValueService.findByValueAndName("Ram :","64"));

//        System.out.println("Value found Id :" + propertyValueService.findById(1L));
//        propertyValueService.logicalRemove(1L);
//        System.out.println("All Values :"+propertyValueService.findAll());
//        System.out.println("Value Removed By Id :" + propertyValueDto.getId());


        GroupPropertyDto groupPropertyDto = GroupPropertyDto.builder()
                .groupName("electronic")
                .propertyValueDto(propertyValueDto)
                .build();
        groupPropertyService.save(groupPropertyDto);


        GroupPropertyDto groupPropertyDto1 = GroupPropertyDto.builder()
                .groupName("chemicals")
                .build();
        groupPropertyService.save(groupPropertyDto1);
//        System.out.println("Group Property Saved :"+groupPropertyDto);
//        System.out.println("Group Property By Id :"+groupPropertyService.findById(1L));
//        System.out.println("Group Property Get All :"+groupPropertyService.findAll());

//        System.out.println("Group Property Found By ID :"+groupPropertyService.findById(1L));
//        groupPropertyService.logicalRemove(1L);
//        System.out.println("Group Property Deleted :"+groupPropertyService.findById(1L));
//        System.out.println("All Groups :"+groupPropertyService.findAll());
//        System.out.println("Groups With Name :"+groupPropertyService.findByName("electronic"));


//        ProductGroupDto child2 = new ProductGroupDto();
//        ProductGroupDto parent3 = new ProductGroupDto();
//
//        parent3.setName("digital");
//        child2.setParent(parent3);

        ProductGroupDto child = ProductGroupDto.builder()
                .name("Smartphones")
                .build();

        // سطح دوم: پدرِ child
        ProductGroupDto parent = ProductGroupDto.builder()
                .name("Mobile")
                .childList(List.of(child))
                .build();

        child.setName("phone"); // اتصال به والد
        ProductGroupDto root = ProductGroupDto.builder()
                .name("Digital")
                .childList(List.of(parent))
                .build();

        parent.setName("mobile"); // اتصال به والد

        // ذخیره فقط root، بقیه با Cascade ذخیره می‌شن
        productGroupService.save(root);
        System.out.println("Saved Product Group "+root);




        ProductDto productDto = ProductDto.builder()
//                .productGroupDto(productGroupDto)
                .productName("Laptop")
                .code("123")
                .price(23F)
                .build();
        productService.save(productDto);
//        System.out.println("Product Saved :"+productDto);
//        System.out.println("Product Get All :"+productService.findAll());
//        System.out.println("Product Get Id :"+productService.findById(1L));
//
//        ProductGroupDto laptops = ProductGroupDto.builder()
//                .pGroupName("Laptops")
//                .parent(ProductGroupDto.builder().id(parent.getId()).build())
//                .build();
//        laptops = productGroupService.save(laptops);
//
//        System.out.println("Saved Group: " + laptops);
//
//        ProductGroupDto found = productGroupService.findById(laptops.getId());
//        System.out.println("Found Group: " + found);



//        productGroupService.save(productGroupDto);
//        System.out.println("Product Group Saved :"+productGroupDto);
//        System.out.println("Product Group Found Id :"+productGroupService.findById(1L));
//        System.out.println("Product Group Found All :"+productGroupService.findAll());

    }
}
