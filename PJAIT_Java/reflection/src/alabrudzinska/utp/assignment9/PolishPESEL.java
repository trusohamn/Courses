package alabrudzinska.utp.assignment9;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PolishPESEL {
	String digits;
	public PolishPESEL(String digits) {
		this.digits = digits;
	}
	
	private boolean validation() {
		/**returns true in case pesel is correct */
		if(digits.length()!=11)return false;
		if(!digits.matches("\\d+"))return false;
		
		int[] wages = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
		int sum = 0;
		for(int i=0; i<digits.length()-1; i++) {
			int j = digits.charAt(i)-'0';
			sum += wages[i]*j;
		}

		int rem = sum%10;		
		int correctDigit = rem == 0 ? 0 : 10-rem;
		return correctDigit == digits.charAt(digits.length()-1)-'0';
	}
	
	private Date extractDate() {
		if(!this.validation()) return null;

		int month = Integer.parseInt(digits.substring(2,4), 10);
		String y = digits.substring(0,2);
		if(month>20) {//born in 20**
			month=month-20;
			y="20"+y;
		}
		else {
			y="19"+y;
		}
		String day = digits.substring(4,6);
		String s = y + " " + month + " " + day;

		DateFormat format = new SimpleDateFormat("yyyy MM dd");
		Date date;
		try {
			date = format.parse(s);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	private Sex extractSex() {
		if(!this.validation()) return null;
		int s =digits.charAt(digits.length()-2)-'0';
		
		return s%2==0 ? Sex.FEMALE : Sex.MALE;
	}

}
