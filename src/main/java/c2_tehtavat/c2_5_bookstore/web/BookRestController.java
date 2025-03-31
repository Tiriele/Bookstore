package c2_tehtavat.c2_5_bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import c2_tehtavat.c2_5_bookstore.domain.Book;
import c2_tehtavat.c2_5_bookstore.domain.BookRepository;

@CrossOrigin
@Controller
public class BookRestController {


    @Autowired
    private BookRepository bookRepository;

    // Palauttaa kirjat JSON-muodossa selaimeen
    @GetMapping("/books")
    public @ResponseBody List<Book> getAllBooksRest() {
        return (List<Book>) bookRepository.findAll();
    }

    // Palauttaa yhden kirjan JSON-muodossa selaimeen
    @GetMapping("/books/{id}")
    public @ResponseBody Optional<Book> getBookById (@PathVariable(name = "id") Long bookId) {
        return bookRepository.findById(bookId);
}

    // Lisää uuden kirjan tietokantaan
    @PostMapping("/books")
    public @ResponseBody Book addNewBookRest(@RequestBody Book newBook) {
        return bookRepository.save(newBook);
    }
}
