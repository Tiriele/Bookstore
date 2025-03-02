package c2_tehtavat.c2_5_bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import c2_tehtavat.c2_5_bookstore.domain.Category;
import c2_tehtavat.c2_5_bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/categorylist")
    public String getCategorylist(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "categorylist";
    }

    @GetMapping("/deletecategory/{id}")
    public String deleteCategory(@PathVariable("id") Long categoryId, Model model) {
        categoryRepository.deleteById(categoryId);
        return "redirect:/categorylist";
    }

    @GetMapping("/addcategory")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "addcategory";
    }

    @PostMapping("/savecategory")
    public String saveCategory(@ModelAttribute Category category) {
        categoryRepository.save(category);
        return "redirect:/categorylist";
    }

    @GetMapping("/editcategory/{id}")
    public String editCategory(@PathVariable("id") Long categoryId, Model model) {
        Category category = categoryRepository.findById(categoryId)
            .orElseThrow(() -> new IllegalArgumentException("Invalid category Id: " + categoryId));
        model.addAttribute("category", category);
        return "editcategory";
    }

    @PostMapping("/updatecategory/{id}")
    public String updateCategory(@PathVariable("id") Long categoryId, @ModelAttribute Category category) {
        category.setCategoryid(categoryId);
        categoryRepository.save(category);
        return "redirect:/categorylist";
    }
}
