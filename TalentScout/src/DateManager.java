import java.util.Locale;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;

public class DateManager {
	
	private final DateFormat df;
	private final String pattern;
	
	/**
	 * Constructor
	 * @param pattern
	 * @param aLocale
	 */
	public DateManager(String pattern, Locale aLocale){
		this.pattern = pattern;
		this.df = new SimpleDateFormat(pattern, aLocale);
		df.setLenient(false);
	}
	
	/**
	 * Default constructor. Danish language and a default pattern matching the Danish date notation.
	 */
	public DateManager(){
		this("dd-MM-yyyy", Locale.forLanguageTag("da"));
	}
	
	public boolean isValid(String date){
		
		try {
			df.parse(date);
			return true;
		} catch (ParseException p) {
			p.printStackTrace();
			return false;
		}
	}
	
	public String fromDateToString(Date date){
		return df.format(date);
	}

}
