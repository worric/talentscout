import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

public class AgendaTest {

	@Test
	public final void testSaveAgenda() {
		fail("Not yet implemented");
	}

	@Test
	public final void testLoadAgenda() {
		fail("Not yet implemented");
	}

	@Test
	public final void testPlanSession() {
		Date date = UserInterface.DATEMANAGER.fromStringToDate("27-05-2015");
		String location = "Skodsborg";
		int sessionID;

		ScoutingSession s = UserInterface.AGENDA.planSession(location, date);
		sessionID = s.getSessionID();
		
		// test if it's the same session in the agenda as in the local variable "output"
		assertEquals(s, UserInterface.AGENDA.getSessionByID(sessionID));
		// test if the date of the session matches the one in the local variable "d"
		assertEquals(date, UserInterface.AGENDA.getSessionByID(sessionID).getDate());
		// test if the location of the session matches the one in the local variable "location"
		assertEquals(location, UserInterface.AGENDA.getSessionByID(sessionID).getLocation());
	}

	@Test
	public final void testCancelSession() {
		Date date = UserInterface.DATEMANAGER.fromStringToDate("27-05-2015");
		String location = "Skodsborg";
		int sessionID;

		ScoutingSession s = UserInterface.AGENDA.planSession(location, date);
		sessionID = s.getSessionID();
		
		UserInterface.AGENDA.cancelSession(s);
		
		assertNull(UserInterface.AGENDA.getSessionByID(sessionID));
	}

	@Test
	public final void testGetSessionByIndex() {
		Date date = UserInterface.DATEMANAGER.fromStringToDate("27-05-2015");
		String location = "Skodsborg";
		int sessionID;

		ScoutingSession s = UserInterface.AGENDA.planSession(location, date);
		sessionID = s.getSessionID();
		
		int numberOfSessions = UserInterface.AGENDA.getNumberOfSessions() - 1;
		
		assertEquals(s, UserInterface.AGENDA.getSessionByIndex(numberOfSessions));
	}

	@Test
	public final void testGetSessionByID() {
		Date date = UserInterface.DATEMANAGER.fromStringToDate("27-05-2015");
		String location = "Skodsborg";
		int sessionID;

		ScoutingSession s = UserInterface.AGENDA.planSession(location, date);
		sessionID = s.getSessionID();
		
		ScoutingSession testS = UserInterface.AGENDA.getSessionByID(sessionID);
		
		assertEquals(s, testS);
	}

	@Test
	public final void testGetSortedList() {
		Date date = UserInterface.DATEMANAGER.fromStringToDate("27-11-2015");
		Date date0 = UserInterface.DATEMANAGER.fromStringToDate("01-05-2014");
		Date date1 = UserInterface.DATEMANAGER.fromStringToDate("12-05-2016");
		String location = "Skodsborg";
		String location0 = "Frederiksberg";
		String location1 = "Bornholm";
		ArrayList<ScoutingSession> nonSortedList = new ArrayList<ScoutingSession>();
		ArrayList<ScoutingSession> selfSortedList = new ArrayList<ScoutingSession>();
		ArrayList<ScoutingSession> sortedList;

		ScoutingSession s = UserInterface.AGENDA.planSession(location, date);
		nonSortedList.add(s);
		ScoutingSession s0 = UserInterface.AGENDA.planSession(location0, date0);
		nonSortedList.add(s0);
		ScoutingSession s1 = UserInterface.AGENDA.planSession(location1, date1);
		nonSortedList.add(s1);
		
		selfSortedList.add(s1);
		selfSortedList.add(s);
		selfSortedList.add(s0);
		
		sortedList = UserInterface.AGENDA.getSortedList();
		
		assertEquals(selfSortedList, sortedList);
	}

	@Test
	public final void testGetNumberOfSessions() {
		int numberOfSessions = UserInterface.AGENDA.getNumberOfSessions();
		
		assertEquals(0, numberOfSessions);
	}

}
