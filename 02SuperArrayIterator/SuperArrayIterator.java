import java.util.Iterator;

public class SuperArrayIterator implements Iterator<String>{
    int start;
    SuperArray array;

    public SuperArrayIterator(SuperArray array, int start){
	this.start = start;
	this.array = array;
    }

    public boolean hasNext(){
	return start < array.size();
    }

    public String next(){
	if(hasNext()){
	    return array.get(start++);
	}else{
	    throw new NoSuchElementException();
	}
    }
    
    public void remove(){
	throw new UnsupportedOperationException();
    }
}
