import java.util.ArrayList;

/**
 * This class is responsible for the search function.
 * 
 * @author Frederik Frode Nygart
 * @author Mikkel Mørch
 * @author Jacob Krag Hansen
 * @author Robin Damsgaard Larsen
 * @author Lotte Selnø
 * @author Bjørn Alsted Nielsen 
 */
public class Search {
	
	/**
	 * Call the database and loop through all players one at a time to
	 * determine if it fits the search criteria. If it does, add to a list to be returned to the caller
	 * @param searchStringName - Player name which will be searched upon.
	 * @param searchStringClub - Club of the player which will be search upon.
	 * @return searchedList - An ArrayList of Player Objects which match the search criteria.
	 */
	public ArrayList<Player> performSearch(String searchStringName, String searchStringClub){
		
		// initialize a new list that holds the results of the search
		ArrayList<Player> searchedList = new ArrayList<Player>();
		
		// Loop through the database one player at a time and add it to a list to
		// be returned to the GUI if it matches
		for(int i = 0; i < UserInterface.PDB.getSize(); i++){
			// Local player variable initialized
			Player p = UserInterface.PDB.getPlayerByIndex(i);

			// Check if the player matches the search criteria and add it to
			// the local list of results if it does. Convert all to lower case to
			// enable the search to function
			if (p.getName().toLowerCase().contains(searchStringName.toLowerCase()) &&
					p.getClub().toLowerCase().contains(searchStringClub.toLowerCase())){
				searchedList.add(p);
			}
		}
		// Always return the list even though it may be empty.
		return searchedList;
	}
}
