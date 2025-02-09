package c2_tehtavat.c2_5_bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import c2_tehtavat.c2_5_bookstore.domain.Book;
import c2_tehtavat.c2_5_bookstore.domain.BookRepository;

@SpringBootApplication
public class C25BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(C25BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository bookrepository) {
		return (args) -> {
			Book book1 = new Book("nimi1", "kirjailija1", 0, "isbn1", 0);
			Book book2 = new Book("nimi2", "kirjailija2", 0, "isbn2", 0);
			Book book3 = new Book("nimi3", "kirjailija3", 0, "isbn3", 0);

			bookrepository.save(book1);
			bookrepository.save(book2);
			bookrepository.save(book3);

			};
		}

}
