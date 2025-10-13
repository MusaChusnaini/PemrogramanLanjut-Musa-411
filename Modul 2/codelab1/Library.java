package codelab1;

public class Library {
    public Book book;
    public String location;

    public Library(Book book, String location) {
        this.book = book;
        this.location = location;
    }

    public void showInfoLibrary(){
        System.out.println("Library location: "+location);
        book.DisplayInfo();
    }
}
