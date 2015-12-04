import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

public class ScoutingSessionTest {

	@Test
	public final void testGetLocation() {
		Date date = UserInterface.DATEMANAGER.fromStringToDate("27-05-2015");
		String location = "Skodsborg";
		int sessionID;

		ScoutingSession s = UserInterface.AGENDA.planSession(location, date);
		sessionID = s.getSessionID();
		
		assertSame(location, UserInterface.AGENDA.getSessionByID(sessionID).getLocation());
	}

	@Test
	public final void testSetLocation() {
		Date date = UserInterface.DATEMANAGER.fromStringToDate("27-05-2015");
		String location = "Skodsborg";
		int sessionID;

		ScoutingSession s = UserInterface.AGENDA.planSession(location, date);
		sessionID = s.getSessionID();
		
		String newLocation = "Frederikshavn";
		UserInterface.AGENDA.getSessionByID(sessionID).setLocation(newLocation);
		
		assertSame(newLocation, UserInterface.AGENDA.getSessionByID(sessionID).getLocation());
	}

	@Test
	public final void testGetDate() {
		Date date = UserInterface.DATEMANAGER.fromStringToDate("27-05-2015");
		String location = "Skodsborg";
		int sessionID;

		ScoutingSession s = UserInterface.AGENDA.planSession(location, date);
		sessionID = s.getSessionID();
				
		assertSame(date, UserInterface.AGENDA.getSessionByID(sessionID).getDate());
	}

	@Test
	public final void testSetDate() {
		Date date = UserInterface.DATEMANAGER.fromStringToDate("27-05-2015");
		String location = "Skodsborg";
		int sessionID;

		ScoutingSession s = UserInterface.AGENDA.planSession(location, date);
		sessionID = s.getSessionID();
		
		Date newDate = UserInterface.DATEMANAGER.fromStringToDate("28-05-2015");
		UserInterface.AGENDA.getSessionByID(sessionID).setDate(newDate);
		
		assertSame(newDate, UserInterface.AGENDA.getSessionByID(sessionID).getDate());
	}

	@Test
	public final void testGetSessionID() {
		Date date = UserInterface.DATEMANAGER.fromStringToDate("27-05-2015");
		String location = "Skodsborg";
		int sessionID;

		ScoutingSession s = UserInterface.AGENDA.planSession(location, date);
		sessionID = s.getSessionID();
		
		assertSame(sessionID, UserInterface.AGENDA.getSessionByID(sessionID).getSessionID());
	}

	@Test
	public final void testAddPlayer() {
		Date date = UserInterface.DATEMANAGER.fromStringToDate("27-05-2015");
		String location = "Skodsborg";
		int sessionID;
		int playerID;

		ScoutingSession s = UserInterface.AGENDA.planSession(location, date);
		sessionID = s.getSessionID();
		
		Player p = UserInterface.PDB.register("Svend", 12, "FC København");
		playerID = p.getID();
		
		s.addPlayer(p);
		int placeInIndex = 0;
		
		assertEquals(p, UserInterface.AGENDA.getSessionByID(sessionID).getPlayer(placeInIndex));
	}

	@Test
	public final void testGetPlayer() {
		Date date = UserInterface.DATEMANAGER.fromStringToDate("27-05-2015");
		String location = "Skodsborg";
		int sessionID;
		int playerID;

		ScoutingSession s = UserInterface.AGENDA.planSession(location, date);
		sessionID = s.getSessionID();
		
		Player p = UserInterface.PDB.register("Svend", 12, "FC København");
		playerID = p.getID();
		s.addPlayer(p);
		int placeInIndex = 0;
		
		Player checkPlayer;
		checkPlayer = UserInterface.AGENDA.getSessionByID(sessionID).getPlayer(placeInIndex);
		
		
		assertEquals(p, checkPlayer);
	}

	@Test
	public final void testGetNumberOfPlayers() {
		Date date = UserInterface.DATEMANAGER.fromStringToDate("27-05-2015");
		String location = "Skodsborg";
		int sessionID;

		ScoutingSession s = UserInterface.AGENDA.planSession(location, date);
		sessionID = s.getSessionID();
		
		Player p = UserInterface.PDB.register("Svend", 12, "FC København");
		Player p2 = UserInterface.PDB.register("Karl", 14, "Skive");
		int numberOfPlayers = 2;
	
		s.addPlayer(p);
		s.addPlayer(p2);
		
		assertSame(numberOfPlayers, UserInterface.AGENDA.getSessionByID(sessionID).getNumberOfPlayers());
	}

	@Test
	public final void testAddNote() {
		Date date = UserInterface.DATEMANAGER.fromStringToDate("27-05-2015");
		String location = "Skodsborg";
		int sessionID;
		int playerID;

		ScoutingSession s = UserInterface.AGENDA.planSession(location, date);
		sessionID = s.getSessionID();
		
		Player p = UserInterface.PDB.register("Svend", 12, "FC København");
		playerID = p.getID();
		s.addPlayer(p);
		int placeInIndex = 0;
		
		Note n = p.addNote(s, "Hurtig på banen", 4, "Bakker holdkammerater godt op",
				3, "Fin teknik", 5, "Står godt på banen", 3);
		int notePlaceInIndex = 0;
		
		Note checkNote;
		checkNote = UserInterface.AGENDA.getSessionByID(sessionID).getPlayer(placeInIndex).getNote(notePlaceInIndex);
		
		
		assertEquals(n, checkNote);
		assertEquals("Hurtig på banen", UserInterface.AGENDA.getSessionByID(sessionID).getPlayer(placeInIndex).getNote(notePlaceInIndex).getSpeedText());
	}

	@Test
	public final void testRemovePlayer() {
		Date date = UserInterface.DATEMANAGER.fromStringToDate("27-05-2015");
		String location = "Skodsborg";
		int sessionID;

		ScoutingSession s = UserInterface.AGENDA.planSession(location, date);
		sessionID = s.getSessionID();
		
		Player p = UserInterface.PDB.register("Svend", 12, "FC København");
		s.addPlayer(p);
		
		UserInterface.AGENDA.getSessionByID(sessionID).removePlayer(p);
		
		assertEquals(0, UserInterface.AGENDA.getSessionByID(sessionID).getNumberOfPlayers());
	}

	@Test
	public final void testMakeNote() {
		fail("Not yet implemented");
	}
}
