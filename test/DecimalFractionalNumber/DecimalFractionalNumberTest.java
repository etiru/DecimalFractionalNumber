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
        assertEquals(new DecimalFractionalNumber("100000000000000000000000000"),
                new DecimalFractionalNumber("99999999999999999999999999").plus(new DecimalFractionalNumber("1")));
        assertEquals(new DecimalFractionalNumber("21531231987444717980411.53657995146456"),
                new DecimalFractionalNumber("21531231531231231556865.21345646546456")
                        .plus(new DecimalFractionalNumber("456213486423546.323123486")));
        assertEquals(new DecimalFractionalNumber("-15"),
                new DecimalFractionalNumber("0").plus(new DecimalFractionalNumber("-15")));

    }

    @Test
    public void minus() {
        DecimalFractionalNumber dfNum = new DecimalFractionalNumber("342.541561");
//        assertEquals(new DecimalFractionalNumber("0"), dfNum.minus(dfNum)); // dfNum * 2
    }

}
