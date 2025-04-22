package com.mftplus.shopme.groupProperty;

import com.mftplus.shopme.productPropertyValue.PropertyValue;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@NoArgsConstructor
@Setter
@Getter
@SuperBuilder
@ToString
@Entity(name = "groupProEntity")
@Table(name = "group_property_tbl")
@Cacheable
public class GroupProperty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "group_name")
    private String groupName;

    //cascade = CascadeType.PERSIST,
    @ManyToOne(fetch = FetchType.EAGER)
//    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "value_info")
    private PropertyValue propertyValue;

    @Column(name = "is_deleted")
    private boolean isDeleted ;
}
