public class Book{
    private String author, title, ISBN;

    public Book(){
	author = "N/A";
	title = "N/A";
	ISBN = "N/A";
    }

    public Book(String author, String title, String ISBN){
        setAuthor(author);
	setTitle(title);
        setISBN(ISBN);
    }

    public String getAuthor(){
	return author;
    }

    public String getTitle(){
	return title;
    }

    public String getISBN(){
	return ISBN;
    }

    public void setAuthor(String author){
	this.author = author;
    }

    public void setTitle(String title){
	this.title = title;
    }

    public void setISBN(String ISBN){
	this.ISBN = ISBN;
    }

    public String toString(){
	return "Book Info: Title-" + title + ", Author-" + author + ", ISBN-" + ISBN;
    }
}
