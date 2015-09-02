class replace {
	
	String input = "i am Ravi Kumar";

	public char[] replaceSpace(String input) {

		int len = input.length();
		int i =0;
		int j=0;
		int spaceCount = 0;
		System.out.println("count = "+ len + "spaceCount = "+spaceCount);
		
		while(j<len) {
			if (input.charAt(j) == ' ') {
				spaceCount++;
			}
			j++;
		}
		
		System.out.println("count = "+ len + "spaceCount = "+spaceCount);

		int newlen = len + (2 * spaceCount);
		char[] res = new char[newlen];

		j=0;
		while(j<len) {
			if (input.charAt(j) == ' ') {
				res[i++] = '%';
				res[i++] = '2';
				res[i++] = '0';	
			} else {
				res[i++] = input.charAt(j);
			}
			j++;	
		}
		return res;
	}

	public static void main(String[] args) {

		replace x = new replace();
		
		System.out.println(x.input);
		System.out.println(x.replaceSpace(x.input));

	}
}