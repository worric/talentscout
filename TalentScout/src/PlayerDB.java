import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class PlayerDB implements Observer {
	
	private ArrayList<Player> playerDB;
	private Observable agenda;
	
	public PlayerDB(Observable o, function func){
		this.playerDB = loadPlayerDB();
		this.agenda = o;
		agenda.addObserver(this);
	}
	
    /**
     * Saves all current Player Objects in the ArrayList<Player> to the playerdb file
     * @param playerList
     */
    public void savePlayerDB(ArrayList<Player> playerList){
    	try {
    		
    		// Declaring the directory of the file we want to access
    		String path ="./playerfiles";
    		String fileName = "playerdb";
    		String pathForFile = path+"/"+fileName;
    		
    		//Connecting to the file
    		FileOutputStream fo = new FileOutputStream(pathForFile);
    		
    		//Opening the file
    		ObjectOutputStream oo = new ObjectOutputStream(fo);
    		
    		// Writing to the file 
    		oo.writeObject(playerList);
    		
    		oo.close();
    	} catch (Exception e){
    		e.printStackTrace();
    	}
    }
    
    /**
     * Load a file which contains all player objects
     * @return
     */
    public ArrayList<Player> loadPlayerDB(){
    	try {
    	//Directory of file containing Player Objects
    		// Declaring the directory of the file we want to access
    		String path ="./playerfiles";
    		String fileName = "playerdb";
    		String pathForFile = path+"/"+fileName;
    		
    	// Connection established to the file
    	FileInputStream fi = new FileInputStream(pathForFile);
    	
    	// Preparing for reading of file
    	ObjectInputStream oi = new ObjectInputStream(fi);
    	
    	// Reading the file 
    	@SuppressWarnings("unchecked")
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
    		return null;
    	}
    }
    
    /**
     * Creates a Player object with specified attributes which is added to the PlayerDB ArrayList
     * @param name name of the player
     * @param age player's age
     * @param club club of the player
     * @return a Player object
     */
    public void register(String name, int age, String club){
        Player plr = new Player(name, age, club);
        /*plr.setName(name);
        plr.setAge(age);
        plr.setClub(club);*/
        
        addPlayer(plr);
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
	
	public ArrayList<Player> getArrayListPlayer(){
		return this.playerDB;
	}
	
	public int getSize(){
		return playerDB.size();
	}
	
	public Player findPlayer(String name){
		for(Player p : playerDB){
			if(p.getName().equals(name)){
				return p;
			}
		}
		return null;
	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof Agenda && arg instanceof ScoutingSession){
			ScoutingSession s = (ScoutingSession) arg;
			Agenda a = (Agenda) o;
			System.out.println(s);
			System.out.println(a);
		}
		
	}

}
