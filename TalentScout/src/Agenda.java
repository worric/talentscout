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
	 
	/** A generic ScoutingSession referred to as "session".*/
	private ScoutingSession session;
	
	
	/**Creates an agenda which ties the reference variable "sessions" to a new ArrayList*/
	public Agenda(){
		sessions = new ArrayList<ScoutingSession>();
	}
	
	
	/**
	 * Plans a ScoutingSession by creating a new ScoutingSession and thereafter adding it to the ArrayList "sessions". It also initiates a new ScoutingSession with an unique sessionID.
	 * @param location is the location of where a planned ScoutingSession takes place.
	 * @param date is the date of when a ScoutingSession takes place.
	 * @return ScoutingSession(location, date)
	 * */
	public ScoutingSession planSession(String location, Date date){
		String sessionID = generateSessionID();
		ScoutingSession session = new ScoutingSession(location, date, sessionID);
		sessions.add(session);
		return session;
	}
	
	/**
	 * Creates an unique sessionID which is given to an instance of the class ScoutingSession;
	 * @return a String with "Session" + sessions.size()
	 * @see #planSession(String, Date)
	 */
	public String generateSessionID(){
		return "Session" + sessions.size();
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
	public ScoutingSession getSession(int index){
		if(index > sessions.size()){
			return null;		
		}else{
			return sessions.get(index);	
		}

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

	

}
