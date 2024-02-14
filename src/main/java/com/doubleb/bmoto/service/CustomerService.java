package com.doubleb.bmoto.service;

import com.doubleb.bmoto.entity.Address;
import com.doubleb.bmoto.entity.User;
import com.doubleb.bmoto.entity.UserAddress;
import com.doubleb.bmoto.repository.AddressRepository;
import com.doubleb.bmoto.repository.UserAddressRepository;
import com.doubleb.bmoto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private UserRepository userRepository;
    private AddressRepository addressRepository;
    private UserAddressRepository userAddressRepository;

    public CustomerService() {
    }

    @Autowired
    public CustomerService(UserRepository userRepository, AddressRepository addressRepository, UserAddressRepository userAddressRepository) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.userAddressRepository = userAddressRepository;
    }

    public User getUserByUsername(String username){
        return userRepository.getUserByUsername(username);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public Address save(Address address){
        return addressRepository.save(address);
    }

    public UserAddress save(UserAddress userAddress){
        return userAddressRepository.save(userAddress);
    }
}
