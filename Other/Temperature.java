public class Temperature{
    public static double CtoF(double t){
	return ((t * 1.8) + 32);
    }

    public static double FtoC(double t){
	return ((t - 32) / 1.8);
    }

    public static void main(String[] a){
	System.out.println(Temperature.CtoF(-40.0));
	System.out.println(Temperature.CtoF(100.0));
	System.out.println(Temperature.FtoC(212.0));
    }
}
