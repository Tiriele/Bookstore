package c2_tehtavat.c2_5_bookstore.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void testCreateNewCategory() {
        Category category = new Category("Fantasy");
        categoryRepository.save(category);

        assertThat(category.getCategoryid()).isNotNull();
    }

    @Test
    public void testFindById() {
        Optional<Category> category = categoryRepository.findById(3L);
        
        assertThat(category).isPresent();
        assertThat(category.get().getName()).isEqualTo("Fiction");
    }

    @Test
    public void testDeleteCategory() {
        Category category = new Category("Fantasy");
        categoryRepository.save(category);

        categoryRepository.delete(category);
        assertThat(categoryRepository.findById(category.getCategoryid())).isEmpty();
    }

}
