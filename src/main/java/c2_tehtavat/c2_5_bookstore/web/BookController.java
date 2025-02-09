package c2_tehtavat.c2_5_bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import c2_tehtavat.c2_5_bookstore.domain.BookRepository;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/index")
    public String getIndex() {
        
        return "index";
    }

    @GetMapping("/booklist")
    public String getBooklist(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "booklist";
    }

}
