import java.util.ArrayList;

public class Search {
	
	// Declare a reference to the player database
	private PlayerDB pdb; // TODO Search must be initialized with a PlayerDB object. UserInterface must also be in itialized with a Search object
	
	/**
	 * The constructor takes an argument of type PlayerDB and initializes its instance variable
	 * @param pdb
	 */
	public Search(PlayerDB pdb){
		this.pdb = pdb;
	}
	/**
	 * Call the database and loop through all players one at a time to
	 * determine if it fits the search criteria. If it does, add to a list to be returned to the caller
	 * @param searchStringName
	 * @param searchStringClub
	 * @return searchedList
	 */
	public ArrayList<Player> performSearch(String searchStringName, String searchStringClub){
		
		// initialize a new list that holds the results of the search
		ArrayList<Player> searchedList = new ArrayList<Player>();
		
		// Loop through the database one player at a time and add it to a list to
		// be returned to the GUI if it matches
		for(int i = 0; i < UserInterface.PDB.getSize(); i++){
			// Local player variable initialized
			Player p = UserInterface.PDB.getPlayerByIndex(i);
			
			// Check if the player matches the search criteria
			/*if (p.getName().toLowerCase().matches(".*" + searchStringName.toLowerCase() + ".*") &&
					p.getClub().toLowerCase().matches(".*" + searchStringClub.toLowerCase() + ".*")){
				
				// Add it to a a local list if it does.
				searchedList.add(p);
			}*/

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
