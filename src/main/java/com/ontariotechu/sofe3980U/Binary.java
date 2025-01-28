package com.ontariotechu.sofe3980U;

/**
 * Unsigned integer Binary variable
 */
public class Binary {
	private String number = "0"; // string containing the binary value '0' or '1'

	// Constructor
	public Binary(String number) {
		if (number == null || number.isEmpty()) {
			this.number = "0"; // Default to "0" for null or empty input
			return;
		}

		// Validate the binary string (only '0' or '1' allowed)
		for (int i = 0; i < number.length(); i++) {
			char ch = number.charAt(i);
			if (ch != '0' && ch != '1') {
				this.number = "0"; // Default to "0" for invalid input
				return;
			}
		}

		// Remove leading zeros
		int beg;
		for (beg = 0; beg < number.length(); beg++) {
			if (number.charAt(beg) != '0') {
				break;
			}
		}

		this.number = (beg == number.length()) ? "0" : number.substring(beg);
	}

	// Get value of binary number
	public String getValue() {
		return this.number;
	}

	// Add two binary numbers
	public static Binary add(Binary num1, Binary num2) {
		int ind1 = num1.number.length() - 1;
		int ind2 = num2.number.length() - 1;
		int carry = 0;
		String num3 = "";
		while (ind1 >= 0 || ind2 >= 0 || carry != 0) {
			int sum = carry;
			if (ind1 >= 0) {
				sum += (num1.number.charAt(ind1) == '1') ? 1 : 0;
				ind1--;
			}
			if (ind2 >= 0) {
				sum += (num2.number.charAt(ind2) == '1') ? 1 : 0;
				ind2--;
			}
			carry = sum / 2;
			sum = sum % 2;
			num3 = ((sum == 0) ? "0" : "1") + num3;
		}
		return new Binary(num3);
	}

	// Bitwise OR
	public static Binary or(Binary num1, Binary num2) {
		StringBuilder result = new StringBuilder();
		int len1 = num1.number.length();
		int len2 = num2.number.length();
		int maxLength = Math.max(len1, len2);

		// Pad shorter number with leading zeros
		String bin1 = String.format("%" + maxLength + "s", num1.number).replace(' ', '0');
		String bin2 = String.format("%" + maxLength + "s", num2.number).replace(' ', '0');

		for (int i = 0; i < maxLength; i++) {
			result.append((bin1.charAt(i) == '1' || bin2.charAt(i) == '1') ? "1" : "0");
		}

		return new Binary(result.toString());
	}

	// Bitwise AND
	public static Binary and(Binary num1, Binary num2) {
		StringBuilder result = new StringBuilder();
		int len1 = num1.number.length();
		int len2 = num2.number.length();
		int maxLength = Math.max(len1, len2);

		// Pad shorter number with leading zeros
		String bin1 = String.format("%" + maxLength + "s", num1.number).replace(' ', '0');
		String bin2 = String.format("%" + maxLength + "s", num2.number).replace(' ', '0');

		for (int i = 0; i < maxLength; i++) {
			result.append((bin1.charAt(i) == '1' && bin2.charAt(i) == '1') ? "1" : "0");
		}

		return new Binary(result.toString());
	}

	// Multiply two binary numbers
	public static Binary multiply(Binary num1, Binary num2) {
		Binary result = new Binary("0");
		String bin2 = new StringBuilder(num2.number).reverse().toString();

		for (int i = 0; i < bin2.length(); i++) {
			if (bin2.charAt(i) == '1') {
				String shiftedNum = num1.number + "0".repeat(i); // Shift by adding zeros
				result = add(result, new Binary(shiftedNum));
			}
		}

		return result;
	}
}
