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
		// setup ScoutingSession
		ScoutingSession ss = UserInterface.AGENDA.planSession(location, date);
		
		// setup player
		Player p = UserInterface.PDB.register(name, age, club);
		
		// add player to the scouting session and specify the index 0, which
		// we know the player has because it's the only one in the session
		ss.addPlayer(p);
		int placeInIndex = 0;
		
		assertEquals(p, ss.getPlayer(placeInIndex));
	}

	@Test
	public final void testGetPlayer() {
		// setup ScoutingSession
		ScoutingSession ss = UserInterface.AGENDA.planSession(location, date);
		
		// setup player
		Player p = UserInterface.PDB.register(name, age, club);
		
		// add player to the scouting session and specify the index 0, which
		// we know the player has because it's the only one in the session
		ss.addPlayer(p);
		int placeInIndex = 0;
		
		assertEquals(p, ss.getPlayer(placeInIndex));
	}

	@Test
	public final void testGetNumberOfPlayers() {
		// setup ScoutingSession
		ScoutingSession ss = UserInterface.AGENDA.planSession(location, date);
		
		// setup players and specify the number of players we know exists for
		// the given session
		Player p = UserInterface.PDB.register(name, age, club);
		Player p2 = UserInterface.PDB.register("Karl", 14, "Skive");
		int numberOfPlayers = 2;
		
		// add the players to the session
		ss.addPlayer(p);
		ss.addPlayer(p2);
		
		assertEquals(numberOfPlayers, ss.getNumberOfPlayers());
	}

	@Test
	public final void testAddNote() {
		// setup ScoutingSession
		ScoutingSession ss = UserInterface.AGENDA.planSession(location, date);
		
		// setup player
		Player p = UserInterface.PDB.register(name, age, club);
		
		// setup note and save the place in the index, which is 0, because we know
		// it's the only one
		Note n = p.addNote(ss, "Hurtig på banen", 4, "Bakker holdkammerater godt op",
				3, "Fin teknik", 5, "Står godt på banen", 3);
		int notePlaceInIndex = 0;
		
		// add player to the session and note the place in the index, which is 0,
		// because we know it's the only one
		ss.addPlayer(p);
		int placeInIndex = 0;
			
		assertEquals(n, ss.getPlayer(placeInIndex).getNote(notePlaceInIndex));
		//assertEquals("Hurtig på banen", UserInterface.AGENDA.getSessionByID(sessionID).getPlayer(placeInIndex).getNote(notePlaceInIndex).getSpeedText());
	}

	@Test
	public final void testRemovePlayer() {
		// setup ScoutingSession
		ScoutingSession ss = UserInterface.AGENDA.planSession(location, date);
		
		// setup player
		Player p = UserInterface.PDB.register(name, age, club);

		// add the player to the scouting session
		ss.addPlayer(p);
		
		// check that there is one player assigned to the scouting session
		assertEquals(1, ss.getNumberOfPlayers());
		
		// remove the player from the scouting session
		ss.removePlayer(p);
		
		// check that there are 0 players assigned to the scouting session
		assertEquals(0, ss.getNumberOfPlayers());
	}

	@Test
	public final void testMakeNote() {
		fail("Not yet implemented");
	}
	
	@Test
	public final void testUpdate(){
		// setup ScoutingSession
		ScoutingSession ss = UserInterface.AGENDA.planSession(location, date);
		
		// setup player
		Player p = UserInterface.PDB.register(name, age, club);
		Player p2 = UserInterface.PDB.register(name, age, club);

		// add the player to the scouting session
		ss.addPlayer(p);
		ss.addPlayer(p2);
		
		assertEquals(2, ss.getNumberOfPlayers());
		
		UserInterface.PDB.removePlayer(p);
		
		assertEquals(1, ss.getNumberOfPlayers());
		
		UserInterface.PDB.removePlayer(p2);
		
		assertEquals(0, ss.getNumberOfPlayers());
	}
}
