package platform.blog.restfull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class blogcontroller {
    @Autowired
    blogservices blgsrvc;
    @RequestMapping(method = RequestMethod.POST,value = "/blog")
    public ResponseEntity<?> addblog(@RequestBody blogdto blg){
        blog bl;
        bl= blgsrvc.add_blog_service(blg);
        if(bl==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("there is a error");
        }else {
            return ResponseEntity.status(HttpStatus.CREATED).body(bl);
        }
    }
    @RequestMapping(method = RequestMethod.PUT,value = "/blog/{id}")
    public ResponseEntity<?> updateblog(@RequestBody blogdto blg,@PathVariable Integer id){
        if (!blgsrvc.isexsiste(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("id not found");
        }
        blog bl;
        bl=blgsrvc.update_blog(blg,id);
        if(bl==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error");
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(bl);
        }
    }
    @RequestMapping(method = RequestMethod.DELETE,value = "/blog/{id}")
    public ResponseEntity<?> delete_blog(@PathVariable Integer id){
       if(blgsrvc.isexsiste(id)){
           blgsrvc.delete_blog_service(id);
           return ResponseEntity.status(HttpStatus.NO_CONTENT).body("success");
       }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("false id");
    }
    @RequestMapping(method = RequestMethod.GET,value = "/blog/{id}")
    public ResponseEntity<?> get_blog(@PathVariable Integer id){
       blog bl;
       if(blgsrvc.isexsiste(id)){
           bl=blgsrvc.get_blog_service(id);
           return ResponseEntity.status(HttpStatus.OK).body(bl);
       }
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found");
    }
    @RequestMapping(method = RequestMethod.GET,value = "/blog")
    public ResponseEntity<List<blog>> getallblog(@RequestParam(required = false) String term){
        if(term ==null|| term.isEmpty()){
       return ResponseEntity.status(HttpStatus.OK).body(blgsrvc.get_all_blog());}
        else {
            return ResponseEntity.status(HttpStatus.OK).body(blgsrvc.get_all_blogbystring(term));
        }
    }

}
