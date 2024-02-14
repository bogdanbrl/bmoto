package com.doubleb.bmoto.web.controller;

import com.doubleb.bmoto.entity.Colour;
import com.doubleb.bmoto.entity.Product;
import com.doubleb.bmoto.entity.Size;
import com.doubleb.bmoto.model.ProductFullDetails;
import com.doubleb.bmoto.pagination.Pagination;
import com.doubleb.bmoto.service.*;
import com.doubleb.bmoto.service.filter.v2.search.SearchProductCriteria;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.data.domain.Page;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller()
@RequestMapping()
public class ProductController {

    private final ProductService productService;
    private final SizeService sizeService;
    private final ColourService colourService;
    private final GenderService genderService;
    private final CategoryService categoryService;

    public ProductController(ProductService productService, SizeService sizeService, ColourService colourService, GenderService genderService, CategoryService categoryService) {
        this.productService = productService;
        this.sizeService = sizeService;
        this.colourService = colourService;
        this.genderService = genderService;
        this.categoryService = categoryService;
    }

    @GetMapping("/shop")
    public String listAllProducts(Model model, @ModelAttribute("pagination") Pagination pagination){

        Page<Product> products = productService.filterProduct(pagination);
        model.addAttribute("products", products);
        model.addAttribute("pagination", pagination);
        model.addAttribute("colours", colourService.getAllColours());
        model.addAttribute("sizes", sizeService.getAllSizes());
        model.addAttribute("genders", genderService.getAllGenders());
        model.addAttribute("categories", categoryService.getAllCategories());

        return "/shop";
    }

    @GetMapping("/shop/{category}/category")
    public String listAllProductsCategoryMenu(Model model, @PathVariable String category){

        Pagination pagination = new Pagination();
        SearchProductCriteria criteria = new SearchProductCriteria();
        criteria.setCategory(category);
        pagination.setCriteria(criteria);

        return listAllProducts(model, pagination);
    }

    @GetMapping("/products/{id}/details")
    public String detailProduct(Model model, @PathVariable String id){

        Product product = productService.findProductByID(Long.valueOf(id));
        model.addAttribute("product", product);
        model.addAttribute("qty", 1);

        return "/detail";
    }

    @GetMapping("/products/{id}/price")
    public void getPriceByProductID(@PathVariable String id, HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        Double price = productService.findPriceByProductID(Long.valueOf(id));
        request.setAttribute("price", price);
        // return price
        chain.doFilter(request, response);
    }

    @GetMapping("products/{id}/image")
    public void renderImageFromDB(@PathVariable String id, HttpServletResponse response) throws IOException {
        Product product = productService.findProductByID(Long.valueOf(id));

        if (product.getImage() != null) {
            byte[] byteArray = new byte[product.getImage().length];
            int i = 0;

            for (Byte wrappedByte : product.getImage()) {
                byteArray[i++] = wrappedByte; //auto unboxing
            }

            response.setContentType("image/jpeg");
            InputStream is = new ByteArrayInputStream(byteArray);
            IOUtils.copy(is, response.getOutputStream());
        }
    }

}
