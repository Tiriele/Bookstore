package c2_tehtavat.c2_5_bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    @GetMapping("/index")
    public String getBooks() {
        
        return "index";
    }

}
