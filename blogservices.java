package platform.blog.restfull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class blogservices {
    @Autowired
    blogreposetry reposetry ;
    @Autowired
    dto_to_blog mapper;
    public blog add_blog_service(blogdto blg){
     return reposetry.save(mapper.dto_to_entity(blg));
    }
    public blog update_blog(blogdto blg,Integer id){
        LocalDateTime ldt;
        if(reposetry.existsById(id)){
           ldt= reposetry.findById(id).get().getCreatedat();
           return reposetry.save(mapper.dto_to_entityput(blg,id,ldt));
        }
        return null;
    }
    public void delete_blog_service(Integer id){
        reposetry.deleteById(id);
    }
    public blog get_blog_service(Integer id){
       return reposetry.findById(id).get();
    }
    public List<blog> get_all_blog(){
        List<blog>ls=new ArrayList<blog>();
        reposetry.findAll().forEach(ls::add);
        return ls;
    }
    public boolean isexsiste(Integer id){
       return reposetry.existsById(id);
    }
    public List<blog> get_all_blogbystring(String term){
        List<blog>ls=new ArrayList<blog>();
        ls.addAll(reposetry.find_by_content_title_category(term));
        return ls;
    }
}
