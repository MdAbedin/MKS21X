import java.util.*;

public class SlidingPuzzle{
    private int side;
    private int[][] values;

    public SlidingPuzzle(int side){
	this.side = side;
	values = new int[side][side];
	initialize();
    }

    public void initialize(){
	ArrayList<Integer> temp = new ArrayList<Integer>();
	for(int i = 0; i < side*side; i++){
	    temp.add(new Integer(i));
	}

	for(int i = 0; i < side; i++){
	    for(int j = 0; j < side; j++){
		int index = ((int)(Math.random()*1000)) % temp.size();
		values[i][j] = temp.get(index);
		temp.remove(index);
	    }
	}
    }

    public boolean isDone(){
	int n = 1;
	for(int i = 0; i < side; i++){
	    for(int j = 0; j < side; j++){
		if(values[i][j] == n){
		    n++;
		}
		else if(values[i][j] != 0){
		    return false;
		}
	    }
	}

	return true;
    }

    public boolean isDone2(){
	int n = 1;

	for(int i = 0; i < side; i++){
	    for(int j = 0; j < side; j++){
		if(!(i == side-1 && j == side-1)){
		    int r = 0;
		    int c = 0;
		    if(j == side-1){
			r = 1;
			c = j + 1;
		    }
		    
		    if(!(values[i][j] < values[i+r][j+1-c] || values[i+r][j+1-c] == 0)){
			return false;
		    }	    
		}
	    }
	}

	return true;
    }

    public boolean isDone3(){
	int n = 1;

	for(int i = 0; i < side * side; i++){
	    if(i != side*side-1){
		int r = i / side;
		int c = i % side;

		if(!(values[r][c] < values[(i+1)/side][(i+1)%side] || values[r][c] == 0)){
			return false;
		    }
	    }
	}

	return true;
    }
    
    public void print(){
	int sz = values.length;
	String str;
	
	if(sz == 0){
	    str = "[]";
	}
	else{
	    str = "[ ";
	    
	    for(int i = 0; i < sz; i++){
		for(int j = 0; j < sz; j++){
		    str += ", " + values[i][j];
		}
	    }
	    
	    str += "]";
	}

	System.out.println(str);
    }
    
    public static void main(String args[]){
	SlidingPuzzle A = new SlidingPuzzle(4);
	A.print();
	System.out.println(A.isDone3());
    }
}
