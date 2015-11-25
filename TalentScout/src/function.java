/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mikkelmoerch
 */
public class function {
	
    Agenda agenda;
    PlayerDB plrDB;
    
    function(PlayerDB plrDB, Agenda agenda){
    	this.plrDB = plrDB;
    	this.agenda = agenda;
    }
    
    // CURRENT FUNCTION BEEN WORKED ON
    public ArrayList<Player> searchForName(String inputName)throws Exception{
        // The ArrayList we will populate with Player Objects which match the search criteria
        ArrayList<Player> foundPlayers = new ArrayList<Player>();
        Player plrRestore;
        // Declaring the ArrayList of registered player objects
        ArrayList<Player> currentPlayerDB = plrDB.getArrayListPlayer();
        
        // Loops through the directory of player objects 
        for(int i = 0; i < currentPlayerDB.size(); i++){
            // Open each player object file
            plrRestore = currentPlayerDB.get(i);

            if(inputName.isEmpty()){
                foundPlayers.add(plrRestore);
            } else if(plrRestore.getName().matches(inputName + ".*")){
                //System.out.println(plrRestore.getName());
                //if true, add the player object to the ArrayList
                foundPlayers.add(plrRestore); 
            } else {
                // if false, that is if there are no matches we display an empty table
                foundPlayers.clear();
            }
        }
        // return the ArrayList with all the players found.
        for(int i = 0; i < foundPlayers.size(); i++){
        System.out.println(foundPlayers.get(i).getName());
        }
        return foundPlayers;
    }
    
    // CURRENT FUNCTION BEEN WORKED ON
     public void InsertSearchResultToTableName(String inputName, DefaultTableModel model) throws Exception{

        // ArrayList of players found from search
        ArrayList<Player> playersFound = searchForName(inputName);
        
            // Loop through the players in the ArrayList
            for(int i = 0; i < playersFound.size(); i++){
                
                Player plrRestore = playersFound.get(i);
                // Convert player age from type int to String
                String age = Integer.toString(plrRestore.getAge());
                
                // Make a String array of the players' attributes
                String[] data = {plrRestore.getName(), age, plrRestore.getClub()};
                
                // Add the array to a row in the table
                model.addRow(data);
            }
    }
    

    /** Function concerning the GUI
     * Changes the card in a cardLayout container
     * @param parent the container in which we want to change layout
     * @param child the component (the layout) which we want to add to the container
     */
    public void changeCard(Container parent, Component child){
        // remove all components from the container
        // the method invalidates the component hierarchy, which is why 
        // the hierarchy must be validated to reflect the changes - this is done
        // with revalidate().
        parent.removeAll();
        // adds a component to the container
        parent.add(child);
        // 
        parent.repaint();
        // revalidates the component hierarchy
        parent.revalidate();
    }
    
    public void saveAgenda(ArrayList<ScoutingSession> agenda){
    	try {
    		
    		/*
    		// creating instances of Players and adding Notes to those Player Objects
    		Player Børge = new Player("Børge", 30, "Horsens");
    		Player Ralf = new Player("Ralf", 21, "VIK");
    		Børge.addNote(new Note(null, Børge));
    		Ralf.addNote(new Note(null, Ralf));
    		
    		//adding players to the arrayList
    		playerList.add(Ralf);
    		playerList.add(Børge);*/
    		
    		// Declaring the directory of the file we want to access
    		String path ="./playerfiles";
    		String fileName = "sessiondb";
    		String pathForFile = path+"/"+fileName;
    		
    		//Connecting to the file
    		FileOutputStream fo = new FileOutputStream(pathForFile);
    		
    		//Opening the file
    		ObjectOutputStream oo = new ObjectOutputStream(fo);
    		
    		// Writing to the file 
    		oo.writeObject(agenda);
    		
    		oo.close();
    	} catch (Exception e){
    		e.printStackTrace();
    	}
    }
    
    public ArrayList<ScoutingSession> loadAgenda(){
    	try {
    	//Directory of file containing Player Objects
    		// Declaring the directory of the file we want to access
    		String path ="./playerfiles";
    		String fileName = "sessiondb";
    		String pathForFile = path+"/"+fileName;
    		
    	// Connection established to the file
    	FileInputStream fi = new FileInputStream(pathForFile);
    	
    	// Preparing for reading of file
    	ObjectInputStream oi = new ObjectInputStream(fi);
    	
    	// Reading the file 
    	@SuppressWarnings("unchecked")
    	ArrayList<ScoutingSession> agendaArray;
    	if(oi.readObject() instanceof ArrayList<?>){
    		agendaArray = (ArrayList<ScoutingSession>) oi.readObject();
    	} else {
    		agendaArray = null;
    	}
		
    	
    	//Closing the stream
    	oi.close();
    	
    	for(int i = 0; i < agendaArray.size(); i++){
    		// prints Player Objects
    		System.out.println(agendaArray.get(i));

    		int NN = agendaArray.get(i).getNumberOfPlayers();
    		for(int j = 0; j < NN; j++){
    			// prints Note Objects of that Player
    			System.out.println(agendaArray.get(i).getPlayer(j));
    		}
    		System.out.println("-------");
    	}
    	
    	return agendaArray;
    	
    	} catch (Exception e){
    		e.printStackTrace();
    		return null;
    	}
    }

	// OUT-OF-CONTEXT FUNCTIONS BEING RESEARCHED
    /**
     * Iterates through all the attributes of a Player Object prints its values
     * to the console.
     * @param plr Player Object
     * @throws IllegalAccessException 
     */
    public void printAttributeValues(Player plr) throws IllegalAccessException{
        
            // Gets the class of the Object
            Class<?> c = plr.getClass();
            // getDeclaredField() returns an array of type Field of the Fields of 
            // a class. That is, public, private, protected, instance and static variables.
            // Only inherited Fields are not returned.
            Field[] attributes = c.getDeclaredFields();
            //Loop through the array of Fields
            for(int j = 0; j < attributes.length; j++){
                // get(Object) returns the value of a Field of the specified Object. The value is wrapped in an Object.
                Object o = attributes[j].get(plr);
                
                // converting the Object to a String.
                String str = o.toString();
                System.out.println(str);
            }
    }
    
    public ArrayList<Object> loopAttributes(Player plr) throws IllegalAccessException{
        ArrayList<Object> attributes = new ArrayList();
        Field[] fields = plr.getClass().getDeclaredFields();
        for(int i = 0; i < fields.length; i++){
               Object o = fields[i].get(plr);
               attributes.add(o);
               
        }
        return attributes;
    }
    
    public void buildString(){
        
        String[] tokens = {"lol", "rofl", "mao"};
        StringBuilder sb = new StringBuilder();
        sb.append("(?i)^" + "(?=.*" + tokens[0] + ")");
            for (int num = 0; num < tokens.length; num++) {
                sb.append("(?=.*" + tokens[num] + ")");
                
        }
        System.out.println(sb);
    }
}
