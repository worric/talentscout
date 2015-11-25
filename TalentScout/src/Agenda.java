import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;

/**The Agenda class holds an ArrayList of ScoutingSessions.
 *The class is responsible for planning ScoutingSessions or canceling planned ScoutingSessions. 
 *It can also show an overview of all the planned ScoutingSessions.
 *
 * @author Frederik Frode Nygart
 */

public class Agenda {
	
	/**ArrayList with ScoutingSessions referred to as sessions.*/
	private ArrayList <ScoutingSession> sessions;
	
	/** A generic ScoutingSession referred to as session.*/
	private ScoutingSession session;
	
	private String path;
	private String fileName;
	private String pathForFile;
	
	
	/**The Agenda constructor which ties the reference variable sessions to a new ArrayList*/
	public Agenda(){		
		// Declaring the directory of the file we want to access
		path = "./playerfiles";
		fileName = "agendadb";
		pathForFile = path+"/"+fileName;
		
		sessions = this.loadAgenda();
	}
	
    public void saveAgenda(){
    	try {
    		//Connecting to the file
    		FileOutputStream fo = new FileOutputStream(pathForFile);
    		
    		//Opening the file
    		ObjectOutputStream oo = new ObjectOutputStream(fo);
    		
    		// Writing to the file 
    		oo.writeObject(this.sessions);
    		
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
    	
    	/* Print to console for test
    	for(int i = 0; i < arrayOfPlayers.size(); i++){
    		// prints Player Objects
    		System.out.println(arrayOfPlayers.get(i).getName());

    		int NN = arrayOfPlayers.get(i).getNumberOfNotes();
    		for(int j = 0; j < NN; j++){
    			// prints Note Objects of that Player
    			System.out.println(arrayOfPlayers.get(i).getNote(j));
    		}
    		System.out.println("-------");
    	}*/
    	
    	return agendaArray;
    	
    	} catch (Exception e){
    		e.printStackTrace();
    		return new ArrayList<ScoutingSession>();
    	}
    }

	
	
	/**This method plans a new ScoutingSession by add'ing it to the ArrayList sessions. It also gives the new ScoutingSession an unique sessionID.
	 * @param place, date
	 * @return
	 * */
	public ScoutingSession planSession(String place, Date date){
		String sessionID = generateSessionID();
		ScoutingSession session = new ScoutingSession(place, date, sessionID);
		sessions.add(session);
		return session;
	}
	
	public String generateSessionID(){
		return "Session" + sessions.size();
	}
	
	
	/**This method cancels an already planned ScoutingSession.
	 * @see #planSession()
	 * @param
	 * */
	public void cancelSession(ScoutingSession session){
		sessions.remove(session);
	}
	
	
	/**
	 * 
	 * @param i
	 * @return
	 */
	public ScoutingSession getSession(int index){
		return sessions.get(index);
	}
	
	public ScoutingSession findSession(String sessionID){
		for(int i = 0; i < sessions.size(); i++){
			ScoutingSession session = getSession(i);
			if(sessionID.equals(session.getSessionID())){
				return session;
			}
		}
		return null;
	}
	
	public void displaySession(int index){
		System.out.println(sessions.get(index));
	}
	
	public void displaySessionOverview(){
		for(int i = 0; i < sessions.size(); i++){
			displaySession(i);
		}
	}
	
	public ArrayList<ScoutingSession> getList(){
		return sessions;
	}
	
    /**
     * Checks if the directory for player files is created.
     * If it isn't, we create it using mkdir(). 
     */
    public void checkDirectoryExist(){
    	File playerDir = new File("./playerfiles");
        // We check if the directory for the file is created
        if(!playerDir.isDirectory()){
            // If it doesn't exist, we create it with mkdir().
            playerDir.mkdir();
            /*
            if(!preference.getPlayerDir().isDirectory()){
            String lol = System.getProperty("user.dir");
            System.out.println(lol);
            }*/
        }
    }
}
