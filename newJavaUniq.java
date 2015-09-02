class newJavaUniq {
    
    
    public boolean UniqueChar(String input) {

        char[] flag = new char[256];

        for(int i=0; i <input.length(); i++ ) {
        	int val = input.charAt(i);
        	if (flag[val] == '\0') {
        		flag[val] ='1';
        	} else {
        	   return false;
        	}	
        }
        return true;
    }

    public static void main(String[] args) {
    	    System.out.println("Hello, World!");
    UniqString u = new UniqString();
	
    if (u.UniqueChar("Mee")) {
    		System.out.println("Unique char");
    	} else {
    		System.out.println("No unique char");
    	}
    }

}
