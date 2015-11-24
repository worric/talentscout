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
	
	/**ArrayList with ScoutingSessions referred to as sessions.*/
	private ArrayList <ScoutingSession> sessions;
	 
	/** A generic ScoutingSession referred to as session.*/
	private ScoutingSession session;
	
	
	/**The Agenda constructor which ties the reference variable sessions to a new ArrayList*/
	public Agenda(){
		sessions = new ArrayList<ScoutingSession>();
	}
	
	
	/**Plans a new ScoutingSession by adding it to the ArrayList sessions. It also initiates a new ScoutingSession with an unique sessionID.
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
	
	/**Creates an unique sessionID which is given to an instance of the class ScoutingSession;
	 * @return a String with "Session" + sessions.size()
	 * @see #planSession(String, Date)
	 */
	public String generateSessionID(){
		return "Session" + sessions.size();
	}
	
	
	/**This method cancels an already planned ScoutingSession.
	 * @see #planSession()
	 * @param
	 * */
	public void cancelSession(ScoutingSession session){
		int i = sessions.indexOf(session);
		sessions.remove(i);
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

	

}
