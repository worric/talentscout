import java.util.Locale;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;
/**
 * The purpose of this class is to provide date sanity checks to the create/edit ScoutingSession functionality
 * @author folmer
 *
 */
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
	} //constructor end
	
	/**
	 * Default constructor. Danish language and a default pattern matching the Danish date notation.
	 */
	public DateManager(){
		this("dd-MM-yyyy", Locale.forLanguageTag("da"));
	}
	
	/**
	 * Method that takes a String and returns a Date object holding the same information
	 */
	public Date fromStringToDate(String date){
		try {
			return df.parse(date);
		} catch (ParseException p) {
			p.printStackTrace();
			return null;
		}
	}
        /**
	 * Function that can take a date object and return the date in the
	 * same notation as the pattern specified in the constructor 
	 * @param date
	 * @return
	 */
	public String fromDateToString(Date date){
		return df.format(date);
 	}
	
}
