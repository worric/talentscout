import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;

/**The Agenda class holds an ArrayList of ScoutingSessions.
 *The class is responsible for planning ScoutingSessions or canceling planned ScoutingSessions. 
 *It can also show an overview of all the planned ScoutingSessions.
 *
 * @author Frederik Frode Nygart
 */

public class Agenda extends Observable {
	
	/**ArrayList with ScoutingSessions referred to as sessions.*/
	private ArrayList <ScoutingSession> sessions;
	
	/** A generic ScoutingSession referred to as session.*/
	private ScoutingSession session;
	
	
	/**The Agenda constructor which ties the reference variable sessions to a new ArrayList*/
	public Agenda(){
		sessions = new ArrayList<ScoutingSession>();
	}
	
	
	/**This method plans a new ScoutingSession by add'ing it to the ArrayList sessions. It also gives the new ScoutingSession an unique sessionID.
	 * @param place, date
	 * @return
	 * */
	public ScoutingSession planSession(String place, Date date){
		String sessionID = generateSessionID();
		ScoutingSession session = new ScoutingSession(place, date, sessionID);
		sessions.add(session);
		this.setChanged();
		this.notifyObservers(session);
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

	

}
