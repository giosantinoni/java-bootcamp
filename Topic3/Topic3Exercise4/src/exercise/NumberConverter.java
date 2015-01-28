package exercise;

public class NumberConverter implements INumberConverter {

	@Override
	public int romanToInt(String roman) {

		int i = 0;
		int arabic = 0;

		while (i < roman.length()) {

			char letter = roman.charAt(i);
			int number = letterToNumber(letter);

			i++;

			if (i == roman.length()) {
				arabic += number;
			} else {
				int nextNumber = letterToNumber(roman.charAt(i));

				if (nextNumber > number) {
					// Combine the two letters to get one value, and move on to
					// next position in string.
					arabic += (nextNumber - number);
					i++;
				} else {
					// Don't combine the letters. Just add the value of the one
					// letter onto the number.
					arabic += number;
				}
			}

		}

		if (arabic > 3999)
			throw new NumberFormatException("Roman numeral must have value 3999 or less.");

		return arabic;
	}

	private int letterToNumber(char letter) {
		switch (letter) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			throw new NumberFormatException("Illegal character \"" + letter + "\" in Roman numeral");
		}
	}

}
