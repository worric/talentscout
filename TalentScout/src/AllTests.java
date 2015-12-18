import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AgendaTest.class, DateManagerTest.class, NoteTest.class, PlayerDBTest.class, PlayerTest.class,
		ScoutingSessionTest.class, SearchTest.class })
public class AllTests {

}
