package es.deusto.server.data;

public class Fecha {
	
	private int year;
	private int month;
	private int day;
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	
	
	public Fecha(int _year, int _month, int _day)
	{
		 this.year =_year;
		 this.month =_month;
		 this.day = _day;
		
	}
	
	public Fecha()
	{
		
	}

}
