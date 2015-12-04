import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Date;

public class ScoutingSessionTest {

	@Test
	public void testGetLocation() {
		PlayerDB pdb = new PlayerDB();
		Agenda a = new Agenda();
		DateManager dmgr = new DateManager();
		
		Date date = dmgr.fromStringToDate("27-05-2015");
		String location = "Skodsborg";
		ScoutingSession s = a.planSession(location, date);
		int i = s.getSessionID();
		
		assertSame(location, a.getSessionByID(i).getLocation());
	}

}
