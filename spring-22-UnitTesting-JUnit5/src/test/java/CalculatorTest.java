import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @BeforeEach
    void setUpEach(){
        System.out.println("BeforeEach is executed.");
    }

    @AfterEach
    void tearDownEach(){
        System.out.println("AfterEach is executed.");
    }

    @BeforeAll
    static void setUpAll(){
        System.out.println("BeforeAll is executed.");
    }

    @AfterAll
    static void tearDownAll(){
        System.out.println("AfterAll is executed.");
    }

    @Test
    void add() {
        System.out.println("Add Method");
        int actual = Calculator.add(3,2);
        assertEquals(5,actual,"Test failed!");
    }

    @Test
    void add2() {
        System.out.println("Add2 Method");

        assertThrows(IllegalArgumentException.class, () -> Calculator.add2(3,2));
    }

    @Test
    void testCase1(){
        fail("Not implemented");
    }
    @Test
    void testCase2(){
        assertTrue(Calculator.operator.equals("add"));
        assertEquals("add", Calculator.operator);
    }
    @Test
    void testCase3(){
        assertArrayEquals(new int[]{1,2,3}, new int[]{1,2,3});
    }
    @Test
    void testCase4(){
        String nullString = null;
        String notNullString = "Cydeo";

        assertNull(nullString);
        assertNotNull(notNullString);
    }

    @Test
    void testCase5(){
        Calculator c1 = new Calculator();
        Calculator c2 = c1;
        Calculator c3 = new Calculator();

        assertSame(c1, c2);
        assertNotSame(c1, c3);
    }



}