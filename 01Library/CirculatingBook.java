public class CirculatingBook extends LibraryBook{
    private String currentHolder, dueDate;

    public CirculatingBook(String author, String title, String ISBN, String callNumber){
	super(author, title, ISBN, callNumber);
    }

    public String getCurrentHolder(){
	return currentHolder;
    }

    public String getDueDate(){
	return dueDate;
    }

    public void setCurrentHolder(String patron){
	currentHolder = patron;
    }

    public void setDueDate(String dueDate){
	this.dueDate = dueDate;
    }

    public void checkout(String patron, String due){
	currentHolder = patron;
	dueDate = due;
    }

    public void returned(){
	currentHolder = null;
	dueDate = null;
    }

    public String circulationStatus(){
	if(currentHolder == null){
	    return "book available on shelves";
	}
	else{
	    return "Current Holder: " + currentHolder + ", Due Date: " + dueDate;
	}
    }

    public String toString(){
	String s = super.toString();
	
	if(currentHolder != null){
	    s += ", Current Holder-" + currentHolder + ", Due Date-" + dueDate;
	}

	return s;
    }
}
