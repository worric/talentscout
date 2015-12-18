import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PlayerTest {
	
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
		// Pre-registering three player objects to simulate the presence
		// of a few objects in the database already
		UserInterface.PDB.register(name, age, club);
		UserInterface.PDB.register("Børge", 12, "Hørning");
		UserInterface.PDB.register("Johan", 54, "Skagen IK");
		
		// pre-planning one scoutingsession in the agenda db
		UserInterface.AGENDA.planSession(location, date);
	}

	@After
	public void tearDown() throws Exception {
		// clear the arraylist of players
		UserInterface.PDB.getArrayListPlayer().clear();
		
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
	public void testAddNoteScoutingSessionStringIntStringIntStringIntStringInt() {
		// setup ScoutingSession, a Player and a Note, and add the note to the player
		ScoutingSession s = UserInterface.AGENDA.planSession(location, date);
		Player p = UserInterface.PDB.register(name, age, club);
		Note n = p.addNote(s, "God", 4, "Bakker godt op", 4, "Teknisk svag", 2, 
				"Står godt på banen", 6);
		
		// Compare index 0 note on the player, which is the only note on the given player
		assertEquals(n, p.getNote(0));
	}

	@Test
	public void testGetNote() {
		// setup ScoutingSession, a Player and a Note, and add the note to the player
		ScoutingSession s = UserInterface.AGENDA.planSession(location, date);
		Player p = UserInterface.PDB.register(name, age, club);
		Note n = p.addNote(s, "God", 4, "Bakker godt op", 4, "Teknisk svag", 2, 
				"Står godt på banen", 6);
		
		// check if the note is equal to the one created. Since it's the only note
		// the player has, we know it should be in index 0
		assertEquals(n, p.getNote(0));
	}

	@Test
	public void testGetNumberOfNotes() {
		// setup ScoutingSession, a Player and 2 Notes, and add the notes to the player
		ScoutingSession s = UserInterface.AGENDA.planSession(location, date);
		Player p = UserInterface.PDB.register(name, age, club);
		Note n = p.addNote(s, "God", 4, "Bakker godt op", 4, "Teknisk svag", 2, 
				"Står godt på banen", 6);
		Note n2 = p.addNote(s, "Middel", 3, "Har temperament", 2, "Teknisk stærk", 5, 
				"Står lidt galt på banen", 3);
		
		assertEquals(2, p.getNumberOfNotes());
	}

	@Test
	public void testGetAverage() {
		// setup a player and a scouting session
		Player p = UserInterface.PDB.register(name, age, club);
		ScoutingSession s = UserInterface.AGENDA.planSession(location, date);
		// assert its value of the SPEED parameter equal to 0 with no notes
		// should return 0.0, as no notes are defined and we wish to avoid dividing by 0
		assertEquals(0.0, p.getAverage(Player.Parameters.SPEED), 0.0);
		
		// setup a new note
		Note n = p.addNote(s, "God", 4, "Bakker godt op", 4, "Teknisk svag", 2, 
				"Står godt på banen", 6);
		// assert the player's average score with regards to the SPEED parameter
		assertEquals(4.0, p.getAverage(Player.Parameters.SPEED), 0.0);
		// assert the player's average score with regards to the ATTITUDE parameter
		assertEquals(4.0, p.getAverage(Player.Parameters.ATTITUDE), 0.0);
		// assert the player's average score with regards to the TECHNIQUE parameter
		assertEquals(2.0, p.getAverage(Player.Parameters.TECHNIQUE), 0.0);
		// assert the player's average score with regards to the GAMESENSE parameter
		assertEquals(6.0, p.getAverage(Player.Parameters.GAMESENSE), 0.0);
		
		// setup a new note with different values
		Note n2 = p.addNote(s, "God", 3, "Bakker godt op", 5, "Teknisk svag", 1, 
						"Står godt på banen", 5);
		
		// setup the known results
		double speedResult = (4.0+3.0)/2;
		double attitudeResult = (4.0+5.0)/2;
		double techniqueResult = (2.0+1.0)/2;
		double gameSenseResult = (6.0+5.0)/2;
		double totalAverage = (speedResult + attitudeResult + techniqueResult + gameSenseResult)/4;
		
		// assert the player's average score with regards to the SPEED parameter
		assertEquals(speedResult, p.getAverage(Player.Parameters.SPEED), 0.0);
		// assert the player's average score with regards to the ATTITUDE parameter
		assertEquals(attitudeResult, p.getAverage(Player.Parameters.ATTITUDE), 0.0);
		// assert the player's average score with regards to the TECHNIQUE parameter
		assertEquals(techniqueResult, p.getAverage(Player.Parameters.TECHNIQUE), 0.0);
		// assert the player's average score with regards to the GAMESENSE parameter
		assertEquals(gameSenseResult, p.getAverage(Player.Parameters.GAMESENSE), 0.0);
		// assert the player's total average score across all parameters
		assertEquals(totalAverage, p.getAverage(Player.Parameters.ALL), 0.0);
	}

	@Test
	public void testGetName() {
		// setup a player
		Player p = UserInterface.PDB.register(name, age, club);
		
		assertEquals(p.getName(), name);
	}

	@Test
	public void testSetName() {
		// setup a player
		Player p = UserInterface.PDB.register(name, age, club);
		
		// setup a new name and change it on the player
		String newName = "Karsten";
		p.setName(newName);
		
		assertEquals(newName, p.getName());
		assertNotEquals(name, p.getName());
	}

	@Test
	public void testGetAge() {
		// setup a player
		Player p = UserInterface.PDB.register(name, age, club);
		
		assertEquals(age, p.getAge());
	}

	@Test
	public void testSetAge() {
		// setup a player
		Player p = UserInterface.PDB.register(name, age, club);
		
		// setup the new age and change it on the player
		int newAge = 15;
		p.setAge(newAge);
		
		assertEquals(newAge, p.getAge());
		assertNotEquals(age, p.getAge());
	}

	@Test
	public void testGetClub() {
		// setup a player
		Player p = UserInterface.PDB.register(name, age, club);
		
		assertEquals(club, p.getClub());
	}

	@Test
	public void testSetClub() {
		// setup a player
		Player p = UserInterface.PDB.register(name, age, club);
		
		// setup the new club and change it on the player
		String newClub = "FC Odense";
		p.setClub(newClub);
		
		assertEquals(newClub, p.getClub());
		assertNotEquals(club, p.getClub());
	}

	@Test
	public void testGetID() {
		Player p = UserInterface.PDB.register(name, age, club);
		UUID id = p.getID(); 
		
		assertEquals(id, p.getID());
	}
	
	@Test
	public void testGetActiveState() {
		// setup a player
		Player p = UserInterface.PDB.register(name, age, club);
		
		// a player is initialized with an activeState = true, so we check for that
		assertTrue(p.getActiveState());
	}

	@Test
	public void testSetInactive() {
		// setup a player
		Player p = UserInterface.PDB.register(name, age, club);
		
		// set the player inactive
		p.setInactive();
		
		assertFalse(p.getActiveState());
	}

	@Test
	public void testSetActive() {
		// setup a player
		Player p = UserInterface.PDB.register(name, age, club);
		
		// set the player inactive and check if it changes
		p.setInactive();
		assertFalse(p.getActiveState());
		
		// set the player active again and check again
		p.setActive();
		assertTrue(p.getActiveState());
	}
}
