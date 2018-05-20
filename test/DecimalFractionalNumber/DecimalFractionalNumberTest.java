package DecimalFractionalNumber;
import DecimalFractiomalNumber.DecimalFractionalNumber;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
public class DecimalFractionalNumberTest {
    @Test
    public void plus(){
        DecimalFractionalNumber a = new DecimalFractionalNumber(555);
        DecimalFractionalNumber b = new DecimalFractionalNumber(1000000000);
        DecimalFractionalNumber dfNum = new DecimalFractionalNumber("-2525.2525");
        assertEquals(new DecimalFractionalNumber("-5050.505"), dfNum.plus(dfNum));
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
        assertEquals(new DecimalFractionalNumber("1000000555"), a.plus(b));
        assertEquals(new DecimalFractionalNumber("0"),
                new DecimalFractionalNumber("15.5").plus(new DecimalFractionalNumber("-15.5")));
        assertEquals(new DecimalFractionalNumber("4986486453446454.54845674687878789797654646545646565"),
                new DecimalFractionalNumber("4931801605578968.0616088792001092211")
                .plus(new DecimalFractionalNumber("54684847867486.48684786767867867687654646545646565")));

    }

    @Test
    public void minus() {
        DecimalFractionalNumber dfNum = new DecimalFractionalNumber("342");
        assertEquals(new DecimalFractionalNumber("0"), dfNum.minus(dfNum));

        assertEquals(new DecimalFractionalNumber("4931801605578968.06160887920010922110345353454353435"),
                new DecimalFractionalNumber("4986486453446454.54845674687878789798")
                        .minus(new DecimalFractionalNumber("54684847867486.48684786767867867687654646545646565")));
        assertEquals(new DecimalFractionalNumber("99999999"), new DecimalFractionalNumber("100000000")
                .minus(new DecimalFractionalNumber("1")));
    }

}
