import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {
    @Test
    public void isNotEmptyBinary(){
        ConverterGUI myGui = new ConverterGUI();
        String myStr = myGui.myBinaryStatistic("8");
        Assertions.assertFalse(myStr.isEmpty());
    }

    @Test
    public void isEmptyHex(){
        ConverterGUI myGui = new ConverterGUI();
        String myStr = myGui.myHexStatistic("");
        Assertions.assertFalse(myStr.isEmpty());
    }

    @Test
    public void isRightWithInputHex(){
        ConverterGUI myGui = new ConverterGUI();
        String myStr = myGui.myHexStatistic("dfdvdfbdfgbdfbdfbfd");
        System.out.println(myStr);
    }




}
