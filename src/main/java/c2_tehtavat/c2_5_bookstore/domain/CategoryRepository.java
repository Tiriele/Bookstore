package c2_tehtavat.c2_5_bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository <Category, Long> {
    List<Category> findByName(String name);
}
