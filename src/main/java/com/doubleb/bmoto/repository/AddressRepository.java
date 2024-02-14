package com.doubleb.bmoto.repository;

import com.doubleb.bmoto.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query("select address as address from Address address " +
            "join address.userAddresses as us " +
            "join us.user as user " +
            "where user.id = ?1")
    Optional<Address> getAddressByUserId(Long id);
}
