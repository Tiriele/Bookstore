package c2_tehtavat.c2_5_bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import c2_tehtavat.c2_5_bookstore.domain.Book;
import c2_tehtavat.c2_5_bookstore.domain.BookRepository;
import c2_tehtavat.c2_5_bookstore.domain.Category;
import c2_tehtavat.c2_5_bookstore.domain.CategoryRepository;

@SpringBootApplication
public class C25BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(C25BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(C25BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookrepository, CategoryRepository categoryrepository) {
		return (args) -> {
			log.info("Save some sample categories");
			categoryrepository.save(new Category("Scifi"));
			categoryrepository.save(new Category("Comic"));
			categoryrepository.save(new Category("Fiction"));

			log.info("Save some sample books");
			bookrepository.save(new Book("nimi1", "kirjailija1", 0, "isbn1", 0, categoryrepository.findByName("Scifi").get(0)));
			bookrepository.save(new Book("nimi2", "kirjailija2", 0, "isbn2", 0, categoryrepository.findByName("Comic").get(0)));
			bookrepository.save(new Book("nimi3", "kirjailija3", 0, "isbn3", 0, categoryrepository.findByName("Fiction").get(0)));

			log.info("Fetch all the categories");
			for (Category category : categoryrepository.findAll()) {
			log.info(category.toString());

			log.info("Fetch all the books");
			for (Book book : bookrepository.findAll()) {
 			log.info(book.toString());
				}
			};
		};
	}

}
