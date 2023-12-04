import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

public class CalculatorParameterizedTest {

    @ParameterizedTest
    @ValueSource(strings = {"Java","JS","TS"})
    void testCase1(String arg){
        Assertions.assertFalse(arg.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {3,6,9})
    void testCase1(int num){
        Assertions.assertEquals(0, num % 3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Java","JS","TS"})
//    @EmptySource
//    @NullSource
    @NullAndEmptySource
    void testCase3(String arg){
        Assertions.assertFalse(arg.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("stringProvider")
    void testCase4(String arg){
        Assertions.assertFalse(arg.isEmpty());
    }

    static String[] stringProvider(){
        return new String[]{"String", "JS", "TS"};
    }

    @ParameterizedTest
    @CsvSource({
            "10, 20, 30",
            "20, 20, 40",
            "30, 20, 100"
    })
    void testCase5(int num1, int num2, int result){
        Assertions.assertEquals(result, Calculator.add(num1, num2));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sampleData.csv", numLinesToSkip = 1)
    void testCase6(int num1, int num2, int result){
        Assertions.assertEquals(result, Calculator.add(num1, num2));
    }

}
