public class Barcode implements Comparable<Barcode>{
    private String _zip;

    public Barcode(String zip){
	if(zip.length() != 5){
	    throw new IllegalArgumentException("Zip code isn't 5 characters long");
	}
	if(!isInteger(zip)){
	    throw new IllegalArgumentException("Zip code contains nondigit characters");
	}
	_zip = zip;
    }

    public static boolean isInteger(String str){
	int ln = str.length();

	for(int i = 0; i < ln; i++){
	    int c = str.charAt(i) - '0';
	    if(c < 0 || c > 9){
		return false;
	    }
	}

	return true;
    }

    public String toString(){
        return _zip + checkSum(_zip) + " " + toCode(_zip);
    }
    
    public static int checkSum(String zip){
	int sum = 0;
	int ln = zip.length();
	
	for(int i = 0; i < ln; i++){
	    sum += zip.charAt(i) - '0';
	}
	
	return sum % 10;
    }

    public int compareTo(Barcode other){
	return Integer.parseInt(_zip) - Integer.parseInt(other._zip);
    }
    
    public static String toCode(String zip){
	if(zip.length() != 5){
	    throw new IllegalArgumentException("Zip code isn't 5 characters long");
	}
	if(!isInteger(zip)){
	    throw new IllegalArgumentException("Zip code contains nondigit characters");
	}
	
	String fullZip = zip + checkSum(zip);
	int ln = fullZip.length();
	String[] codes = {"||:::",":::||","::|:|","::||:",":|::|",":|:|:",":||::","|:::|","|::|:","|:|::"};
	String ans = "|";
	
	for(int i = 0; i < ln; i++){
	    ans += codes[fullZip.charAt(i) - '0'];
	}
	
	return ans + "|";
    }
    
    public static String toZip(String code){
	if(!(code.length() == 32)){
	    throw new IllegalArgumentException("Barcode isn't 32 characters long");
	}
	if(code.charAt(0) - '|' != 0 || code.charAt(31) - '|' != 0){
	    throw new IllegalArgumentException("Barcode doesn't begin and end with '|'");
	}
	if(!onlyBarcodeCharacters(code)){
	    throw new IllegalArgumentException("Barcode contains non-barcode characters");
	}

	String zip = "";
	
	for(int i = 0; i < 6; i++){
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
	    else{
		throw new IllegalArgumentException("Barcode contains nondigit codes");
	    }
	}

	if(checkSum(zip.substring(0,5)) != zip.charAt(5) - '0'){
	    throw new IllegalArgumentException("Check digit and barcode don't match");
	}

	return zip.substring(0,5);
    }

    public static boolean onlyBarcodeCharacters(String code){
	int ln = code.length();

	for(int i = 0; i < ln; i++){
	    if(!(code.charAt(i) - '|' == 0 || code.charAt(i) - ':' == 0)){
		return false;
	    }
	}

	return true;
    }
    
    public static void main(String args[]){
	Barcode a = new Barcode("77777");
	Barcode b = new Barcode("77775");
	System.out.println(a);
	System.out.println(Barcode.toCode("77777"));
	System.out.println(Barcode.toZip(Barcode.toCode("77777")));
	System.out.println(a.toString().substring(7).compareTo(Barcode.toCode("77777")));
	System.out.println(Barcode.toZip("||:::||:::||:::||:::||:::|:|:|:|"));
    }
}
