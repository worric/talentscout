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
    
    Preferences preference = new Preferences();
    
    public function(){
        
    }
    
    
    
    public void encapsulateAttributes(){
        
    }
    
    /**
     * Finds Player objects whose names match with the given user input and adds them
     * to an ArrayList. 
     * @param inputName The name searched upon by the user
     * @param inputClub Club searched upon by the user
     * @param inputAge Age searched on
     * @return An ArrayList of Player objects
     * @throws Exception 
     */
    public ArrayList<Player> search(String inputName, String inputClub, String inputAge)throws Exception{
        // ArrayList of Player objects
        ArrayList<Player> foundPlayers = new ArrayList();
        Player plrRestore;
        boolean checkInputName;
        boolean checkInputClub;
        boolean checkInputAge;
        // Converts the first letter of the input String into a capital letter
        // String inputUP = input.toUpperCase();
        // String inputReady = inputUP.substring(1).toLowerCase();
       
        // Declaring the directory of player objects 
        File[] files = getFiles();
        
        // Loops through the directory of player objects 
        for(int i = 0; i < files.length; i++){

            // Open each player object file
            plrRestore = open(files[i].getName());
            // Convert the int age to a String in order to be able to compare it
            // with user input via the matches() method. 
            String age = Integer.toString(plrRestore.age);
            
            // User input we want to check if it matches with any Player object's attributes
            // Given variables to give a better overview.
                        
            // If the field is empty let the boolean be true. This is so that the
            // user do not need to fill in text in all search fields.
            if(inputName.isEmpty()){
                checkInputName = true;
            } else {
                checkInputName = plrRestore.name.matches(inputName + ".*");
            }
            
            if(inputClub.isEmpty()){
                checkInputClub = true;
            } else {
                checkInputClub = plrRestore.Club.matches(inputClub + ".*");
            }
            
            if(inputAge.isEmpty()){
                checkInputAge = true;
            } else {
                checkInputAge = age.matches(inputAge + ".*");
            }
            
            // If all the inputfields are empty return all players to the table.
                // .isEmpty() returns true if String.length() == 0.
            // That is, if the user did not type anything into the textfield.
            if(inputName.isEmpty() && inputClub.isEmpty() && inputAge.isEmpty()){
                foundPlayers.add(plrRestore);
            
            // Checks if the user inputs match the Player object's attributes.
            // Also due to code above, this returns true if some search fields are left blank
            // and one search field has a value which matches the attribute of a Player object.
            } else if(checkInputName && checkInputClub && checkInputAge){
            
                //if true, add the player object to the ArrayList
                foundPlayers.add(plrRestore);
            } else {
                // if false, that is if there are no matches we display an empty table
                foundPlayers.clear();
            }
        }
        // return the ArrayList with all the players found. 
        return foundPlayers;
    }
    
    public ArrayList<Player> searchForName(String inputName)throws Exception{
        // ArrayList of Player objects
        ArrayList<Player> foundPlayers = new ArrayList();
        Player plrRestore;
        // Declaring the directory of player objects 
        File[] files = getFiles();
        
        // Loops through the directory of player objects 
        for(int i = 0; i < files.length; i++){
            // Open each player object file
            plrRestore = open(files[i].getName());

            if(inputName.isEmpty()){
                foundPlayers.add(plrRestore);
            } else if(plrRestore.name.matches(inputName + ".*")){
                System.out.println(plrRestore.name);
                //if true, add the player object to the ArrayList
                foundPlayers.add(plrRestore);
            } else {
                // if false, that is if there are no matches we display an empty table
                foundPlayers.clear();
            }
        }
        // return the ArrayList with all the players found.
        /*for(int i = 0; i < foundPlayers.size(); i++){
        System.out.println(foundPlayers.get(i).name);
        }*/
        return foundPlayers;
    }
    
     public void InsertSearchResultToTableName(String inputName, DefaultTableModel model) throws Exception{

        // ArrayList of players found from search
        ArrayList<Player> playersFound = searchForName(inputName);
        
            // Loop through the players in the ArrayList
            for(int i = 0; i < playersFound.size(); i++){
                
                Player plrRestore = playersFound.get(i);
                // Convert player age from type int to String
                String age = Integer.toString(plrRestore.age);
                
                // Make a String array of the players' attributes
                String[] data = {plrRestore.name, age, plrRestore.Club};
                
                // Add the array to a row in the table
                model.addRow(data);
            }
    }
    
    
    
    public ArrayList<Player> searchForClub(String inputClub)throws Exception{
        // ArrayList of Player objects
        ArrayList<Player> foundPlayers = new ArrayList();
        Player plrRestore;
        
        // Creating an array of all existing files of Player Objects
        File[] files = getFiles();
        
        // Loops through the array of player objects 
        for(int i = 0; i < files.length; i++){

            // Open each player object file
            plrRestore = open(files[i].getName());
                
    
            // If all the inputfields are empty return all players to the table.
                // .isEmpty() returns true if String.length() == 0.
            // That is, if the user did not type anything into the textfield.
            if(inputClub.isEmpty()){
                foundPlayers.add(plrRestore);
            
            // Checks if the user inputs match the Player object's attributes.
            // Also due to code above, this returns true if some search fields are left blank
            // and one search field has a value which matches the attribute of a Player object.
            } else if(plrRestore.Club.matches(inputClub + ".*")){
            
                //if true, add the player object to the ArrayList
                foundPlayers.add(plrRestore);
            } else {
                // if false, that is if there are no matches we display an empty table
                foundPlayers.clear();
            }
        }
        // return the ArrayList with all the players found. 
        return foundPlayers;
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
    
    public void InsertSearchResultToTableClub(String inputClub, DefaultTableModel model) throws Exception{

        // ArrayList of players found from search
        ArrayList<Player> playersFound = searchForClub(inputClub);
        
            // Loop through the players in the ArrayList
            for(int i = 0; i < playersFound.size(); i++){
                
                Player plrRestore = playersFound.get(i);
                // Convert player age from type int to String
                String age = Integer.toString(plrRestore.age);
                
                // Make a String array of the players' attributes
                String[] data = {plrRestore.name, age, plrRestore.Club};
                
                // Add the array to a row in the table
                model.addRow(data);
            }
    }
   
    /**
     * Inserts Player objects from an ArrayList into a table.
     * @param inputName name searched on
     * @param inputClub club searched on
     * @param inputAge age searched on
     * @param model Table we want to insert Players into 
     * @throws Exception 
     */
    public void InsertSearchResultToTable(String inputName, String inputClub, String inputAge, DefaultTableModel model) throws Exception{

        // ArrayList of players found from search
        ArrayList<Player> playersFound = search(inputName, inputClub, inputAge);
        
            // Loop through the players in the ArrayList
            for(int i = 0; i < playersFound.size(); i++){
                
                Player plrRestore = playersFound.get(i);
                // Convert player age from type int to String
                String age = Integer.toString(plrRestore.age);
                
                // Make a String array of the players' attributes
                String[] data = {plrRestore.name, age, plrRestore.Club};
                
                // Add the array to a row in the table
                model.addRow(data);
            }
    }
    
    /**
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
    /**
     * Creates a Player object with specified attributes
     * @param name name of the player
     * @param age player's age
     * @param club club of the player
     * @return a Player object
     */
    public Player register(String name, int age, String club){
        Player plr = new Player();
        plr.name = name;
        plr.age = age;
        plr.Club = club;
        
        return plr;
    }
    
    /**
     * Writes a Player object to a file
     * @param plr a Player object
     * @throws Exception 
     */
    public void save(Player plr) throws Exception {
        // The to-be file name which is equal to the player name
        String fileName = plr.name;
        // The path of the directory we want to keep our files in
        String path = preference.getPlayerDir().getPath();
        // The path of the file we want to create
        String pathForPlr = path+"/"+fileName;

        // We check if the directory for the file is created
        checkDirectoryExist();
        
        /**
         * Connecting to the file.
         * The argument of the FileOutputStream() is the path name of the 
         * file we want to connect to and can be of type String or File.
         */
        FileOutputStream fo = new FileOutputStream(pathForPlr);
        
        /** Preparing to write to the file. 
         * The ObjecOutputStream allows to write objects.
         * It turns objects into data that can be written to a stream.
         * It cannot connect to files, which is why the FileOutputStream is needed.
         * To use a correct term, you say that the ObjectOutputStream is chained to the
         * FileOutputStream. 
         */
        ObjectOutputStream oo = new ObjectOutputStream(fo);
        
        // Writing the object to the file
        oo.writeObject(plr);
        
        // Closing the stream
        oo.close();

        plr = null;
    }
    
    /**
     * Opens a file of a Player object
     * @param text the name of the file we want to open
     * @return a Player object
     * @throws Exception 
     */
    public Player open(String text) throws Exception{
        // The to-be file name which is equal to the player name
        String fileName = text;
        // The path of the directory we want to keep our files in
        String path = preference.getPlayerDir().getPath();
        // The path of the file we want to create
        String pathForPlr = path+"/"+fileName;
        
        FileInputStream fi = new FileInputStream(pathForPlr);
        
        ObjectInputStream oi = new ObjectInputStream(fi);
        
        Player plrRestore = (Player) oi.readObject();
        
        oi.close();
        
        return plrRestore;
    }
    
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
    
    /**
     * Checks if the directory for player files is created.
     * If it isn't, we create it using mkdir(). 
     */
    public void checkDirectoryExist(){
        // We check if the directory for the file is created
        if(!preference.getPlayerDir().isDirectory()){
            // If it doesn't exist, we create it with mkdir().
            preference.getPlayerDir().mkdir();
            /*
            if(!preference.getPlayerDir().isDirectory()){
            String lol = System.getProperty("user.dir");
            System.out.println(lol);
            }*/
        }
    }
    
    /**
     * Gets an array of all Player object files located in the specified directory
     * @return a File array of Player object
     * @throws Exception 
     */
    public File[] getFiles() throws Exception{
        // We check if the directory for the file is created and create it if it isn't
        checkDirectoryExist();
        // Declaring the directory of the files we want to firstly loop through
        // secondly display if they're text files.
        File folder = new File(preference.getPlayerDir().getPath());
        
        // The listFiles() returns an array with abstract names of files or folders in
        // a directory. Here the directory is specified above.
        // Abstract names represent either files or directories/folders.
        File[] paths = folder.listFiles();
        return paths;

        }
    }
