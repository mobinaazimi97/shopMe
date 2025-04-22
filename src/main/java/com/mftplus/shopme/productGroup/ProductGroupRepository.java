package com.mftplus.shopme.productGroup;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductGroupRepository extends JpaRepository<ProductGroup, Long> {

    @Query("select p from productGroupEntity p where p.isDeleted=false")
    List<ProductGroup> findAll();

    @Query("select p from productGroupEntity p where p.id=:id and p.isDeleted=false")
   Optional<ProductGroup> findById(Long id);


    @Query("select p from productGroupEntity p where p.pGroupName = :pGroupName")
    List<ProductGroup> findByPGroupName(@Param("pGroupName") String pGroupName);

    @Modifying
    @Query("update productGroupEntity p set p.isDeleted=true where p.id= :id")
    @Transactional
    void logicalRemove(@Param("id") Long id);

    List<ProductGroup> findAllByParentId(Long parentId);
}
