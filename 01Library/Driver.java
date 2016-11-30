public class Driver{
    public static void main(String args[]){
	Book A = new Book("Me","Autobiography","718");
	System.out.println(A);
	A.setAuthor("Him");
	System.out.println(A);

	ReferenceBook B = new ReferenceBook("me","Memories","123","0");
	System.out.println(B);
	B.checkout("","");
	B.returned();
	System.out.println(B.circulationStatus());
	B.setCollection("BPL");
	System.out.println(B);

	CirculatingBook C = new CirculatingBook("Md","Sleep is for the Weak","000","1");
	System.out.println(C);
	C.checkout("Ahmed","12/14");
	System.out.println(C.circulationStatus());
	System.out.println(C);
	C.returned();
	System.out.println(C);
	System.out.println(C.circulationStatus());
	System.out.println(C);
    }
}
