package com.doubleb.bmoto.repository;

import com.doubleb.bmoto.entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SizeRepository extends JpaRepository<Size, Long> {

    @Query("select s from Size s")
    List<Size> findAllSizes();

    @Query("select size as size from Size size " +
            "join size.products as product " +
            "where product.id = ?1")
    List<Size> findAllSizesByProductId(Long id);

}
