package c2_tehtavat.c2_5_bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import c2_tehtavat.c2_5_bookstore.web.BookController;
import c2_tehtavat.c2_5_bookstore.web.BookRestController;
import c2_tehtavat.c2_5_bookstore.web.CategoryController;

@SpringBootTest
class C25BookstoreApplicationTests {

	@Autowired
	private BookController bookController;

	@Autowired
	private BookRestController bookRestController;

	@Autowired
	private CategoryController categoryController;

	@Test
	public void contextLoads() throws Exception {
		assertThat(bookController).isNotNull();
		assertThat(bookRestController).isNotNull();
		assertThat(categoryController).isNotNull();
	}

}
