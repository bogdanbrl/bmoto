package com.doubleb.bmoto.repository;

import com.doubleb.bmoto.entity.Inventory;
import com.doubleb.bmoto.entity.Product;
import com.doubleb.bmoto.model.ProductFullDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    @Query(value = "select product as product, colour as colour, gender as  gender, size as size, " +
            "category as category, inventory as inventory, discount as discount from Product product " +
            "join product.colours as colour " +
            "join product.genders as gender " +
            "join product.sizes as size " +
            "join product.category as category " +
            "join product.inventory as inventory " +
            "join product.discount as discount order by product.createdAt desc limit 8")
    List<ProductFullDetails> findJustArrivedProductsIncludeAttributes();

    @Query(value = "select inventory as quantity from Product product " +
            "join product.inventory as inventory where product.id = ?1")
    Inventory getProductInventory(Long productId);

    Product findProductById(Long id);
}
