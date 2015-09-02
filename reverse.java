class Reverse{


	public static void main () {
		String input = "abcd";
        for (int j=input.lenght(),i=0; i<j; i++,j--) {
        	char temp = input.charAt(i);
        	input[i] = input.charAt(j);
        	input[j] = temp;
        }

	}
}