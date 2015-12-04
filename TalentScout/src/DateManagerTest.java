import static org.junit.Assert.*;
import java.util.Date;
import org.junit.Test;

public class DateManagerTest {

	@Test
	public final void testFromStringToDate() {
		String date = "01-01-2015";
		String date0 = "23-06-2015";
		String date1 = "31-12-2015";
		String date2 = "32-08-2015";
		String date3 = "322-084-20154";
		String date4 = "ab-cd-efgh";
		String date5 = "a";
		String date6 = "";
		String date7 = "\ny2+i$";
		
		Date d = UserInterface.DATEMANAGER.fromStringToDate(date);
		Date d0 = UserInterface.DATEMANAGER.fromStringToDate(date0);
		Date d1 = UserInterface.DATEMANAGER.fromStringToDate(date1);
		Date d2 = UserInterface.DATEMANAGER.fromStringToDate(date2);
		Date d3 = UserInterface.DATEMANAGER.fromStringToDate(date3);
		Date d4 = UserInterface.DATEMANAGER.fromStringToDate(date4);
		Date d5 = UserInterface.DATEMANAGER.fromStringToDate(date5);
		Date d6 = UserInterface.DATEMANAGER.fromStringToDate(date6);
		Date d7 = UserInterface.DATEMANAGER.fromStringToDate(date7);
		
		assertEquals(UserInterface.DATEMANAGER.fromDateToString(d), date);
		assertEquals(UserInterface.DATEMANAGER.fromDateToString(d0), date0);
		assertEquals(UserInterface.DATEMANAGER.fromDateToString(d1), date1);
		assertNull(d2);
		assertNull(d3);
		assertNull(d4);
		assertNull(d5);
		assertNull(d6);
		assertNull(d7);
	}

	@Test
	public final void testFromDateToString() {
		String date = "01-01-2015";
		String date0 = "23-06-2015";
		String date1 = "31-12-2015";
		String date2 = "32-08-2015";
		String date3 = "322-084-20154";
		String date4 = "ab-cd-efgh";
		String date5 = "a";
		String date6 = "";
		String date7 = "\ny2+i$";
		
		Date d = UserInterface.DATEMANAGER.fromStringToDate(date);
		Date d0 = UserInterface.DATEMANAGER.fromStringToDate(date0);
		Date d1 = UserInterface.DATEMANAGER.fromStringToDate(date1);
		Date d2 = UserInterface.DATEMANAGER.fromStringToDate(date2);
		Date d3 = UserInterface.DATEMANAGER.fromStringToDate(date3);
		Date d4 = UserInterface.DATEMANAGER.fromStringToDate(date4);
		Date d5 = UserInterface.DATEMANAGER.fromStringToDate(date5);
		Date d6 = UserInterface.DATEMANAGER.fromStringToDate(date6);
		Date d7 = UserInterface.DATEMANAGER.fromStringToDate(date7);
		
		assertEquals(date, UserInterface.DATEMANAGER.fromDateToString(d));
		assertEquals(date0, UserInterface.DATEMANAGER.fromDateToString(d0));
		assertEquals(date1, UserInterface.DATEMANAGER.fromDateToString(d1));
		assertNull(d2);
		assertNull(d3);
		assertNull(d4);
		assertNull(d5);
		assertNull(d6);
		assertNull(d7);
	}

}
