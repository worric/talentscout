import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.UUID;

/** The Agenda class holds an ArrayList of ScoutingSessions.
 * The class is responsible for writing and reading all ScoutingSession objects to a file 
 * as well as planning ScoutingSessions or cancelling planned ScoutingSessions. It can also show 
 * an overview of all the planned ScoutingSessions.
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
	
	// Declare the variables needed for reading/writing data to/from disk
	private String path;
	private String fileName;
	private String pathForFile;
		
	/** Creates an agenda which ties the reference variable "sessions" to a new ArrayList*/
	public Agenda(){
		// Initializing the variables needed for reading/writing data to/from disk
		path = "./playerfiles";
		fileName = "agendadb";
		pathForFile = path+"/"+fileName;
		
		// Loads the previously saved database on the hard drive,
                // or creates one if none has been saved yet.
		loadAgenda();
	}
	
	/**
	 * Save the current list of ScoutingSessions to disk.
	 */
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
                    
		}
	}
    
	/**
	* Load a file which contains all ScoutingSession objects.
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
		
			sessions = agendaArray;
	
		} catch (Exception e){
			sessions = new ArrayList<ScoutingSession>();
		}
	}
	
	/**
	 * Creates a new ScoutingSession Objects which is added to the ArrayList "sessions". 
         * Besides the location and date, which are user given information, the ScoutingSession
         * object also holds a unique ID.
	 * @param location is the location of where a planned ScoutingSession takes place.
	 * @param date is the date of when a ScoutingSession takes place.
	 * @return A ScoutingSession Object
	 * */
	public ScoutingSession planSession(String location, Date date){
		ScoutingSession session = new ScoutingSession(location, date, UUID.randomUUID());
		sessions.add(session);
		return session;
	}
	
	/**
         * Removes a ScoutingSession Object from the list of ScoutingSessions.
         * @param session The ScoutingSession which will be removed.
         */
	public void cancelSession(ScoutingSession session){
		sessions.remove(session);
	}
	
	/**
	 * Gets a ScoutingSession from the ArrayList "sessions".
	 * @param index The index in the ArrayList of a ScoutingSession Object
	 * @return ScoutingSession A ScoutingSession Object
	 */
	public ScoutingSession getSessionByIndex(int index){
		return sessions.get(index);
	}
	
	/**
	 * Gets a ScoutingSession from the ArrayList "sessions" based on the ID of the object.
	 */
	public ScoutingSession getSessionByID(UUID uuid){
		for(ScoutingSession s : sessions){
			if (s.getSessionID().equals(uuid)){
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
	
    /**
    * Checks if the directory for player files is created.
    * If it isn't, we create it using mkdir(). 
    */
    private void checkDirectoryExist(){
    	File playerDir = new File("./playerfiles");
        // We check if the directory for the file is created
        if(!playerDir.isDirectory()){
            // If it doesn't exist, we create it with mkdir().
            playerDir.mkdir();
        }
    }
}
