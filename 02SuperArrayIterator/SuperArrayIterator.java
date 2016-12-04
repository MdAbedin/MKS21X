import java.util.Iterator;
import java.util.NoSuchElementException;

public class SuperArrayIterator implements Iterator<String>{
    int index = 0;
    SuperArray array;

    public SuperArrayIterator(SuperArray array){
	this.array = array;
    }

    public boolean hasNext(){
	return index < array.size();
    }

    public String next(){
	if(hasNext()){
	    return array.get(index++);
	}else{
	    throw new NoSuchElementException();
	}
    }
    
    public void remove(){
	throw new UnsupportedOperationException();
    }
}
