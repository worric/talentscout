import static org.junit.Assert.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

public class AgendaTest {
	
	static Date date;
	static String location;
	
	static File file;
	static File pathAgendaDB;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// setup the path to the files we wish to work on in the test
		file = new File("./playerfiles");
		pathAgendaDB = new File("./playerfiles/agendaDB");
		
		// setup some useful variables in the test class
		date = UserInterface.DATEMANAGER.fromStringToDate("27-05-2015");
		location = "Skodsborg";
	}
	
	@Before
	public void setUp() throws Exception {
		// Deleting the playerfiles folder which may exist
		if(file.exists()){
			String[] contents = file.list();
			for(String token : contents){
				File newFile = new File(file.getPath(), token);
				newFile.delete();
			}
			file.delete();
		}
		
		// setup a default scouting session to be used in some of the tests
		UserInterface.AGENDA.planSession("Fredericia", date);
	}
	
	@After
	public void tearDown() throws Exception {
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
	public final void testSaveAgenda() {
		// Creating a new ScoutingSession object
		ScoutingSession ss = UserInterface.AGENDA.planSession(location, date);
		// Get the ScoutingSession object's ID
		UUID id = ss.getSessionID();
		// Writing to the agendadb file
		UserInterface.AGENDA.saveAgenda();
		
		// Loading the agendadb file
		UserInterface.AGENDA.loadAgenda();
		// Retrieving the ScoutingSession object by the previously declared ID creating
		// a new reference to this object
		ScoutingSession ss2 = UserInterface.AGENDA.getSessionByID(id);
		// Get the new ScoutingSession Object's ID
		UUID id2 = ss2.getSessionID();
		// Comparing the two IDs. They should match.
		assertEquals(id, id2);
		// Comparing the two ScoutingSession objects, which is expected to be
		// different due to the serialization process
		assertNotEquals(ss, ss2);
	}

	@Test
	public final void testLoadAgenda() {
		// Creating a new ScoutingSession object
		ScoutingSession ss = UserInterface.AGENDA.planSession(location, date);
		// Get the ScoutingSession object's ID
		UUID id = ss.getSessionID();
		// Writing to the agendadb file
		UserInterface.AGENDA.saveAgenda();
		
		// Loading the agendadb file
		UserInterface.AGENDA.loadAgenda();
		// Retrieving the ScoutingSession object by the previously declared ID creating
		// a new reference to this object
		ScoutingSession ss2 = UserInterface.AGENDA.getSessionByID(id);
		// Get the new ScoutingSession Object's ID
		UUID id2 = ss2.getSessionID();
		// Comparing the two IDs. They should match.
		assertEquals(id, id2);
		// Comparing the two ScoutingSession objects, which is expected to be
		// different due to the serialization process
		assertNotEquals(ss, ss2);
	}

	@Test
	public final void testPlanSession() {
		// setup a scouting session
		ScoutingSession ss = UserInterface.AGENDA.planSession(location, date);
		UUID id = ss.getSessionID();
		
		// test if it's the same session in the database
		assertEquals(ss, UserInterface.AGENDA.getSessionByID(id));
		// test if the date of the session matches the specified one
		assertEquals(date, UserInterface.AGENDA.getSessionByID(id).getDate());
		// test if the location of the session matches the specified one
		assertEquals(location, UserInterface.AGENDA.getSessionByID(id).getLocation());
	}

	@Test
	public final void testGetSessionByIndex() {
		// setup a scouting session
		ScoutingSession ss = UserInterface.AGENDA.planSession(location, date);
		
		// since we know there should be 2 sessions in the database,
		// we test if the newly added scouting session has index 1
		assertEquals(2, UserInterface.AGENDA.getNumberOfSessions());
		assertEquals(ss, UserInterface.AGENDA.getSessionByIndex(1));
	}

	@Test
	public final void testGetSessionByID() {
		// setup a scouting session and save its id
		ScoutingSession ss = UserInterface.AGENDA.planSession(location, date);
		UUID id = ss.getSessionID();
		
		// create a new ScoutingSession object and 
		ScoutingSession ss2 = UserInterface.AGENDA.getSessionByID(id);
		
		assertEquals(ss, ss2);
	}

	@Test
	public final void testGetSortedList() {
		// setup some new dates and locations
		Date date = UserInterface.DATEMANAGER.fromStringToDate("27-11-2015");
		Date date0 = UserInterface.DATEMANAGER.fromStringToDate("01-05-2014");
		Date date1 = UserInterface.DATEMANAGER.fromStringToDate("12-05-2016");
		String location = "Skodsborg";
		String location0 = "Frederiksberg";
		String location1 = "Bornholm";
		
		// setup some lists to be used in the test
		// nonsortedlist should hold a list of sessions we know is not sorted by date
		ArrayList<ScoutingSession> nonSortedList = new ArrayList<ScoutingSession>();
		// selfsortedlist should hold a list we sort by ourself that we know is correctly sorted
		ArrayList<ScoutingSession> selfSortedList = new ArrayList<ScoutingSession>();
		// sortedlist is the returned one from the method we wish to test
		ArrayList<ScoutingSession> sortedList;

		// setup some scouting sessions and add them to the nonsorted list in a
		// manner we know is not sorted by date
		ScoutingSession ss = UserInterface.AGENDA.planSession(location, date);
		nonSortedList.add(ss);		// date: 27-11-2015
		ScoutingSession ss0 = UserInterface.AGENDA.planSession(location0, date0);
		nonSortedList.add(ss0);		// date: 01-05-2014
		ScoutingSession ss1 = UserInterface.AGENDA.planSession(location1, date1);
		nonSortedList.add(ss1);		// date: 12-05-2016
		// get the existing ScoutingSession object from the test setup method 
		// and add it to the list
		ScoutingSession ss2 = UserInterface.AGENDA.getSessionByIndex(0);
		nonSortedList.add(ss2);		// date: 27-05-2015
		
		// setup the self sorted list in the correct order
		selfSortedList.add(ss1);	// date: 12-05-2016
		selfSortedList.add(ss);		// date: 27-11-2015
		selfSortedList.add(ss2);	// date: 27-05-2015
		selfSortedList.add(ss0);	// date: 01-05-2014
		
		// load the sorted list from the Agenda class
		sortedList = UserInterface.AGENDA.getSortedList();
		
		// check if the selfsortedlist is equal to the the generated one
		assertEquals(selfSortedList, sortedList);
		// and test if the nonsortedlist is NOT equal to the generated one
		assertNotEquals(nonSortedList, sortedList);
	}

	@Test
	public final void testGetNumberOfSessions() {
		// get the number of scouting sessions and check if it is one,
		// which it should be based on the setup
		int numberOfSessions = UserInterface.AGENDA.getNumberOfSessions();
		assertEquals(1, numberOfSessions);
		
		// setup a scouting session and get the number again
		ScoutingSession ss = UserInterface.AGENDA.planSession(location, date);
		numberOfSessions = UserInterface.AGENDA.getNumberOfSessions();
		
		// test of the number is now equal to 2 
		assertEquals(2, numberOfSessions);
	}
	
	@Test
	public final void testCancelSession() {
		// setup a scouting session and save its id
		ScoutingSession ss = UserInterface.AGENDA.planSession(location, date);
		UUID id = ss.getSessionID();
		
		// try removing the same scouting session
		UserInterface.AGENDA.cancelSession(ss);
		
		// the test should return null because the id is no longer in the list
		assertNull(UserInterface.AGENDA.getSessionByID(id));
	}
}
