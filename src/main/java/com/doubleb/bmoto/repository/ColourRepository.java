package com.doubleb.bmoto.repository;

import com.doubleb.bmoto.entity.Colour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColourRepository extends JpaRepository<Colour, Long> {

    @Query("select c from Colour c")
    List<Colour> findAllColours();

    @Query("select colour as colour from Colour colour " +
            "join colour.products as product " +
            "where product.id = ?1")
    List<Colour> findAllColoursByProductId(Long id);
}
