
/*
There is a class named Book that contains two fields: title and isbn. The first field describes the name of the book and the second one is a special code assigned to each published book. The class also provides a constructor accepting a title, getters and setters for both fields as well as two additional methods:

    releaseBook that releases a book by assigning an isbn number to it;
    getTitleAndIsbnWithSeparator that returns the values of both the fields separated by a special symbol.

In addition, there is also a particular object of this class:

Book book = new Book("Brave New World");
Book.releaseBook(book, "978-3-8438-4825-1");

You need to match different method references and suitable types of functions for this class.


*/
class Book {
    private String title;
    private String isbn;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public static Book releaseBook(Book book, String isbn) {
        if (Objects.isNull(book.isbn)) {
            book.setIsbn(isbn);
        }
        return book;
    }

    public String getTitleAndIsbnWithSeparator(String separator) {
        return title + separator + isbn;
    }
}

public class BookStaticMethods{

	public static void main(){
		Book book = new Book("Brave New World");
		Book.releaseBook(book, "978-3-8438-4825-1");

		
BiFunction<Book, String, Book>  a1=  Book::releaseBook;
Function<String, Book> a2= Book::new;
Function<Book, String> a3 = Book::getIsbn;
Function<String, String> a4= book::getTitleAndIsbnWithSeparator ;
	}

}
