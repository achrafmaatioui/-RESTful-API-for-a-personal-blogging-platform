package platform.blog.restfull;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface blogreposetry extends CrudRepository<blog,Integer>{
 @Query(value = "SELECT * from blog where title LIKE CONCAT('%',?1,'%') or content LIKE CONCAT('%',?1,'%')or category LIKE CONCAT('%',?1,'%')",nativeQuery = true)
 public List<blog>find_by_content_title_category(String st);
}
