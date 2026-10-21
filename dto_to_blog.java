package platform.blog.restfull;

import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class dto_to_blog {
    public blog dto_to_entity(@NonNull blogdto blg){
        LocalDateTime creat_date =LocalDateTime.now();
        LocalDateTime update_date =LocalDateTime.now();
        return new blog(blg.getTitle(),blg.getContent(), blg.getCategory(), blg.getTag(),creat_date,update_date);
    }
    public blog dto_to_entityput(@NonNull blogdto blg,int id,LocalDateTime lc){
        LocalDateTime update_date =LocalDateTime.now();
        return new blog(id,blg.getTitle(), blg.getContent(), blg.getCategory(),blg.getTag(),lc,update_date);
    }
}
