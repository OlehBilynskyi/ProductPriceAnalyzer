package app;

//Створюємо поля назви, категорії та ціни продукту
public class Product {
    private String name;
    private String category;
    private double price;

    //Викликаємо конструктор при створенні нового об'єкта Product
    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //Метод для виведення об'єкта у консоль
    @Override
    public String toString() {
        return "Product{" + "name='" + '\'' + ", category='" + category + '\'' + ", price=" + price + '}';
    }
}