package lambdas;

/**
 * @author : Odinga David
 * @since : 12/27/21, Mon
 */
public class Product{
    int id;
    String name;
    float price;
    public Product(int id, String name, float price) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price;
    }
}
