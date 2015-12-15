import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

/** The PlayerDB class holds an ArrayList of Player Objects.
 *  The class is responsible for writing and reading all Player objects to a file as well as
 *  managing those player objects, e.g. registering and deleting player objects. 
 * 
 * @author Frederik Frode Nygart
 * @author Mikkel Mørch
 * @author Jacob Krag Hansen
 * @author Robin Damsgaard Larsen
 * @author Lotte Selnø
 * @author Bjørn Alsted Nielsen 
 */

public class PlayerDB {
	
	private ArrayList<Player> playerDB;
	private String path;
	private String fileName;
	private String pathForFile;
	
	public PlayerDB(){
		this.path = "./playerfiles";
		this.fileName = "playerdb";
		this.pathForFile = path+"/"+fileName;
		loadPlayerDB();
	}
	
    /**
     * Saves all current Player Objects in the arraylist to the playerdb file.
     * In case the file does not exist, it is created automatically and the objects are written to it.
     */
    public void savePlayerDB(){
    	try {
    		//we check if the folder/directory exists
        	checkDirectoryExist();
    		//Connecting to the file
    		FileOutputStream fo = new FileOutputStream(this.pathForFile);
    		
    		//Opening the file
    		ObjectOutputStream oo = new ObjectOutputStream(fo);
    		
    		// Writing to the file 
    		oo.writeObject(this.playerDB);
    		
    		oo.close();
    	} catch (Exception e){
    		e.printStackTrace();
    	}
    }
    
    /**
     * Loads a file which contains all player objects
     */
    @SuppressWarnings("unchecked")
	public void loadPlayerDB(){
    	try {
    	
        	/**
        	 * FileInputStream throws the FileNotFoundException
        	 */
        	// Connection established to the file
        	FileInputStream fi = new FileInputStream(this.pathForFile);
    	
        	/**
        	 * ObjectInputStream throws the IOException
        	 */
        	// Preparing for reading of file
        	ObjectInputStream oi = new ObjectInputStream(fi);
    	
        	/**
        	 * readObjection throws the ClassNotFoundException
        	 */
        	// Reading the file 
        	ArrayList<Player> arrayOfPlayers = (ArrayList<Player>) oi.readObject();
    	
        	// Closing the stream
        	oi.close();
    	
    		this.playerDB = arrayOfPlayers;
    	
    	} catch (Exception e){
    		e.printStackTrace();
    		// In case the file does not exist - there is not ArrayList to load
    		// we initialize the playerDB ArrayList<Player> and return it. 
    		// playerDB = new ArrayList<Player>();
    		this.playerDB = new ArrayList<Player>();
    	}
    }
    
    /**
     * Creates a Player object with specified attributes which is added to the PlayerDB ArrayList
     * @param name name of the player
     * @param age player's age
     * @param club club of the player
     */
    public Player register(String name, int age, String club){
        Player plr = new Player(name, age, club, UUID.randomUUID());
        playerDB.add(plr);
        return plr;
    }
	
	public void addPlayer(Player p){
		playerDB.add(p);
	}
	
	public void removePlayer(Player p){
		playerDB.remove(p);
	}
	
	public Player getPlayerByIndex(int i){
		return playerDB.get(i);
	}
	
	public Player getPlayerById(UUID uuid){
		
		// Iterate through all players and if ID matches, return that player
		for(Player p : playerDB){
			if (p.getID().equals(uuid)){
				return p;
			}
		}
		return null;
	}
        /*
        public Player getPlayerByName(String name){
            for(Player p : playerDB){
                if(p.getName().equals(name)){
                    return p;
                }
            }
            return null;
        }*/
	
	public ArrayList<Player> getArrayListPlayer(){
		return this.playerDB;
	}
	
	public int getSize(){
		return playerDB.size();
	}
	
        /**
	 * Returns an ArrayList of players, sorted by club, to be presented in the GUI
	 */
	public ArrayList<Player> getSortedList(){
		// Clone the current list of scouting sessions
		ArrayList<Player> list = (ArrayList<Player>)playerDB.clone();
		
		// Perform the actual sorting of the list, based on date
		Collections.sort(list);
		
		// Return the sorted list
		return list;
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
        }
    }
}