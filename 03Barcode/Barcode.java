public class Barcode implements Comparable<Barcode>{
    private String _zip;
    private int _checkDigit;

    public Barcode(String zip){
	try{
	    if(zip.length() == 5){
		_zip = zip;
		_checkDigit = checkSum() % 10;
	    }
	    else{
		throw new IllegalArgumentException();
	    }
	}
	catch(NumberFormatException e){
	    throw new IllegalArgumentException();
	}
    }

    public Barcode clone(){
	return new Barcode(_zip);
    }
    
    private int checkSum(){
	int sum = 0;
	int num = Integer.parseInt(_zip);
	
	while(num != 0){
	    sum += (num % 10);
	    num /= 10;
	}
	
	return sum % 10;
    }
    
    public String toString(){
	String code = _zip + _checkDigit + "  " + "|";
	int ln = (_zip + _checkDigit).length();
	
	for(int i = 0; i < ln; i++){
	    switch((_zip + _checkDigit).charAt(i)){
	    case '0': code += "||:::";
		break;
	    case '1': code += ":::||";
		break;
	    case '2': code += "::|:|";
		break;
	    case '3': code += "::||:";
		break;
	    case '4': code += ":|::|";
		break;
	    case '5': code += ":|:|:";
		break;
	    case '6': code += ":||::";
		break;
	    case '7': code += "|:::|";
		break;
	    case '8': code += "|::|:";
		break;
	    case '9': code += "|:|::";
		break;
	    }
	}

	return code + "|";
    }
    
    public int compareTo(Barcode other){
	String code = other.toString().substring(9);
	String otherZip = "";
	
	for(int i = 0; i < 6; i++){
	    String digit = code.substring(i*5,i*5+5);
	    if(digit.compareTo("||:::") == 0){
		otherZip += "0";
	    }
	    else if(digit.compareTo(":::||") == 0){
		otherZip += "1";
	    }
	    else if(digit.compareTo("::|:|") == 0){
		otherZip += "2";
	    }
	    else if(digit.compareTo("::||:") == 0){
		otherZip += "3";
	    }
	    else if(digit.compareTo(":|::|") == 0){
		otherZip += "4";
	    }
	    else if(digit.compareTo(":|:|:") == 0){
		otherZip += "5";
	    }
	    else if(digit.compareTo(":||::") == 0){
		otherZip += "6";
	    }
	    else if(digit.compareTo("|:::|") == 0){
		otherZip += "7";
	    }
	    else if(digit.compareTo("|::|:") == 0){
		otherZip += "8";
	    }
	    else if(digit.compareTo("|:|::") == 0){
		otherZip += "9";
	    }
	}
	
	return Integer.parseInt(_zip + _checkDigit) - Integer.parseInt(otherZip);
    }

    public static void main(String args[]){
	Barcode b = new Barcode("08451");
	Barcode c = new Barcode("84510");
	System.out.println(b);
	System.out.println(b.toString().compareTo("084518  |||:::|::|::|::|:|:|::::|||::|:|"));
	System.out.println(b.compareTo(b));
	System.out.println(c.compareTo(b));

	//Barcode c = new Barcode("123456");
	//Barcode d = new Barcode("1234");
	//Barcode e = new Barcode("1234e");
    }
}
