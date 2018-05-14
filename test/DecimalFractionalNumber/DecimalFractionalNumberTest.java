package DecimalFractionalNumber;
import DecimalFractiomalNumber.DecimalFractionalNumber;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
public class DecimalFractionalNumberTest {
    @Test
    public void plus(){
        assertEquals( new DecimalFractionalNumber("30"),
            new DecimalFractionalNumber("15").plus(new DecimalFractionalNumber("15")));
        assertEquals(new DecimalFractionalNumber("30.30"),
                new DecimalFractionalNumber("15.15").plus(new DecimalFractionalNumber("15.15")));
    }
}
