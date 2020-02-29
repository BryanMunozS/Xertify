package algorithm.test.main;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Bryan Muñoz
 *
 */
public class Algorithm {

	private static Scanner sc;

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		sc = new Scanner(System.in);
		System.out.println("You can write now");
		String input = sc.nextLine();
		while (!input.equals("")) {
			patternSearch(input);
			input = sc.nextLine();
		}

	}

	private static void patternSearch(String word) {
		Pattern pat = Pattern.compile(
				"^[gG]" + "([oO0]|<>|\\[\\]|\\(\\))" + "([oO0]|<>|\\[\\]|\\(\\))" + "[gG]+" + "([lL]|\\|)" + "[eE3]$");
		Matcher mat = pat.matcher(word);
		if (mat.matches()) {
			System.out.println("the word is true");
		} else {
			System.out.println("the word is false");
		}

	}

}
