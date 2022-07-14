package com.empose.controllers;

import com.empose.dtos.CategoryDto;
import com.empose.dtos.ProductDto;
import com.empose.models.Category;
import com.empose.models.Product;
import com.empose.models.Sku;
import com.empose.responses.ErrorResponse;
import com.empose.services.CategoryService;
import com.empose.services.ProductService;
import com.empose.services.SkuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/category")
public class CategoryController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Integer id) {
        return new ResponseEntity<>(categoryService.findById(id), HttpStatus.OK);
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<?> save(@RequestBody CategoryDto categoryDto) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDto, category);
        Category cat = categoryService.save(category);
        if (cat.getId() != null) {
            return new ResponseEntity<>(cat, HttpStatus.OK);
        }
        return new ResponseEntity<>(new ErrorResponse("Categoria ja existe."), HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Category category) {
        Category paymentMethodSave = categoryService.update(category);

        if (paymentMethodSave.getId() != null) {
            return new ResponseEntity<>(category, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ErrorResponse("Categoria não encontrado,"), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public ResponseEntity<?> remove(@RequestBody Category category) {
        String returnMessage = categoryService.remove(category);

        if (returnMessage.equals(""))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(new ErrorResponse(returnMessage), HttpStatus.NOT_ACCEPTABLE);
    }

}