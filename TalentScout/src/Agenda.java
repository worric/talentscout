import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
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
	private ArrayList<ScoutingSession> sessions;
	
	// Delare the variables needed for reading/writing data to/from disk
	private String path;
	private String fileName;
	private String pathForFile;
	
	// Class variable for generating ID for the planned session
	private static int idCounter = 0;
	
	
	/**Creates an agenda which ties the reference variable "sessions" to a new ArrayList*/
	public Agenda(){
		// Initializing the variables needed for reading/writing data to/from disk
		path = "./playerfiles";
		fileName = "agendadb";
		pathForFile = path+"/"+fileName;
		
		// Loads the previously saved databases on the hard drive, if any
		loadAgenda();
	}
	
	/**
	 * Save the current list of scouting session to disk
	 **/
	public void saveAgenda(){
    		try {
        		// we check if the folder/directory exists
        		checkDirectoryExist();
        		
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
	public void loadAgenda(){
		try {
    			// Connection established to the file
    			FileInputStream fi = new FileInputStream(pathForFile);
    	
    			// Preparing for reading of file
    			ObjectInputStream oi = new ObjectInputStream(fi);
    	
    			// Reading the file 
    			@SuppressWarnings("unchecked")
    			ArrayList<ScoutingSession> agendaArray = (ArrayList<ScoutingSession>) oi.readObject();
    	
    			//Closing the stream
    			oi.close();
    			
    			int highestNumber = 0;
    			for(ScoutingSession s : agendaArray){
    				if(s.getSessionID() > highestNumber){
    					highestNumber = s.getSessionID();
    				}
    			}
    			
    			Agenda.idCounter = highestNumber + 1;
    		
    			sessions = agendaArray;
    	
    		} catch (Exception e){
    			e.printStackTrace();
    			sessions = new ArrayList<ScoutingSession>();
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
		sessions.remove(session);
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
	 * Returns an ArrayList of scouting sessions, sorted by date, to be presented in the GUI
	 */
	public ArrayList<ScoutingSession> getSortedList(){
		// Clone the current list of scouting sessions
		ArrayList<ScoutingSession> list = (ArrayList<ScoutingSession>)sessions.clone();
		
		// Perform the actual sorting of the list, based on date
		Collections.sort(list);
		
		// Return the sorted list
		return list;
	}
	
	/**
	 * Returns the total number of sessions in the ArrayList.
	 * Primarily used by other classes when iterating through scouting sessions.
	 */
	public int getNumberOfSessions(){
		return sessions.size();
	}
	
	private void checkDirectoryExist(){
    	File playerDir = new File("./playerfiles");
        // We check if the directory for the file is created
        if(!playerDir.isDirectory()){
            // If it doesn't exist, we create it with mkdir().
            playerDir.mkdir();
        }
    }
}
