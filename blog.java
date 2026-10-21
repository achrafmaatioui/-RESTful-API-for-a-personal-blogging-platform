package platform.blog.restfull;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.List;
@JsonPropertyOrder({"id","title","content","category","tag"})
@Entity
public class blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String title;
    String content;
    String category;
    List<String> tag;
    LocalDateTime createdat;
    LocalDateTime updateat;

    public blog(Integer id, String title, String content, String category, List<String> tag, LocalDateTime createdat, LocalDateTime updateat) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.category = category;
        this.tag = tag;
        this.createdat = createdat;
        this.updateat = updateat;
    }

    public blog() {
    }

    public blog(String title, String content, String category, List<String> tag, LocalDateTime createdat, LocalDateTime updateat) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.tag = tag;
        this.createdat = createdat;
        this.updateat = updateat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getTag() {
        return tag;
    }

    public void setTag(List<String> tag) {
        this.tag = tag;
    }

    public LocalDateTime getCreatedat() {
        return createdat;
    }

    public void setCreatedat(LocalDateTime createdat) {
        this.createdat = createdat;
    }

    public LocalDateTime getUpdateat() {
        return updateat;
    }

    public void setUpdateat(LocalDateTime updateat) {
        this.updateat = updateat;
    }
}
