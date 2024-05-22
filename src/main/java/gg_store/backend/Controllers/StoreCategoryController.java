package gg_store.backend.Controllers;

import gg_store.backend.entities.StoreCategory;
import gg_store.backend.services.StoreCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class StoreCategoryController {

    private final StoreCategoryService categoryService;

    @Autowired
    public StoreCategoryController(StoreCategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/new-cat")
    public ResponseEntity<String> createCategory(@RequestBody StoreCategory storeCategory) {
        categoryService.createCategory(storeCategory);
        return new ResponseEntity<>("Categoría creada exitosamente", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable int id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<>("Categoría eliminada exitosamente", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreCategory> findCategoryById(@PathVariable int id) {
        Optional<StoreCategory> category = categoryService.findCategoryById(id);
        return category.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<StoreCategory>> findAllCategories() {
        List<StoreCategory> categories = categoryService.findAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}
