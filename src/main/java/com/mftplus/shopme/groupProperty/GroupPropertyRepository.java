package com.mftplus.shopme.groupProperty;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupPropertyRepository extends JpaRepository<GroupProperty, Long> {

    @Override
    @Query("select g from groupProEntity g where g.isDeleted=false ")
    List<GroupProperty> findAll();

    @Override
    @Query("select g from groupProEntity g where g.id=:id and g.isDeleted=false ")
    Optional<GroupProperty> findById(Long id);

    @Query("select g from groupProEntity g where g.groupName = :groupName")
    GroupProperty findByName(@Param("groupName") String groupName);

    @Modifying
    @Query("update groupProEntity g set g.isDeleted=true where g.id= :id")
    @Transactional
    void logicalRemove(@Param("id") Long id);
}
