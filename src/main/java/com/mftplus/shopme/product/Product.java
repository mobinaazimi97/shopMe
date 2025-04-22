package com.mftplus.shopme.product;

import com.mftplus.shopme.productGroup.ProductGroup;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString

@Entity(name = "productEntity")
@Table(name = "product_tbl")
@Cacheable
//@SQLRestriction("is_deleted=false")

public class Product {
    @Id
//    @SequenceGenerator(name = "productSeq", sequenceName = "product_seq", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productSeq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", length = 30) //todo nullable...
//  @Pattern(regexp = "^[a-zA-Z]{3,30}$",message = "invalid name!")
    private String productName;

    @Column(name = "price", length = 30)
//    @Pattern(regexp = "^[0-9]{2,30}$",message = "invalid price")
    @Min(value = 0, message = "Cant be negative")
    private Float price;

    @Column(name = "product_code")
    private String code;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pGroup")
    private ProductGroup productGroup;

    @Column(name = "is_deleted")
    private boolean isDeleted;
}
