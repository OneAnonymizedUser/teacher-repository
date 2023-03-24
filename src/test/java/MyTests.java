import org.javagrader.Forbid;
import org.javagrader.Grade;
import org.javagrader.GradeFeedback;
import org.junit.jupiter.api.Test;

import static org.javagrader.TestResultStatus.FAIL;
import static org.junit.jupiter.api.Assertions.assertEquals;


@Grade
public class MyTests {
    @Test
    @Grade(value = 5, cpuTimeout = 1)
    @Forbid("java.lang.Thread")
    void mytest1() {
        // this works
        assertEquals(1, Adder.increment(0));
    }
    @Test
    @Grade(value = 3)
    @GradeFeedback(message = "You forgot to consider this particular case [...]", on = FAIL)
    void mytest2() {
        // this doesn't
        assertEquals(2, Adder.increment(1));
    }

    //BEGIN STRIP
    @Test
    @Grade
    void hiddenTest() {
        // this test is hidden on the template and student repositories
        assertEquals(0, Adder.increment(-1));
    }
    //END STRIP
}
