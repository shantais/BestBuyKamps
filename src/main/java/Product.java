public class Product {
    private final  int Id;
    private String name;
    private CategoryType categoryType;
    private double price;
    private String description;
    private String specification;

    private static int lastId = 1;
    // zdjęcia


    public Product(String name, CategoryType categoryType, double price, String description, String specification) {
        this.name = name;
        this.categoryType = categoryType;
        this.price = price;
        this.description = description;
        this.specification = specification;
        this.Id = lastId++;

    }

    public Product() {
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

    public CategoryType getCategory() {
        return categoryType;
    }

    public void setCategory(CategoryType category) {
        this.categoryType = category;
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
