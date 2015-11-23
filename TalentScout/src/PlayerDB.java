import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class PlayerDB implements Observer {
	
	private ArrayList<Player> playerDB;
	private Observable agenda;
	
	public PlayerDB(Observable o){
		playerDB = new ArrayList<Player>();
		this.agenda = o;
		agenda.addObserver(this);
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
