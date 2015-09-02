import java.util.Arrays.*;

class anagram{
	
	public boolean anagramOrNot(String in1, String in2) {
		boolean flag=true;
		char[] chars1 = in1.toCharArray();
		char[] chars2 = in2.toCharArray();
		java.util.Arrays.sort(chars1);
		java.util.Arrays.sort(chars2);
		for (int i=0; i<in1.length(); i++) {
			if(chars1[i] != chars2[i]) {
				flag = false;
			}
		}
		return flag;


	}

	public static void main(String[] args) {

		anagram x = new anagram();
		if (x.anagramOrNot("hello", "olleh")) {

			System.out.println("Anagram");
		}

	}
}