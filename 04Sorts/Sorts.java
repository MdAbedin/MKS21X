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

    public static void main(String[] a){
	int[] b = {64, 25, 12, 22, 11};
	Sorts.selectionSort(b);
	for(int i = 0; i < b.length; i++){
	    System.out.print(b[i] + ",");
	}
    }
}
