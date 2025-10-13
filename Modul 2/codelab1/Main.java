package codelab1;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Harry Potter","J.K. Rowling",10,2);
        Library library = new Library(book1,"Perpustakaan Kota");

        library.showInfoLibrary();

        book1.adjustStock(5);
        library.showInfoLibrary();
    }
}
