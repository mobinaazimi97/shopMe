package com.mftplus.shopme.productGroup;

import com.fasterxml.jackson.annotation.*;
import com.mftplus.shopme.groupProperty.GroupProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLRestriction;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
//@ToString

@Entity(name = "productGroupEntity")
@Table(name = "productGroup_tbl")
@Cacheable
public class ProductGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "p_groupName")
//    @Pattern(regexp = "^[a-zA-Z]{3,30}$", message = "invalid name!")
    private String pGroupName;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "parent", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<ProductGroup> childList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "parent_id")
    private ProductGroup parent;

    @ManyToOne(fetch = FetchType.EAGER)
//    @JsonManagedReference
    private GroupProperty groupProperty;

    @Column(name = "is_deleted")
    private boolean isDeleted ;

}
