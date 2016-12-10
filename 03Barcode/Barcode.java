public class Barcode implements Comparable<Barcode>{
    private String _zip;

    public Barcode(String zip){
	try{
	    if(zip.length() == 5){
		_zip = zip;
	    }
	    else{
		throw new IllegalArgumentException("Zip code must be 5 numbers long");
	    }
	}
	catch(NumberFormatException e){
	    throw new IllegalArgumentException("Zip code must consist of digits only");
	}
    }
    
    public static int checkSum(String zip){
	int sum = 0;
	int num = Integer.parseInt(zip);
	
	while(num != 0){
	    sum += (num % 10);
	    num /= 10;
	}
	
	return sum % 10;
    }
    
    public String toString(){
        return _zip + checkSum + "  " + toCode(_zip);
    }

    public static String toCode(String zip){
        String fullZip = zip + checkSum(zip);
	int ln = fullZip.length();
	String[] codes = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
	String ans = fullZip + "  " + "|";

	for(int i = 0; i < ln; i++){
	    ans += codes[Character.getNumericValue(fullZip.charAt(i))];
	}

	return ans + "|";
    }
    
    public static String toZip(String code){
	String zip = "";
	
	for(int i = 0; i < 5; i++){
	    String digit = code.substring(i*5+1,i*5+6);
	    if(digit.compareTo("||:::") == 0){
		zip += "0";
	    }
	    else if(digit.compareTo(":::||") == 0){
	        zip += "1";
	    }
	    else if(digit.compareTo("::|:|") == 0){
	        zip += "2";
	    }
	    else if(digit.compareTo("::||:") == 0){
	        zip += "3";
	    }
	    else if(digit.compareTo(":|::|") == 0){
	        zip += "4";
	    }
	    else if(digit.compareTo(":|:|:") == 0){
	        zip += "5";
	    }
	    else if(digit.compareTo(":||::") == 0){
	        zip += "6";
	    }
	    else if(digit.compareTo("|:::|") == 0){
	        zip += "7";
	    }
	    else if(digit.compareTo("|::|:") == 0){
	        zip += "8";
	    }
	    else if(digit.compareTo("|:|::") == 0){
	        zip += "9";
	    }
	}

	return zip;
    }

    public int compareTo(Barcode other){
	String fullZip = _zip + checkSum(_zip);
	String otherFullZip = other._zip + checkSum(other._zip);
	return Integer.parseInt(fullZip) - Integer.parseInt(otherFullZip);
    }

    public static void main(String args[]){
	Barcode b = new Barcode("08451");
	Barcode c = new Barcode("84510");
	System.out.println(b);
	System.out.println(b.toString().compareTo("084518  |||:::|::|::|::|:|:|::::|||::|:|"));
	System.out.println(b.compareTo(b));
	System.out.println(c.compareTo(b));

	System.out.println(Barcode.toZip("|||:::|::|::|::|:|:|::::|||::|:|"));
	//Barcode c = new Barcode("123456");
	//Barcode d = new Barcode("1234");
	//Barcode e = new Barcode("1234e");
    }
}
