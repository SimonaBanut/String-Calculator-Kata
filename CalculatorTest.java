package StringCalculator;
import org.junit.*;
import static org.junit.Assert.*;
public class CalculatorTest {
    //step1 - empty string, 1 or two numbers
    @Test
    public void emptystring(){
        assertEquals(0,CalculatorS.add(""));
    }
    @Test
    public void onenumb(){
        assertEquals(1,CalculatorS.add("1"));
    }
    @Test
    public void twonumb(){
        assertEquals(3,CalculatorS.add("1,2"));
    }
    //step 2 - more numbers
    @Test
    public void morenumb(){
        assertEquals(6,CalculatorS.add("1,2,3"));
    }
    //step 3 - delimiter new line between numbers
    @Test
    public void numberDelimiternewLine(){
        assertEquals(3,CalculatorS.add("//;\n1;2"));
    }
    //step4 - different delimiters
    @Test
    public void customerdelimiterSum() {
        assertEquals(3, CalculatorS.add("//;\n1;2"));
    }
    //step5 - negative numbers
    @Test
    public void exceptionNegativnumbersinMessage () {
        try {
            CalculatorS.add("-1,-2,3");
            fail("exception expected");
        }catch (RuntimeException ex) {
            assertEquals("Negatives not allowed:[-1, -2]", ex.getMessage());
        }
    }
    //step6 - big numbers >1000
    @Test
    public void numberGreaterSum() {
        assertEquals(3, CalculatorS.add("1001,1002"));
    }
}
