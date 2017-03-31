package se.nackademin;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class MagicNumberTest {
    MagicNumbers magicNumbers;

    @Before
    public void setUp() {
        magicNumbers = new MagicNumbers();
        magicNumbers.setAge(16);
        magicNumbers.setHeight(165);
        magicNumbers.setIncome(11000);
        magicNumbers.setLocation("Hagfors");
        magicNumbers.setName("Sture Hagfors");
    }

    @Test
    public void testA() {
        assertEquals("A is not calculated correctly", 4, magicNumbers.calculateA());
    }

    @Test
    public void testB() {
        assertEquals("B is not calculated correctly", 3, magicNumbers.calculateB());
    }

    @Test
    public void testC() {
        assertEquals("C is not calculated correctly", 2, magicNumbers.calculateC());
    }

    @Test
    public void testD() {
        assertEquals("D is not calculated correctly", 6, magicNumbers.calculateD());
    }

    @Test
    public void testDWithAGreaterThan5() {
        magicNumbers.setAge(18);
        assertEquals("D is not calculated correctly", 9, magicNumbers.calculateD());
    }

    @Test
    public void testE() {
        assertEquals("E is not calculated correctly", 9, magicNumbers.calculateE());
    }

    @Test
    public void testADependsOnName() {
        int first = magicNumbers.calculateA();
        magicNumbers.setName("Sture i Hagfors");
        int second = magicNumbers.calculateA();
        assertNotEquals("A should provide different values for different names", first, second);
    }

    @Test
    public void testADependsOnAge() {
        int first = magicNumbers.calculateA();
        magicNumbers.setAge(18);
        int second = magicNumbers.calculateA();
        assertNotEquals("A should provide different values for different ages", first, second);
    }

    @Test
    public void testBDependsOnLocation() {
        int first = magicNumbers.calculateB();
        magicNumbers.setLocation("Grytevik");
        int second = magicNumbers.calculateB();
        assertNotEquals("B should provide different values for different locations", first, second);
    }

    @Test
    public void testBDependsOnIncome() {
        int first = magicNumbers.calculateB();
        magicNumbers.setIncome(219487);
        int second = magicNumbers.calculateB();
        assertNotEquals("B should provide different values for different income values", first, second);
    }

    @Test
    public void testCDependsOnHeight() {
        int first = magicNumbers.calculateC();
        magicNumbers.setHeight(126);
        int second = magicNumbers.calculateC();
        assertNotEquals("C should provide different values for different heights", first, second);
    }

    @Test
    public void testCDependsOnAge() {
        int first = magicNumbers.calculateC();
        magicNumbers.setAge(126);
        int second = magicNumbers.calculateC();
        assertNotEquals("C should provide different values for different ages", first, second);
    }

    @Test
    public void testCDependsOnName() {
        int first = magicNumbers.calculateC();
        magicNumbers.setName("Sture i Hagfors");
        int second = magicNumbers.calculateC();
        assertNotEquals("C should provide different values for different names", first, second);
    }
    
    
    /*
     *
     * test tries to break calculateA by causing that method to return a result that is not a result between 0-9, the current version produces a result of 10
     * 
     */
    
    @Test
    public void testCalculateAIsBreakable() {
        magicNumbers.setName("Johan");
        magicNumbers.setAge(9);
        int resultNr = magicNumbers.calculateA();
        boolean result = !(resultNr < 0) && !(resultNr >9);
        assertTrue("calculateA should always produce a result between 0-9", result);    
    }
    
    /*
     * test tries to break calculateA by providing minimal positive input values (that arent empty strings or null values)
     */
    
    @Test
    public void testCalculateAMinimalInput() {
        magicNumbers.setName("J");
        magicNumbers.setAge(0);
        int resultNr = magicNumbers.calculateA();
        boolean result = !(resultNr < 0) && !(resultNr >9);
        assertTrue("calculateA should always produce a result between 0-9", result);    
    }
    
    /*
     * test tries to break calculateA by providing negative input values (where possible)
     */
    
    @Test
    public void testCalculateANegativeInput() {
        magicNumbers.setName("J");
        magicNumbers.setAge(-1);
        int resultNr = magicNumbers.calculateA();
        boolean result = !(resultNr < 0) && !(resultNr >9);
        assertTrue("calculateA should always produce a result between 0-9", result);    
    }
    
    /*
     * test tries to break calculateA by providing large positive input values (that do not violate constraints of the datatype or established rules like max 10 000 000 for income)
     */
    
    @Test
    public void testCalculateALargerInputs() {
        magicNumbers.setName("a b c d e f g h i j k l m n o p q r s t u v x y z");
        magicNumbers.setAge(10000001);
        int resultNr = magicNumbers.calculateA();
        boolean result = !(resultNr < 0) && !(resultNr >9);
        assertTrue("calculateA should always produce a result between 0-9", result);    
    }
    
    
   /*
    * test tries to break calculateB by providing minimal positive input values (that arent empty strings or null values)
    */
    @Test
    public void testCalculateBMinimalInput() {
        magicNumbers.setLocation("x");
        magicNumbers.setIncome(0);
        int resultNr = magicNumbers.calculateB();
        boolean result = !(resultNr < 0) && !(resultNr >9);
        assertTrue("calculateA should always produce a result between 0-9", result);    
    }
    
    /*
     * test tries to break calculateB by providing negative input values (where possible)
     */
    
    @Test
    public void testCalculateBNegativeInput() {
        magicNumbers.setLocation("x");
        magicNumbers.setIncome(-1);
        int resultNr = magicNumbers.calculateB();
        boolean result = !(resultNr < 0) && !(resultNr >9);
        assertTrue("calculateA should always produce a result between 0-9", result);    
    }
    
    /*
     * test tries to break calculateB by providing large positive input values (that do not violate constraints of the datatype or established rules like max 10 000 000 for income)
     */
    
    @Test
    public void testCalculateBLargerInputs() {
        magicNumbers.setLocation("a b c d e f g h i j k l m n o p q r s t u v x y z");
        magicNumbers.setIncome(10000000);
        int resultNr = magicNumbers.calculateB();
        boolean result = !(resultNr < 0) && !(resultNr >9);
        assertTrue("calculateA should always produce a result between 0-9", result);    
    }
    
   /*
    * test tries to break calculateC by providing minimal positive input values (that arent empty strings or null values)
    */
    @Test
    public void testCalculateCMinimalInput() {
        magicNumbers.setLocation("x");
        magicNumbers.setIncome(0);
        magicNumbers.setHeight(0);
        int resultNr = magicNumbers.calculateC();
        boolean result = !(resultNr < 0) && !(resultNr >9);
        assertTrue("calculateA should always produce a result between 0-9", result);    
    }
    
    /*
     * test tries to break calculateC by providing negative input values (where possible)
     */
    
    @Test
    public void testCalculateCNegativeInput() {
        magicNumbers.setLocation("x");
        magicNumbers.setIncome(-1);
        magicNumbers.setHeight(-1);
        int resultNr = magicNumbers.calculateC();
        boolean result = !(resultNr < 0) && !(resultNr >9);
        assertTrue("calculateA should always produce a result between 0-9", result);    
    }
    
    /*
     * test tries to break calculateC by providing large positive input values (that do not violate constraints of the datatype or established rules like max 10 000 000 for income)
     */
    
    @Test
    public void testCalculateCLargerInputs() {
        magicNumbers.setLocation("a b c d e f g h i j k l m n o p q r s t u v x y z");
        magicNumbers.setIncome(10000000);
        magicNumbers.setHeight(10000001);
        int resultNr = magicNumbers.calculateC();
        boolean result = !(resultNr < 0) && !(resultNr >9);
        assertTrue("calculateA should always produce a result between 0-9", result);    
    }
    
    
   /*
    * test tries to break calculateD by providing minimal positive input values (that arent empty strings or null values)
    */
    @Test
    public void testCalculateDMinimalInput() {
        magicNumbers.setLocation("x");
        magicNumbers.setIncome(0);
        magicNumbers.setHeight(0);
        int resultNr = magicNumbers.calculateD();
        boolean result = !(resultNr < 0) && !(resultNr >9);
        assertTrue("calculateA should always produce a result between 0-9", result);    
    }
    
    /*
     * test tries to break calculateD by providing negative input values (where possible)
     */
    
    @Test
    public void testCalculateDNegativeInput() {
        magicNumbers.setLocation("x");
        magicNumbers.setIncome(-1);
        magicNumbers.setHeight(-1);
        int resultNr = magicNumbers.calculateD();
        boolean result = !(resultNr < 0) && !(resultNr >9);
        assertTrue("calculateA should always produce a result between 0-9", result);    
    }
    
    /*
     * test tries to break calculateD by providing large positive input values (that do not violate constraints of the datatype or established rules like max 10 000 000 for income)
     */
    
    @Test
    public void testCalculateDLargerInputs() {
        magicNumbers.setLocation("a b c d e f g h i j k l m n o p q r s t u v x y z");
        magicNumbers.setIncome(10000000);
        magicNumbers.setHeight(10000001);
        int resultNr = magicNumbers.calculateD();
        boolean result = !(resultNr < 0) && !(resultNr >9);
        assertTrue("calculateA should always produce a result between 0-9", result);    
    }
    
    
   /*
    * test tries to break calculateE by providing minimal positive input values (that arent empty strings or null values)
    */
    @Test
    public void testCalculateEMinimalInput() {
        magicNumbers.setAge(0);
        magicNumbers.setIncome(0);
        magicNumbers.setHeight(0);
        int resultNr = magicNumbers.calculateE();
        boolean result = !(resultNr < 0) && !(resultNr >9);
        assertTrue("calculateA should always produce a result between 0-9", result);    
    }
    
    /*
     * test tries to break calculateE by providing negative input values (where possible)
     */
    
    @Test
    public void testCalculateENegativeInput() {
        magicNumbers.setAge(-1);
        magicNumbers.setIncome(-1);
        magicNumbers.setHeight(-1);
        int resultNr = magicNumbers.calculateE();
        boolean result = !(resultNr < 0) && !(resultNr >9);
        assertTrue("calculateA should always produce a result between 0-9", result);    
    }
    
    /*
     * test tries to break calculateE by providing large positive input values (that do not violate constraints of the datatype or established rules like max 10 000 000 for income)
     */
    
    @Test
    public void testCalculateELargerInputs() {
        magicNumbers.setAge(10000001);
        magicNumbers.setIncome(10000000);
        magicNumbers.setHeight(10000001);
        int resultNr = magicNumbers.calculateE();
        boolean result = !(resultNr < 0) && !(resultNr >9);
        assertTrue("calculateA should always produce a result between 0-9", result);    
    }
    
    
}
