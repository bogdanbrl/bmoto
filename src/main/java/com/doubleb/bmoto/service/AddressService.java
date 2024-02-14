package com.doubleb.bmoto.service;

import com.doubleb.bmoto.entity.Address;
import com.doubleb.bmoto.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private AddressRepository addressRepository;

    public AddressService() {
    }

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address getAddressByUserId(Long id) {
        Address address = addressRepository.getAddressByUserId(id).orElse(new Address());
        return address;
    }
}
