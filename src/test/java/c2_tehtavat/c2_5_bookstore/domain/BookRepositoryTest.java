package c2_tehtavat.c2_5_bookstore.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryrepository;

    @Test
    public void testCreateNewBook() {
        Book book = new Book("nimi4", "kirjailija4", 0, "isbn4", 0, categoryrepository.findByName("Fiction").get(0));
        bookRepository.save(book);

        assertThat(book.getId()).isNotNull();
    }

    @Test
    public void testFindById() {
        Optional<Book> book = bookRepository.findById(3L);
        
        assertThat(book).isPresent();
        assertThat(book.get().getAuthor()).isEqualTo("kirjailija3");
    }

    @Test
    public void testDeleteBook() {
        Book book = new Book("nimi4", "kirjailija4", 0, "isbn4", 0, categoryrepository.findByName("Fiction").get(0));
        bookRepository.save(book);

        bookRepository.delete(book);
        assertThat(bookRepository.findById(book.getId())).isEmpty();
    }
}
