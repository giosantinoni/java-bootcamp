package exercise;

import java.text.DecimalFormat;
import java.text.ParseException;

public class Converter {
	private final DecimalFormat decimalFormat = new DecimalFormat("###,###,###.##");
	private static final String[] UNITS = { "", "one ", "two ", "three ", "four ", "five ", "six ", "seven ", "eight ", "nine ", "ten ",
			"elven ", "twelve ", "thirdteen", "fourteen", "fifteen", "sixteen ", "seventeen ", "eighteen", "nineteen" };
	private static final String[] TENS = { "twenty-", "thirty-", "fourty-", "fifty-", "sixty-", "seventy-", "eighty-", "NINETY-",
			"HUNDRED-" };

	public String amountToText(double amount) {
		StringBuilder result = new StringBuilder();
		
		// Decimal
		double decimal = amount % 1;

		String formated = decimalFormat.format(decimal);
		try {
			decimal = (Double) decimalFormat.parse(formated);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		int decimalInt = (int) (decimal * 100);
		// decimal

		int number = (int) (amount - decimal);

		formated = decimalFormat.format(number);

		String[] splittedAmount = formated.replace(".", "#").split("#");
		int length = splittedAmount.length;

		for (int i = 0; i < length; i++) {
			result.append(getString(splittedAmount[i]));

			if (length == 2 && i == 0)
				result.append("thousand ");
		}

		result.append("and ");

		if (decimalInt < 10)
			result.append(0);

		result.append(decimalInt);
		result.append("/100 dollars");

		return result.toString();
	}

	private String getString(String number) {
		StringBuilder output = new StringBuilder();
		char[] characters = number.toCharArray();
		int length = characters.length;

		for (int i = 0; i < length; i++) {
			int aux = Integer.parseInt("" + characters[i]);

			if (i == 1)
				output.append(" " + TENS[aux - 2]);
			else
				output.append(UNITS[aux]);

			if (length == 3 && i == 0)
				output.append("hundred");
		}

		return output.toString();
	}

}
