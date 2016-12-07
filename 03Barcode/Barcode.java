public class Barcode implements Comparable<Barcode>{
    private String _zip;
    private int _checkDigit;

    public Barcode(String zip){
	if(zip.length() != 5 || ){
	    
	}
	_zip = zip;
	_checkDigit = checkSum(_zip) % 10;
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
	String code = "";

	for(int i = 0; i < _zip.length(); i++){
	    switch(){
	    case 0: code += "||:::";
		break;
	    case 1: code += ":::||";
		break;
	    case 2: code += "::|:|";
		break;
	    case 3: code += "::||:";
		break;
	    case 4: code += ":|::|";
		break;
	    case 5: code += ":|:|:";
		break;
	    case 6: code += ":||::";
		break;
	    case 7: code += "|:::|";
		break;
	    case 8: code += "|::|:";
		break;
	    case 9: code += "|:|::";
		break;
	    }
	}  
    }
    
    /*
    // postcondition: compares the zip + checkdigit, in numerical order. 
    public int compareTo(Barcode other){}
    */
    
    public static void main(String args[]){
	System.out.println(Barcode.sumDigits(1234));
    }
}
