package platform.blog.restfull;

import java.util.List;

public class blogdto {
    String title;
    String content;
    String category;
    List<String> tag;

    public blogdto(String title, String content, String category, List<String> tag) {
        this.title = title;
        this.content = content;
        this.category = category;
        this.tag = tag;
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
}
