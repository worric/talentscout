import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class PlayerDB {
	
	private ArrayList<Player> playerDB;
	private String path;
	private String fileName;
	private String pathForFile;
	
	public PlayerDB(){
		/*try {
			this.playerDB = loadPlayerDB();
		} catch (Exception e) {
			e.printStackTrace();*/

			this.path = "./playerfiles";
			this.fileName = "playerdb";
			this.pathForFile = path+"/"+fileName;
			this.playerDB = loadPlayerDB();
		//}
		
	}
	
    /**
     * Saves all current Player Objects in the ArrayList<Player> to the playerdb file.
     * In case the file does not exist, it is created automatically and the objects are written to it.
     * @param playerList
     */
    public void savePlayerDB(){
    	try {
    		
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
     * @return
     */
    @SuppressWarnings("unchecked")
	public ArrayList<Player> loadPlayerDB(){
    	try {

    	// we check if the folder/directory exists
    	checkDirectoryExist();
    	
    	// we check if the file exists
    	//		- this actually is not necessary as we can resolve this issue in by
    	//		  catching and handling the FiltNotFoundException.
    	// checkFileExist();
    	
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
    	
    	return arrayOfPlayers;
    	
    	} catch (Exception e){
    		e.printStackTrace();
    		// In case the file does not exist - there is not ArrayList to load
    		// we initialize the playerDB ArrayList<Player> and return it. 
    		playerDB = new ArrayList<Player>();
    		return playerDB;
    	}
    }
    
    /**
     * Creates a Player object with specified attributes which is added to the PlayerDB ArrayList
     * @param name name of the player
     * @param age player's age
     * @param club club of the player
     */
    public void register(String name, int age, String club){
        Player plr = new Player(name, age, club, generateID());
        playerDB.add(plr);
    }
	
	public void addPlayer(Player p){
		playerDB.add(p);
	}
	
	public void removePlayer(Player p){
		playerDB.remove(p);
	}
	
	public Player getPlayer(int i){
		return playerDB.get(i);
	}
	
	public Player getPlayer(String id){
		
		for(Player p : playerDB){
			if (p.getID().equals(id)){
				return p;
			}
		}
		return null;
	}
	
	public ArrayList<Player> getArrayListPlayer(){
		return this.playerDB;
	}
	
	public int getSize(){
		return playerDB.size();
	}
	
	private String generateID(){
		return "p"+playerDB.size()+Math.floor(Math.random()*10);
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
    
    /*
    public void checkFileExist(){	
    	// Declaring the name of the directory in which our file of player objects would be 
		String path ="./playerfiles";
		// Declaring the name of the file of player objects
		String fileName = "playerdb";
		// The path of the directory to that file - in type String
		String pathForFile = path+"/"+fileName;
    	
		// Declaring the directory of the file we want to check exists
		File playerDBFile = new File(pathForFile);
		
		// We check if the file exists.
    	if(!playerDBFile.isFile()){
    		// If it doesn't, we create a new ArrayList of type Player.
    		ArrayList<Player> listOfPlayers = new ArrayList<Player>();
    		// We create a file and write the ArrayList to a file. 
    		savePlayerDB(listOfPlayers);
    	}
    }*/

}
