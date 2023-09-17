import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    public void myFirstTest(){
        Raumschiff myRaum = new Raumschiff("haha", 10, 10, "");
        int myNum = myRaum.addNum(1,2);
        Assertions.assertEquals(1, myNum);
    }
}