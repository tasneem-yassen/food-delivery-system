//this class represents a date and validates if its corrcet 
public class MyDate {
	private int day;
	private int month;
	private int year;
////////////constructor/////////////////
	public MyDate(int day, int month, int year) {
		setDate(day , month , year); 
	}
///////////getters and setters/////////////
	public int getDay() {
		return day;
	}
	public int getMonth() {
		return month;
	}
	public int getYear() {
		return year;
	}
//////////toString///////////////
	@Override
	public String toString() {
		return "Date: (" + day + "," + month + "," + year + ")";
	}
//override the equals method : 2 dates are equal if day, month,year are the same 
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null || getClass() != obj.getClass()) {
			return false;
		}
		MyDate other = (MyDate)obj; 
		
		return this.day == other.day &&
			       this.month == other.month &&
			       this.year == other.year;
	}
/////////helper methods///////////////
	public boolean setDate(int day, int month, int year) {
		//check if the date is valid 
		if(day == 0 && month == 0 && year == 0) {
			this.day = 0;
			this.month = 0;
			this.year = 0;
			return true;
		}
		if((year < 2000 || year > 2026) || month < 1 || month > 12 || day < 1) {
			return false; 
		}
		int maxDay;
		if(month == 2) {
			maxDay = 28; 
		}else if(month == 4 || month ==6 || month == 9
				|| month == 11) {
			maxDay = 30;
		}else {
			maxDay = 31;
		}
		if(maxDay < day) {
			return false; 
		}
		this.day = day;
		this.month = month; 
		this.year = year; 
		return true; 
	}
	
	
	public boolean isBefore(MyDate other) {
		// checks if current date is before "other"
		if (this.year < other.year) {
			return true;
		}
		if (this.year > other.year) {
			return false;
		}
		if (this.month < other.month) {
			return true;
		}
		if (this.month > other.month) {
			return false;
		}
		return this.day < other.day;
	}
}
