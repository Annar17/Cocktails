package mainpackage.datapackage;

public class Cocktails {

    private String name, base, taste, ingredients, link;

    public Cocktails(String base, String taste, String ingredients) {
        this.base = base;
        this.taste = taste;
        this.ingredients = ingredients;
    }

    public Cocktails(String name, String base, String taste, String ingredients, String link) {  //constructor
        this.name = name;
        this.base = base;
        this.taste = taste;
        this.ingredients = ingredients;
        this.link = link;
    }

    public Cocktails(String base) {
        this.base = base;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
