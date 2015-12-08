import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ScoutingSessionTest {
	
	static String name;
	static int age;
	static String club;
	
	static String location;
	static Date date;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		name = "Karl";
		age = 14;
		club ="Aab";
		
		date = UserInterface.DATEMANAGER.fromStringToDate("27-05-2015");
		location = "Skodsborg";
	}
	
	@Before
	public void setUp() throws Exception {		
		// setup a default scouting session to be used in some of the tests
		UserInterface.AGENDA.planSession(location, date);
	}
	
	@After
	public void tearDown() throws Exception {
		// clear the arraylist of players
		UserInterface.PDB.getArrayListPlayer().clear();
		
		// clear the Agenda list of scouting sessions
		// define a new arraylist
		ArrayList<ScoutingSession> list = new ArrayList<ScoutingSession>();
		// populate it with the same objects as the one in the agenda class
		for(int i = 0; i < UserInterface.AGENDA.getNumberOfSessions(); i++){
			ScoutingSession ss = UserInterface.AGENDA.getSessionByIndex(i);
			list.add(ss);
		}
		// remove all the objects
		for(ScoutingSession ss : list){
			UserInterface.AGENDA.cancelSession(ss);
		}
	}

	@Test
	public final void testGetLocation() {
		// setup ScoutingSession
		ScoutingSession ss = UserInterface.AGENDA.planSession(location, date);
		
		assertEquals(location, ss.getLocation());
	}

	@Test
	public final void testSetLocation() {
		// setup ScoutingSession
		ScoutingSession ss = UserInterface.AGENDA.planSession(location, date);
		
		// create a new location and change it on the session
		String newLocation = "Frederikshavn";
		ss.setLocation(newLocation);
		
		assertEquals(newLocation, ss.getLocation());
	}

	@Test
	public final void testGetDate() {
		// setup ScoutingSession
		ScoutingSession ss = UserInterface.AGENDA.planSession(location, date);
				
		assertEquals(date, ss.getDate());
	}

	@Test
	public final void testSetDate() {
		// setup ScoutingSession
		ScoutingSession ss = UserInterface.AGENDA.planSession(location, date);
		
		// create a new date and change it on the session
		Date newDate = UserInterface.DATEMANAGER.fromStringToDate("28-05-2015");
		ss.setDate(newDate);
		
		assertEquals(newDate, ss.getDate());
	}

	@Test
	public final void testGetSessionID() {
		// setup ScoutingSession
		ScoutingSession ss = UserInterface.AGENDA.planSession(location, date);
		UUID id = ss.getSessionID();
		
		assertEquals(id, ss.getSessionID());
	}

	@Test
	public final void testAddPlayer() {
		Date date = UserInterface.DATEMANAGER.fromStringToDate("27-05-2015");
		String location = "Skodsborg";
		UUID sessionID;
		UUID playerID;

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
		UUID sessionID;
		UUID playerID;

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
		UUID sessionID;

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
		UUID sessionID;
		UUID playerID;

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
		UUID sessionID;

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
