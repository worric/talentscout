import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;

public class PlayerDBTest {

	static String name;
	static int age;
	static String club;
	static File file;
	static File pathPlayerDB;
	static ArrayList<Player> playerDB;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		file = new File("./playerfiles");
		pathPlayerDB = new File("./playerfiles/playerDB");
		
		name = "Karl";
		age = 14;
		club ="Aab";
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
		
		// Pre-registering three player objects
		UserInterface.PDB.register(name, age, club);
		UserInterface.PDB.register("Børge", 12, "Hørning");
		UserInterface.PDB.register("Johan", 54, "Skagen IK");
	}
	
	@After
	public void tearDown() throws Exception {
		UserInterface.PDB.getArrayListPlayer().clear();
	}

	@Test
	public void testSavePlayerDB() {
		// Creating a new Player Object
		Player p = UserInterface.PDB.register(name, age, club);
		// Get the Player Object's ID
		int id = p.getID();
		// Writing to the playerdb file
		UserInterface.PDB.savePlayerDB();
		// Checking if the playerdb file has been created
		assertTrue(pathPlayerDB.exists());
		
		// Loading the playerdb file
		UserInterface.PDB.loadPlayerDB();
		// Retrieving the Player Object by the before declared ID creating a new Player Object
		Player p2 = UserInterface.PDB.getPlayerById(id);
		// Get the new Player Object's ID
		int id2 = p2.getID();
		// Comparing the two IDs 
		assertEquals(id, id2);
		// Comparing the two Player objects, which is expected to be different due to Serialization
		assertNotEquals(p, p2);
	}

	@Test
	public void testLoadPlayerDB() {
		fail("Not yet implemented");
	}

	@Test
	public void testRegister() {
		// new Player object
		Player p = UserInterface.PDB.register(name, age, club);
		// get ID of that Player object
		int id = p.getID();
		// Comparing name
		assertEquals(name, UserInterface.PDB.getPlayerById(id).getName());
		// Comparing age
		assertEquals(age, UserInterface.PDB.getPlayerById(id).getAge());
		// Comparing club
		assertEquals(club, UserInterface.PDB.getPlayerById(id).getClub());
		// Comparing the Player object
		assertEquals(p, UserInterface.PDB.getPlayerById(id));
	}

	@Test
	public void testAddPlayer() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemovePlayer() {
		// Adding a player to the database
		Player p1 = UserInterface.PDB.register(name, age, club);
		// get ID
		int id = p1.getID();
		// remove Player from the database
		UserInterface.PDB.removePlayer(p1);
		
		// See if getting that player form the database via ID returns null
		assertNull(UserInterface.PDB.getPlayerById(id));
	}

	@Test
	public void testGetPlayerByIndex() {
		// New ArrayList we want to compare with the original
		ArrayList<Player> list = new ArrayList<Player>();
		for(int i = 0; i < UserInterface.PDB.getSize(); i++){
			// Populating the new ArrayList via getPlayerByIndex()
			list.add(UserInterface.PDB.getPlayerByIndex(i));
		}
		// Comparing the ArrayLists
		assertEquals(list, UserInterface.PDB.getArrayListPlayer());
	}

	@Test
	public void testGetPlayerById() {
		// Adding a player to the database
		Player p1 = UserInterface.PDB.register(name, age, club);
		// Get ID
		int id1 = p1.getID();
		// Retrieve Player object via the getPlayerByID()
		Player p2 = UserInterface.PDB.getPlayerById(id1);
		// Checking if we're getting the same Player objects
		assertEquals(p1, p2);
	}

	@Test
	public void testGetPlayerByName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetArrayListPlayer() {
		// In @Before, we register three players.
		// Thus, we expect the size of the Array returned by this function
		// to be equal to that number. 
		assertEquals(3, UserInterface.PDB.getArrayListPlayer().size());

	}

	@Test
	public void testGetSize() {
		// In @Before, we register three players.
		// Thus, we expect the size of the Array returned by this function
		// to be equal to that number. 
		assertEquals(3, UserInterface.PDB.getSize());
	}

	@Test
	public void testCheckDirectoryExist() {
		// At this point, we know for sure there'll be no playerfiles folder.
		assertFalse(file.isDirectory());
		
		// Thus, we call the method and subsequently check if the folder exists.
		UserInterface.PDB.checkDirectoryExist();
		assertTrue(file.isDirectory());
	}

}
