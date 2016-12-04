import java.util.Iterator;

public class SuperArray implements Iterable<String>{
    private String[] data;
    private int size;

    public SuperArray(){
	data = new String[10];
	size = 0;
    }

    public SuperArray(int initialCapacity){
	if(initialCapacity < 0){
	    throw new IllegalArgumentException("initialCapacity cannot be negative");
	}
	
	data = new String[initialCapacity];
	size = 0;
    }
    
    public Iterator<String> iterator(){
	return new SuperArrayIterator(this);
    }

    int size(){
	return size;
    }

    boolean add(String element){
	if(this.size() == data.length){
	    this.grow();
	}
	size++;
	this.set(this.size()-1,element);
	    
	return true;
    }

    String get(int index){
	if(index < 0 || index >= this.size()){
	    throw new IndexOutOfBoundsException("index must be from [0,size)");
	}
	
	return data[index];
    }
    
    private void grow(){
	int sz = this.size();
        String[] temp;
	if(data.length == 0){
	    temp = new String[10];
	}
	else{
	    temp = new String[data.length * 2];
	}
	
	for(int i = 0; i < sz; i++){
	    temp[i] = this.get(i);
	}

	data = temp;
    }

    public String toString(){
	int sz = this.size();

	if(sz == 0){
	    return "[]";
	}

	String str = "[ ";
	str += this.get(0);
	
	for(int i = 1; i < sz; i++){
	    str += ", " + this.get(i);
	}
	
	return str + "]";
    }

    public String toStringDebug(){
	String str = "[ ";
	int ln = data.length;
	int sz = this.size();
	
	if(this.size() == 0){
	    str += "_";
	}
	else{
	    str += this.get(0);
	}
	
	for(int i = 1; i < ln; i++){
	    str += ", ";
	    if(i < sz){
		str += this.get(i);
	    }
	    else{
		str += "_";
	    }
	}
	
	return str + "]";
    }

    void clear(){
	size = 0;
    }

    boolean isEmpty(){
	return this.size() == 0;
    }

    String set(int index, String element){
	if(index < 0 || index >= this.size()){
	    throw new IndexOutOfBoundsException("index must be from [0,size)");
	}

        String old = this.get(index);
	data[index] = element;

	return old;
    }
    
    void add(int index, String element){
	if(index < 0 || index > this.size()){
	    throw new IndexOutOfBoundsException("index must be from [0,size]");
	}

	if(data.length == this.size()){
	    this.grow();
	}
	size++;
	
	for(int i = this.size()-2; i >= index; i--){
	    data[i+1] = this.get(i);
	}

	data[index] = element;
    }

    String remove(int index){
	int sz = this.size();
	if(index < 0 || index >= sz){
	    throw new IndexOutOfBoundsException("index must be from [0,size)");
	}

        String old = this.get(index);

	for(int i = index; i < sz-1; i++){
	    this.set(i,this.get(i+1));
	}
	size--;
	
	return old;
    }

    String[] toArray(){
	int sz = this.size();
        String[] temp = new String[sz];

	for(int i = 0; i < sz; i++){
	    temp[i] = this.get(i);
	}

	return temp;
    }

    int indexOf(String s){
	int index = -1;
	int sz = this.size();
	
	for(int i = 0; index < 0 && i < sz; i++){
	    if(this.get(i).compareTo(s) == 0){
		index = i;
	    }
	}

	return index;
    }
    
    int lastIndexOf(String s){
	int index = -1;
	int sz = this.size();
	
	for(int i = sz-1; index < 0 && i >= 0; i--){
	    if(this.get(i).compareTo(s) == 0){
		index = i;
	    }
	}
	
	return index;	
    }

    void trimToSize(){
	int sz = this.size();
        String[] temp = new String[sz];

	for(int i = 0; i < sz; i++){
	    temp[i] = this.get(i);
	}

	data = temp;
    }
}
    
