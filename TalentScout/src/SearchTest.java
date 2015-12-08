import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;
import org.junit.BeforeClass;

public class SearchTest {
	
	static Search search;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		search = new Search(UserInterface.PDB);

		Player p = UserInterface.PDB.register("Svend", 12, "FC København");
		Player p0 = UserInterface.PDB.register("Karsten Schröder", 14, "Sæby");
		Player p1 = UserInterface.PDB.register("Svend Svendsen", 15, "FC Skive");
		Player p2 = UserInterface.PDB.register("Svend Svendsen", 15, "FC Skive");
		Player p3 = UserInterface.PDB.register("Jokum", 15, "Aalborg");
		assertEquals(5, UserInterface.PDB.getSize());
	}

	@Test
	public void testPerformSearch() {
		// no filters - all should match
		String searchName = "";
		String searchClub = "";
		ArrayList<Player> playerList = search.performSearch(searchName, searchClub);
		assertEquals(5, playerList.size());
		
		// filter name "svend" and club "køben" - one result expected
		searchName = "svend";
		searchClub = "køben";
		playerList = search.performSearch(searchName, searchClub);
		assertEquals(1, playerList.size());
		
		// filter string within a name - 3 results expected
		searchName = "ven";
		searchClub = "";
		playerList = search.performSearch(searchName, searchClub);
		assertEquals(3, playerList.size());
		
		// filter club name - 2 results expected
		searchName = "";
		searchClub = "FC Skive";
		playerList = search.performSearch(searchName, searchClub);
		assertEquals(2, playerList.size());
		
		// filter name matches but not club - no results expected
		searchName = "Svend";
		searchClub = "Oksbøl";
		playerList = search.performSearch(searchName, searchClub);
		assertEquals(0, playerList.size());
		
		// filter name and club do not match - no results
		searchName = "f";
		searchClub = "å";
		playerList = search.performSearch(searchName, searchClub);
		assertEquals(0, playerList.size());
		
		// filter one space in both name and club - 2 results expected
		searchName = " ";
		searchClub = " ";
		playerList = search.performSearch(searchName, searchClub);
		assertEquals(2, playerList.size());
		
		// filtering uncommon characters - 1 result expected
		searchName = "Schröder";
		searchClub = "";
		playerList = search.performSearch(searchName, searchClub);
		assertEquals(1, playerList.size());
		
		// filter two spaces in the name - no results expected
		searchName = "  ";
		searchClub = "";
		playerList = search.performSearch(searchName, searchClub);
		assertEquals(0, playerList.size());
	}
}
