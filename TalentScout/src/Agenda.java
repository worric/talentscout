import java.util.ArrayList;
import java.util.Date;

/**The Agenda class holds an ArrayList of ScoutingSessions.
 *The class is responsible for planning ScoutingSessions or canceling planned ScoutingSessions. 
 *It can also show an overview of all the planned ScoutingSessions.
 *
 * @author Frederik Frode Nygart
 * @author Mikkel Mørch
 * @author Jacob Krag Hansen
 * @author Robin Damsgaard Larsen
 * @author Lotte Selnø
 * @author Bjørn Alsted Nielsen 
 */

public class Agenda {
	
	/**ArrayList with ScoutingSessions referred to as "sessions".*/
	private ArrayList <ScoutingSession> sessions;
	
	// Delare the variables needed for reading/writing data to/from disk
	private String path;
	private String fileName;
	private String pathForFile;
	
	// Class variable for generating ID for the planned session
	private static int idCounter = 0;
	
	// Enables the class to access operations in PlayerDB class
	private PlayerDB pdb;
	
	
	/**Creates an agenda which ties the reference variable "sessions" to a new ArrayList*/
	public Agenda(PlayerDB pdb){
		// Initializing the variables needed for reading/writing data to/from disk
		path = "./playerfiles";
		fileName = "agendadb";
		pathForFile = path+"/"+fileName;
		
		// enables the class to access operations in PlayerDB class
		this.pdb = pdb;
		
		// Loads the previously saved databases on the hard drive, if any
		sessions = this.loadAgenda();
	}
	
	/**
	 * Save the current list of scouting session to disk
	 **/
	public void saveAgenda(){
    		try {
    			//Connecting to the file
    			FileOutputStream fo = new FileOutputStream(pathForFile);
    		
    			//Opening the file
    			ObjectOutputStream oo = new ObjectOutputStream(fo);
    		
    			// Writing to the file 
    			oo.writeObject(this.sessions);
    			
    			// Close the stream
    			oo.close();
    		} catch (Exception e){
    			e.printStackTrace();
    		}
    	}
    
	/**
	* Load a file which contains all agenda objects
	* @return
	*/
	public ArrayList<ScoutingSession> loadAgenda(){
		try {
        		// we check if the folder/directory exists
        		checkDirectoryExist();
        
    			// Connection established to the file
    			FileInputStream fi = new FileInputStream(pathForFile);
    	
    			// Preparing for reading of file
    			ObjectInputStream oi = new ObjectInputStream(fi);
    	
    			// Reading the file 
    			@SuppressWarnings("unchecked")
    			ArrayList<ScoutingSession> agendaArray = (ArrayList<ScoutingSession>) oi.readObject();
    	
    			//Closing the stream
    			oi.close();
    		
    			return agendaArray;
    	
    		} catch (Exception e){
    			e.printStackTrace();
    			return new ArrayList<ScoutingSession>();
    		}
    	}
	
	/**
	 * Plans a ScoutingSession by creating a new ScoutingSession and thereafter adding it to the ArrayList "sessions". It also initiates a new ScoutingSession with an unique sessionID.
	 * @param location is the location of where a planned ScoutingSession takes place.
	 * @param date is the date of when a ScoutingSession takes place.
	 * @return ScoutingSession(location, date)
	 * */
	public ScoutingSession planSession(String location, Date date){
		ScoutingSession session = new ScoutingSession(location, date, Agenda.idCounter);
		sessions.add(session);
		Agenda.idCounter++;
		return session;
	}
	
	/**
	 * This method cancels an already planned ScoutingSession.
	 * @see #planSession()
	 * @param
	 * */
	public void cancelSession(ScoutingSession session){
		int index = sessions.indexOf(session);
		sessions.remove(index);
	}
	
	/**
	 * Gets a ScoutingSession from the ArrayList "sessions".
	 * @param index is an integer value which decides the place of action in the ArrayList
	 * @return ScoutingSession
	 */
	public ScoutingSession getSessionByIndex(int index){
		return sessions.get(index);
	}
	
	/**
	 * Gets a ScoutingSession from the ArrayList "sessions" based on the ID of the object
	 */
	public ScoutingSession getSessionByID(int id){
		for(ScoutingSession s : sessions){
			if (s.getSessionID() == id){
				return s;
			}
		}
		return null;
	}
	
	/**
	 * Displays a ScoutingSession at a chosen index.
	 * @param index is the chosen index which the method should display
	 */
	public void displaySession(int index){
		System.out.println(sessions.get(index));
	}
	
	
	/**
	 * Displays the entire ArrayList "sessions".
	 */
	public void displaySessionOverview(){
		for(int i = 0; i < sessions.size(); i = i + 1){
			displaySession(i);
		}
	}
	
	/**
	 * Returns an ArrayList of scouting sessions sorted by date to be presented in the GUI
	 */
	public ArrayList<ScoutingSession> getSortedList(){
		// Clone the current list of scouting sessions
		ArrayList<ScoutingSession> list = (ArrayList<ScoutingSession>)sessions.clone();
		
		// Perform the actual sorting of the list, based on date
		Collections.sort(list);
		
		// Return the sortes list
		return list;
	}
	
	/**
	 * Returns the total number of sessions in the ArrayList - primarily used by other classes when iterating through scouting sessions.
	 */
	public int getNumberOfSessions(){
		return sessions.size();
	}

	

}
