package c2_tehtavat.c2_5_bookstore.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository <Book, Long>  {

}
