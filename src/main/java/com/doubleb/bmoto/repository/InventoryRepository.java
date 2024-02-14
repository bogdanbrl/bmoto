package com.doubleb.bmoto.repository;

import com.doubleb.bmoto.entity.Inventory;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    @Transactional
    @Modifying
    @Query("update Inventory i set i.quantity = ?2 where i.id = ?1")
    void updateQuantity(Long inventoryId, int newQty);
}
