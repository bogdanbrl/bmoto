package com.doubleb.bmoto.service.filter.v2.specification;

import com.doubleb.bmoto.entity.Category;
import com.doubleb.bmoto.entity.Inventory;
import com.doubleb.bmoto.entity.Product;
import com.doubleb.bmoto.service.filter.v2.search.SearchProductCriteria;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public class ProductSpecification {

    private Specification<Product> productNotDeleted(){
        return new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("deletedFlag"), false);
            }
        };
    }

    private Specification<Product> hasName(String name){
        return new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get("name"), "%" + name.toLowerCase() + "%");
            }
        };
    }

    private Specification<Product> hasDescription(String description){
        return new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get("description"), "%" + description.toLowerCase() + "%");
            }
        };
    }

    private Specification<Product> hasPrice(Double minPrice, Double maxPrice){
        if (minPrice != null && !minPrice.isNaN()) {
            if (maxPrice != null && !maxPrice.isNaN()) {
                return new Specification<Product>() {
                    @Override
                    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                        return criteriaBuilder.between(root.get("price"), minPrice, maxPrice);
                    }
                };
            } else {
                return new Specification<Product>() {
                    @Override
                    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                        return criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
                    }
                };
            }
        } else if (maxPrice != null && !maxPrice.isNaN()){
            return new Specification<Product>() {
                @Override
                public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                    return criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice);
                }
            };
        }
        return new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice);
            }
        };
    }

    private Specification<Product> hasCreatedDate(LocalDateTime minDate, LocalDateTime maxDate){
        if (minDate != null) {
            if (maxDate != null) {
                return new Specification<Product>() {
                    @Override
                    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                        return criteriaBuilder.between(root.get("createdAt"), minDate, maxDate);
                    }
                };
            } else {
                return new Specification<Product>() {
                    @Override
                    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                        return criteriaBuilder.greaterThanOrEqualTo(root.get("createdAt"), minDate);
                    }
                };
            }
        } else if (maxDate != null){
            return new Specification<Product>() {
                @Override
                public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                    return criteriaBuilder.lessThanOrEqualTo(root.get("createdAt"), maxDate);
                }
            };
        }
        return new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get("createdAt"), minDate);
            }
        };
    }

    private Specification<Product> hasManufacturer(String manufacturer){
        return new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get("description"), "%" + manufacturer.toLowerCase() + "%");
            }
        };
    }

    private Specification<Product> hasCategory(String category){
        return new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Join<Product, Category> join = root.join("category");
                return criteriaBuilder.like(join.get("name"), "%" + category.toLowerCase() + "%");
            }
        };
    }

    private Specification<Product> hasInventory(Integer minQuantity, Integer maxQuantity){
        if (minQuantity != null) {
            if (maxQuantity != null) {
                return new Specification<Product>() {
                    @Override
                    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                        Join<Product, Inventory> join = root.join("inventory");
                        return criteriaBuilder.between(join.get("quantity"), minQuantity, maxQuantity);
                    }
                };
            } else {
                return new Specification<Product>() {
                    @Override
                    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                        Join<Product, Inventory> join = root.join("inventory");
                        return criteriaBuilder.greaterThanOrEqualTo(join.get("quantity"), minQuantity);
                    }
                };
            }
        } else if (maxQuantity != null){
            return new Specification<Product>() {
                @Override
                public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                    Join<Product, Inventory> join = root.join("inventory");
                    return criteriaBuilder.lessThanOrEqualTo(join.get("quantity"), maxQuantity);
                }
            };
        }

        return new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Join<Product, Inventory> join = root.join("inventory");
                return criteriaBuilder.greaterThanOrEqualTo(join.get("quantity"), minQuantity);
            }
        };
    }

    private Specification<Product> hasDiscount(Double minDiscount, Double maxDiscount){
        if (minDiscount != null) {
            if (maxDiscount != null) {
                return new Specification<Product>() {
                    @Override
                    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                        Join<Product, Inventory> join = root.join("discount");
                        return criteriaBuilder.between(join.get("discountPercent"), minDiscount, maxDiscount);
                    }
                };
            } else {
                return new Specification<Product>() {
                    @Override
                    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                        Join<Product, Inventory> join = root.join("discount");
                        return criteriaBuilder.greaterThanOrEqualTo(join.get("discountPercent"), minDiscount);
                    }
                };
            }
        } else if (maxDiscount != null){
            return new Specification<Product>() {
                @Override
                public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                    Join<Product, Inventory> join = root.join("discount");
                    return criteriaBuilder.lessThanOrEqualTo(join.get("discountPercent"), maxDiscount);
                }
            };
        }

        return new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Join<Product, Inventory> join = root.join("discount");
                return criteriaBuilder.greaterThanOrEqualTo(join.get("discountPercent"), minDiscount);
            }
        };
    }

    private Specification<Product> hasColour(String colour){
        return new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Join<Product, Inventory> join = root.join("colours");
                return criteriaBuilder.like(join.get("name"), "%" + colour.toLowerCase() + "%");
            }
        };
    }

    private Specification<Product> hasSize(String size){
        return new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Join<Product, Inventory> join = root.join("sizes");
                return criteriaBuilder.like(join.get("name"), "%" + size.toLowerCase() + "%");
            }
        };
    }

    private Specification<Product> hasGender(String gender){
        return new Specification<Product>() {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Join<Product, Inventory> join = root.join("genders");
                return criteriaBuilder.like(join.get("name"),  gender.toLowerCase());
            }
        };
    }

    public Specification<Product> createSpecification(SearchProductCriteria criteria, String strToSearch){
        Specification<Product> spec = Specification.where(productNotDeleted());

        try{
            if(strToSearch != null && strToSearch.trim().length() > 0 && !strToSearch.equals("null")){
                spec = spec.and(Specification.where(hasName(strToSearch.trim()).or(hasCategory(strToSearch.trim()).or(hasDescription(strToSearch.trim())
                                .or(hasGender(strToSearch.trim()).or(hasColour(strToSearch.trim())
                                ))))));
            }

            if (criteria != null){
                if ((criteria.getName() != null) && (!criteria.getName().trim().isEmpty()) && (!criteria.getName().trim().equals("null"))){
                    spec = spec.and(Specification.where(hasName(criteria.getName().trim())));
                }
                if ((criteria.getDescription() != null) && (!criteria.getDescription().trim().isEmpty()) && (!criteria.getDescription().trim().equals("null")) ) {
                    spec = spec.and(Specification.where(hasDescription(criteria.getDescription().trim())));
                }
                if (((criteria.getMinPrice() != null) && (!criteria.getMinPrice().isNaN())) ||
                        ((criteria.getMaxPrice() != null) && (!criteria.getMaxPrice().isNaN()))) {
                    spec = spec.and(Specification.where(hasPrice(criteria.getMinPrice(), criteria.getMaxPrice())));
                }
                if (criteria.getMinCreatedAt() != null || criteria.getMaxCreatedAt() != null) {
                    spec = spec.and(Specification.where(hasCreatedDate(criteria.getMinCreatedAt(), criteria.getMaxCreatedAt())));
                }
                if ((criteria.getManufacturer() != null) && (!criteria.getManufacturer().trim().isEmpty()) && (!criteria.getManufacturer().trim().equals("null"))){
                    spec = spec.and(Specification.where(hasManufacturer(criteria.getManufacturer().trim())));
                }
                if ((criteria.getCategory() != null) && (!criteria.getCategory().trim().isEmpty()) && (!criteria.getCategory().trim().equals("null"))){
                    spec = spec.and(Specification.where(hasCategory(criteria.getCategory().trim())));
                }
                if (criteria.getMinQuantity() != null || criteria.getMaxQuantity() != null) {
                    spec = spec.and(Specification.where(hasInventory(criteria.getMinQuantity(), criteria.getMaxQuantity())));
                }
                if (((criteria.getMinDiscount() != null) && (!criteria.getMinDiscount().isNaN())) ||
                        ((criteria.getMaxDiscount() != null) && (!criteria.getMaxDiscount().isNaN()))) {
                    spec = spec.and(Specification.where(hasDiscount(criteria.getMinDiscount(), criteria.getMaxDiscount())));
                }
                if ((criteria.getColour() != null) && (!criteria.getColour().trim().isEmpty()) && (!criteria.getColour().trim().equals("null"))){
                    spec = spec.and(Specification.where(hasColour(criteria.getColour().trim())));
                }
                if ((criteria.getGender() != null) && (!criteria.getGender().trim().isEmpty()) && (!criteria.getGender().trim().equals("null"))){
                    spec = spec.and(Specification.where(hasGender(criteria.getGender().trim())));
                }
                if ((criteria.getSize() != null) && (!criteria.getSize().trim().isEmpty()) && (!criteria.getSize().trim().equals("null"))){
                    spec = spec.and(Specification.where(hasSize(criteria.getSize().trim())));
                }
            }
        }catch (Exception e){
            System.out.println("error: " + e.getMessage());
        }

        return spec;
    }

    public Specification<Product> createSpecification(String strToSearch){
        Specification<Product> spec = Specification.where(productNotDeleted());

        try{
            if(strToSearch != null && strToSearch.trim().length() > 0 && !strToSearch.equals("null")){
                spec = spec.and(Specification.where(hasName(strToSearch.trim()).or(hasCategory(strToSearch.trim()).or(hasDescription(strToSearch.trim())
                        .or(hasGender(strToSearch.trim()).or(hasColour(strToSearch.trim())
                        ))))));
            }



        }catch (Exception e){
            System.out.println("error: " + e.getMessage());
        }

        return spec;
    }
}
