package com.doubleb.bmoto.web.controller;

import com.doubleb.bmoto.model.ProductAttributes;
import com.doubleb.bmoto.entity.Product;
import com.doubleb.bmoto.pagination.Pagination;
import com.doubleb.bmoto.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/dashboard")
public class DashboardController{

    private static final String PRODUCTS_PATH = "/products";

    private final ProductService productService;

    public DashboardController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(PRODUCTS_PATH + "/add")
    public String addProductForm(Model model){

        Product product = productService.getNewProduct();
        ProductAttributes productAttributes = productService.getProductAttributes();

        model.addAttribute("product", product);
        model.addAttribute("productAttributes", productAttributes);

        return "/dashboard/product/add";
    }

    @GetMapping(PRODUCTS_PATH + "/update/{id}")
    public String updateProductForm(Model model, @PathVariable String id){

        Product product = productService.findProductByID(Long.valueOf(id));
        ProductAttributes productAttributes = productService.getProductAttributes();
        model.addAttribute("product", product);
        model.addAttribute("productAttributes", productAttributes);

        return "/dashboard/product/add";
    }

    @GetMapping(PRODUCTS_PATH + "/delete/{id}")
    public String deleteProductForm(Model model, @ModelAttribute("pagination") Pagination pagination, @PathVariable String id){
        productService.deleteProduct(Long.valueOf(id));
        Page<Product> products = productService.filterDashboardProduct(pagination);
        model.addAttribute("products", products);
        model.addAttribute("pagination", pagination);
        return "/dashboard/product/list";
    }

    @PostMapping(PRODUCTS_PATH + "/save")
    public String saveProduct(@ModelAttribute("product") Product product, @RequestParam("file") MultipartFile file){
        productService.save(product, file);
        return "redirect:/dashboard" + PRODUCTS_PATH + "/add";
    }

    @GetMapping({"", PRODUCTS_PATH + "/list"})
    public String listAllProducts(Model model, @ModelAttribute("pagination") Pagination pagination){
        Page<Product> products = productService.filterDashboardProduct(pagination);
        model.addAttribute("products", products);
        model.addAttribute("pagination", pagination);
        return "/dashboard/product/list";
    }


}
