package com.mftplus.shopme.product;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

//    @Override
    @Query("select p from productEntity p where p.isDeleted=false ")
    List<Product> findAll();

//    @Override
    @Query("select p from productEntity p where p.id=:id and p.isDeleted=false ")
    Optional<Product> findById(Long id);

    @Modifying
    @Query("update productEntity p set p.isDeleted=true where p.id= :id")
    @Transactional
    void logicalRemove(@Param("id") Long id);

    @Query("select p from productEntity p where p.productName like:productName and p.isDeleted=false ")
    List<Product> findByName(@Param("productName") String productName);

    @Query("select p from productEntity p join fetch p.productGroup where p.productGroup.id = :id")
    Product findByProductGroupId(@Param("id") Long id);

    @Query("select p from productEntity p join fetch p.productGroup where p.productGroup.pGroupName = :pGroupName")
    Product findByProductGroupName(@Param("pGroupName") String pGroupName);

    @Query("select p from productEntity p join fetch p.productGroup where p.productGroup.pGroupName = :pGroupName and p.productName = :productName")
    Product findByProductNameAndProductGroupName(@Param("pGroupName") String pGroupName, @Param("productName") String productName);

}
