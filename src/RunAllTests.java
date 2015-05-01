import org.junit.runners.Suite;
import org.junit.runner.RunWith;

@RunWith(Suite.class)
@Suite.SuiteClasses({Mile3Testing.class, TestInitializeAndShuffle.class, Testing.class, GameTest.class, CardTest.class, CardFuncTesting.class, CombatTesting.class})
public class RunAllTests {
	public static void main (String args[]) {
        org.junit.runner.JUnitCore.main("RunAllTests");
    }
}