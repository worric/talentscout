import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.text.DateFormat;
import java.util.Locale;


public class DateTest {
	
	public enum hej {skod, lol, lort};
	private static DateManagerFactory dmf;
	
	static Date skod;
	static GregorianCalendar lol;
	static DateTimeFormatter dtf;
	static SimpleDateFormat sdf;
	static String printMe;
	static String printMe2;
	static String inputDate;
	static String inputTime;
	static DateFormat locale;
	static Locale aLocale;
	static Locale aLocaleDanish;
	static DateManager dmgr;

	public static void main(String[] args) {
		dmf = new DateManagerFactory();
		dmgr = dmf.generateDateManager(hej.skod);
		//Locale.setDefault(Locale.forLanguageTag("da"));
		// TODO Auto-generated method stub
		aLocale = Locale.forLanguageTag("da");
		//Locale.setDefault(aLocale);
		
		lol = new GregorianCalendar();
		
		inputDate = "31-12-2015";
		inputTime = "12:30";
		

		if (!inputDate.matches("\\d\\d-\\d\\d-\\d\\d\\d\\d") && !dmgr.isValid(inputDate)){
			System.out.println("Date out of reach!");
		} else {
			lol.setLenient(true);
			lol.setTime(datoszh);
			System.out.println("YES!");
			//System.out.println(datoszh.);
			System.out.println(lol.getTime().toString());
			System.out.println(lol.getActualMaximum(4) + 1);
			System.out.println(lol.getCalendarType());
			//System.out.println(lol.setTime(datoszh));
		}
		
		
		String skodpa = dmgr.fromDateToString(new Date());
		//System.out.println("dette er datoszh: " + datoszh);
		System.out.println();
		System.out.println("dette er skodpa: " + skodpa);
		
		sdf = new SimpleDateFormat("d-M-yyyy", aLocale);
		//Date startDato = sdf.parse(inputDate);
		
		try {
			Date startDato = sdf.parse(inputDate);
			System.out.println("Dette er lige det der skal til: " + startDato.toString() + 
					" (mellemrum) " + sdf.format(startDato));
		} catch (java.text.ParseException p) {
			System.out.println(p.getMessage());
		}
		
		
		skod = new Date();
		printMe = sdf.format(skod);
		printMe2 = DateFormat.getDateInstance(DateFormat.SHORT).format(skod);
		
		System.out.println("Dette er en formatteret dato: " + printMe
				+ ". Og detter printMe2: " + printMe2 + ". Og her er locale: "
				+ aLocale.getDisplayLanguage() + aLocale.getDisplayCountry()
				+ ". Og dette er startDato: ");
		
		//lol.setLenient(true); // er ikke klar over hvad det betyder.
		System.out.println(lol.get(5));
		System.out.println(skod);

	}

}
