package com.doubleb.bmoto.repository;

import com.doubleb.bmoto.entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenderRepository extends JpaRepository<Gender, Long> {

    @Query("select g from Gender g")
    List<Gender> findAllGenders();
}
