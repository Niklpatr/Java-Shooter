import cannonUnitTests.CannonAngleTest;
import cannonUnitTests.CannonStateTest;
import cannonUnitTests.CannonMovementTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
   CannonStateTest.class,
   CannonMovementTest.class,
   CannonAngleTest.class
})

public class CannonTestSuite {
} 