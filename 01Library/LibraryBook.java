abstract class LibraryBook extends Book implements Comparable<LibraryBook>{
    private String callNumber;

    public LibraryBook(String author, String title, String ISBN, String callNumber){
        setAuthor(author);
	setTitle(title);
        setISBN(ISBN);
        setCallNumber(callNumber);
    }

    public String getCallNumber(){
	return callNumber;
    }

    public void setCallNumber(String callNumber){
	this.callNumber = callNumber;
    }

    public int compareTo(LibraryBook B){
	return (B.getCallNumber()).compareTo(getCallNumber());
    }

    public String toString(){
	return super.toString() + ", Call Number-" + callNumber;
    }
    
    abstract void checkout(String patron, String due);

    abstract void returned();
    
    abstract String circulationStatus();
}
