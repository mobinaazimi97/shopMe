package com.mftplus.shopme.productPropertyValue;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PropertyValueRepository extends JpaRepository<PropertyValue, Long> {
//    @Override
    @Query("select v from valueEntity v where v.id=:id and v.isDeleted=false")
    Optional<PropertyValue> findActiveId(Long id);

    @Override
    @Query("select v from valueEntity v where v.isDeleted=false")
    List<PropertyValue> findAll();

    @Query("select v from valueEntity v where v.propertyName=:propertyName and v.value=:value")
    List<PropertyValue> findByNameAndValue(@Param("propertyName") String propertyName, @Param("value") String value);

    @Modifying
    @Query("update valueEntity v set v.isDeleted=true where v.id= :id")
    @Transactional
    void logicalRemove(@Param("id") Long id);
}
