import java.util.*;

public class Sorts{
    public static String name(){
	return "09.Abedin.Md"; 
    }
    
    public static void selectionSort(int[] data){
	int lowest;
	for(int i = 0; i < data.length - 1; i++){
	    lowest = i;
	    for(int j = i+1; j < data.length; j++){
		if(data[j] < data[lowest]){
		    lowest = j;
		}
	    }
	    int old = data[i];
	    data[i] = data[lowest];
	    data[lowest] = old;
	}
    }
    
    public static void insertionSort(int[] data){
	int current;
	int ln = data.length;
	for(int i = 1; i < ln; i++){
	    current = data[i];
	    for(int j = i; j >= 0; j--){
		if(j == 0){
		    data[0] = current;
		}
		else if(current < data[j-1]){
		    data[j] = data[j-1];
		}
		else{
		    data[j] = current;
		    j = 0;
		}
	    }
	}
    }

    public static void bubbleSort(int[] data){
	for(int i = data.length - 1; i > 0; i--){
	    boolean swapped = false;
	    for(int j = 0; j < i; j++){
		if(data[j] > data[j+1]){
		    int current = data[j];
		    data[j] = data[j+1];
		    data[j+1] = current;
		    swapped = true;
		}
	    }
	    if(!swapped){
		return;
	    }
	}
    }

    public static int[] randomArray(int size, int max){
	int[] data= new int[size];
	Random num = new Random();
	for(int i=0; i<data.length; i++){
	    data[i]=num.nextInt(max);
	}
	return data;
    }
    public static String Test(String method, int[]initial){
	String sorted;
	long startTime = System.currentTimeMillis();
	int[] copy = new int[initial.length];
	System.arraycopy( initial, 0, copy, 0, initial.length );
	Arrays.sort(copy);
	Object[] Sorted = {copy};
	int[] ary = new int[initial.length];
	System.arraycopy( initial, 0, ary, 0, initial.length );
	switch(method){
	case "selectionSort":Sorts.selectionSort(ary);
	    break;
	case "insertionSort":Sorts.insertionSort(ary);
	    break;
	case "bubbleSort":Sorts.bubbleSort(ary);
	    break;
	default: return "INVALID. CURENTLY THERE ARE ONLY:\nselectionSort, insertionSort, bubbleSort \nPlease try again.";
	}
	Object[] Applied = {ary};
	if (Arrays.deepEquals(Sorted, Applied)){
	    sorted="Did sort";
	}
	else{
	    sorted="Did not sort";
	}
	long endTime = System.currentTimeMillis();
	long time=endTime-startTime;


	return String.format("%s: %s and took time of %s ms", method, sorted, time);
    }
    
    public static void main(String[] a){
	System.out.println(Test(a[0],randomArray(10000,1000)));
	
    }
}
