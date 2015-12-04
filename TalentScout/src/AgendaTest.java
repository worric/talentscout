import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class AgendaTest {

	@Test
	public final void testAgenda() {
		fail("Not yet implemented");
	}

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
	public final void testGetArrayList() {
		fail("Not yet implemented");
	}

	@Test
	public final void testDisplaySession() {
		fail("Not yet implemented");
	}

	@Test
	public final void testDisplaySessionOverview() {
		fail("Not yet implemented");
	}

	@Test
	public final void testGetSortedList() {
		fail("Not yet implemented");
	}

	@Test
	public final void testGetNumberOfSessions() {
		fail("Not yet implemented");
	}

}
