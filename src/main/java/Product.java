public class Product {
    private int Id;
    private String name;
    private String category;
    private double price;
    private String description;
    private String specification;

    private static int lastId = 1;
    // zdjęcia


    public Product(String name, String category, double price, String description, String specification) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
        this.specification = specification;
        this.Id = lastId++;
    }


    public int getId() {
        return Id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }




}
