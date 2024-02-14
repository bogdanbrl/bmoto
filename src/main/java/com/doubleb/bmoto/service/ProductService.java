package com.doubleb.bmoto.service;

import com.doubleb.bmoto.entity.*;
import com.doubleb.bmoto.model.ProductAttributes;
import com.doubleb.bmoto.model.ProductFullDetails;
import com.doubleb.bmoto.pagination.Pagination;
import com.doubleb.bmoto.repository.*;
import com.doubleb.bmoto.service.filter.v2.search.SearchProductCriteria;
import com.doubleb.bmoto.service.filter.v2.specification.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ColourRepository colourRepository;
    @Autowired
    private SizeRepository sizeRepository;
    @Autowired
    private GenderRepository genderRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    InventoryRepository inventoryRepository;

    public ProductService() {
    }

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductService(ProductRepository productRepository, ColourRepository colourRepository,
                          SizeRepository sizeRepository, GenderRepository genderRepository,
                          CategoryRepository categoryRepository, InventoryRepository inventoryRepository) {
        this.productRepository = productRepository;
        this.colourRepository = colourRepository;
        this.sizeRepository = sizeRepository;
        this.genderRepository = genderRepository;
        this.categoryRepository = categoryRepository;
        this.inventoryRepository = inventoryRepository;
    }

    public Product save(Product product, MultipartFile file){

        try{
            if (file.getSize() > 0) {
                Byte[] byteObjects = new Byte[file.getBytes().length];
                int i = 0;
                for (byte b : file.getBytes()) {
                    byteObjects[i++] = b;
                }
                product.setImage(byteObjects);
            }

            if (product.getId() == null || product.getId() == 0) {
                product.setCreatedAt(LocalDateTime.now());
            }else {
                product.setModifiedAt(LocalDateTime.now());
            }
            product.setDeletedFlag(false);
        }catch (Exception ex){
            //todo handle better
            System.err.println("Error occurred" + ex);
            ex.printStackTrace();
        }
        return productRepository.save(product);
    }

    private List<Colour> getAllColours(){
        return colourRepository.findAllColours();
    }

    private List<Size> getAllSizes(){
        return sizeRepository.findAllSizes();
    }

    private List<Gender> getAllGenders(){
        return genderRepository.findAllGenders();
    }

    private List<Category> getAllCategories(){
        return categoryRepository.findAllCategories();
    }

    public Product getNewProduct(){
        Product product = new Product();
        product.getColours().add(new Colour());
        product.getGenders().add(new Gender());
        product.getSizes().add(new Size());
        return product;
    }

    public ProductAttributes getProductAttributes(){
        List<Colour> colours = getAllColours();
        List<Size> sizes = getAllSizes();
        List<Gender> genders = getAllGenders();
        List<Category> categories = getAllCategories();

        ProductAttributes productAttributes = new ProductAttributes();
        productAttributes.setColours(colours);
        productAttributes.setGenders(genders);
        productAttributes.setSizes(sizes);
        productAttributes.setCategories(categories);
        return productAttributes;
    }

    public Page<Product> filterProduct(Pagination pagination){

        SearchProductCriteria criteria = pagination.getCriteria();
        ProductSpecification productSpecification = new ProductSpecification();
        Specification<Product> specification = productSpecification.createSpecification(criteria, pagination.getStrToSearch());
        Pageable pageable = PageRequest.of(pagination.getPage(), pagination.getItems(),
                Sort.by(new Sort.Order(Sort.Direction.valueOf(pagination.getDirection()), pagination.getSort())));

        return productRepository.findAll(specification, pageable);
    }

    public Page<Product> filterDashboardProduct(Pagination pagination){
        
        ProductSpecification productSpecification = new ProductSpecification();
        Specification<Product> specification = productSpecification.createSpecification(pagination.getStrToSearch());
        Pageable pageable = PageRequest.of(pagination.getPage(), pagination.getItems(),
                Sort.by(new Sort.Order(Sort.Direction.valueOf(pagination.getDirection()), pagination.getSort())));

        return productRepository.findAll(specification, pageable);
    }

    public Product findProductByID(Long id){
        return productRepository.findById(id).get();
    }

    public Double findPriceByProductID(Long id){
        return productRepository.getReferenceById(id).getPrice();
    }

    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).get();
        product.setDeletedFlag(true);
        productRepository.save(product);
    }

    public Inventory getProductInventory(Long productId){
        return productRepository.getProductInventory(productId);
    }

    public Product getProductById(Long id) {
        return productRepository.findProductById(id);
    }

    public void updateProductInventoryQuantity(Long inventoryId, int newQty) {
        inventoryRepository.updateQuantity(inventoryId, newQty);
    }

    public List<ProductFullDetails> getJustArrivedProducts(){
        return productRepository.findJustArrivedProductsIncludeAttributes();
    }
}
