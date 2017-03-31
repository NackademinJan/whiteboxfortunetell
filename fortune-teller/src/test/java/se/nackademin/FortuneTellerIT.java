package se.nackademin;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FortuneTellerIT {

    @Test
    public void testGetFortune() {
        FortuneTeller fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());
        fortuneTeller.setAge("18");
        fortuneTeller.setHeight("165");
        fortuneTeller.setIncome("11000");
        fortuneTeller.setLocation("Hagfors");
        fortuneTeller.setName("Sture Hagfors");
        String output = fortuneTeller.calculate();
        assertEquals("Fortune should be calculated correctly", "Din framtid är snabb. Du borde sluta se. Vi ser att du snart kommer att skaffa en hund. Snart kommer du vilja resa, men då är det viktigt att du är hård.", output);
    }
    
    
    @Test
    public void testEmptyName() {
        FortuneTeller fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());
        boolean result = fortuneTeller.setName("");
        assertFalse("should return false for empty name input", result);
    }
    @Test
     public void testNullName() {
        FortuneTeller fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());
        boolean result = fortuneTeller.setName(null);
        assertFalse("should return false for null name input", result);
    }
    
    
    @Test
    public void testTooLargeIncome() {
        FortuneTeller fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());
        boolean result = fortuneTeller.setIncome("1000000001");
        assertFalse("should return false for an excessively large income input", result);
    }
    
    
    @Test
    public void testEmptyLocation() {
        FortuneTeller fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());
        boolean result = fortuneTeller.setLocation("");
        assertFalse("should return false for empty Location input", result);
    }
    @Test
     public void testNullLocation() {
        FortuneTeller fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());
        boolean result = fortuneTeller.setLocation(null);
        assertFalse("should return false for null Location input", result);
    }
    
    
    @Test
    public void testInvalidAge() {
        FortuneTeller fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());
        boolean result = fortuneTeller.setAge("Bingo");
        assertFalse("should return false for invalid name input", result);
    }
    @Test
     public void testInvalidHeight() {
        FortuneTeller fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());
        boolean result = fortuneTeller.setHeight("Lång");
        assertFalse("should return false for invalid height input", result);
    }
     
    
    /*
     *The following tests verify that issue #37 has been resolved
     */
    @Test
    public void testGetFortune37() {
        FortuneTeller fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());
        fortuneTeller.setName("Svante");
        fortuneTeller.setIncome("-10000");
        fortuneTeller.setLocation("Malmö");
        fortuneTeller.setAge("27");
        fortuneTeller.setHeight("0");
        String output = fortuneTeller.calculate();
        assertEquals("Fortune should be calculated correctly", "Din framtid är vacker. Du borde sluta resa. Vi ser att du snart kommer att skaffa en hund. Snart kommer du vilja mäta, men då är det viktigt att du är stor.", output);
    }
    
     /*
     *The following tests verify that issue #38 has been resolved
     */
    @Test
    public void testGetFortune38() {
        FortuneTeller fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());
        fortuneTeller.setName("Svante");
        fortuneTeller.setIncome("-10000");
        fortuneTeller.setLocation("Malmö");
        fortuneTeller.setAge("27");
        fortuneTeller.setHeight("0");
        String output = fortuneTeller.calculate();
        assertEquals("Fortune should be calculated correctly", "Din framtid är vacker. Du borde sluta resa. Vi ser att du snart kommer att skaffa en hund. Snart kommer du vilja mäta, men då är det viktigt att du är stor.", output);
    }
    
     /*
     *The following tests verify that issue #39 has been resolved
     */
    @Test
    public void testGetFortune39() {
        FortuneTeller fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());
        fortuneTeller.setName("Svante");
        fortuneTeller.setIncome("10000");
        fortuneTeller.setLocation("Malmö");
        fortuneTeller.setAge("-27");
        fortuneTeller.setHeight("165");
        String output = fortuneTeller.calculate();
        assertEquals("Fortune should be calculated correctly", "Din framtid är vacker. Du borde sluta resa. Vi ser att du snart kommer att skaffa en lönesänkning. Snart kommer du vilja mäta, men då är det viktigt att du är snabb.", output);
    }
    
     /*
     *The following tests verify that issue #40 has been resolved
     */
    @Test
    public void testGetFortune40() {
        FortuneTeller fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());
        fortuneTeller.setName("Svante");
        fortuneTeller.setIncome("10000");
        fortuneTeller.setLocation("Malmö");
        fortuneTeller.setAge("27");
        fortuneTeller.setHeight("-20");
        String output = fortuneTeller.calculate();
        assertEquals("Fortune should be calculated correctly", "Din framtid är vacker. Du borde sluta resa. Vi ser att du snart kommer att skaffa ett barn. Snart kommer du vilja mäta, men då är det viktigt att du är ljus.", output);
    }
    
     /*
     *The following tests verify that issue #41 has been resolved
     */
    @Test
    public void testGetFortune41() {
        FortuneTeller fortuneTeller = new FortuneTeller(new MagicNumbers(), new Translator());
        fortuneTeller.setName("Svante");
        fortuneTeller.setIncome("0");
        fortuneTeller.setLocation("Malmö");
        fortuneTeller.setAge("27");
        fortuneTeller.setHeight("165");
        String output = fortuneTeller.calculate();
        assertEquals("Fortune should be calculated correctly", "Din framtid är vacker. Du borde sluta äta. Vi ser att du snart kommer att skaffa ett elstängsel. Snart kommer du vilja röra, men då är det viktigt att du är stor.", output);
    }
    
    
    
}
