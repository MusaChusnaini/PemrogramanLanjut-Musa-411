package codelab1;

public class Book {
    private String title;
    private String author;
    private double price;
    private int stock;

    public Book(String title, String author, double price, int stock) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setPrice(price);
        this.setStock(stock);
    }

    final float DISCOUNT_RATE = 0.1f;
    public void DisplayInfo(){
        System.out.println("Title : "+ getTitle());
        System.out.println("Author : "+ getAuthor());
        System.out.println("Price : "+ getPrice());
        System.out.println("Discounted Price $" + getDiscountedPrice());
        System.out.println("Stock : "+ getStock());
    }

    private double getDiscountedPrice() {
        return getPrice() - (getPrice() * DISCOUNT_RATE);
    }

    public void adjustStock(int adjustment){
        setStock(getStock() + adjustment);
        System.out.println("Stock Adjusted");
        System.out.println("Current Stock : "+ getStock());
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
