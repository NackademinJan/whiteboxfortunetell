package se.nackademin;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class FortuneTellerTest {

    @Test
    public void testCalculate() {
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        when(magicNumbersMock.calculateA()).thenReturn(1);
        when(magicNumbersMock.calculateB()).thenReturn(1);
        when(magicNumbersMock.calculateC()).thenReturn(1);
        when(magicNumbersMock.calculateD()).thenReturn(1);
        when(magicNumbersMock.calculateE()).thenReturn(1);

        Translator translatorMock = mock(Translator.class);
        when(translatorMock.getAdjective(anyInt())).thenReturn("liten");
        when(translatorMock.getVerb(anyInt())).thenReturn("springa");
        when(translatorMock.getNoun(anyInt())).thenReturn("en lönehöjning");
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        assertEquals("Din framtid är liten. Du borde sluta springa. Vi ser att du snart kommer att skaffa en lönehöjning. Snart kommer du vilja springa, men då är det viktigt att du är liten.", fortuneTeller.calculate());
    }
    
    
    @Test
    public void testSetNameWithValidInput() {
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        boolean result = fortuneTeller.setName("Björn Borg");
        assertTrue("should return true for valid input", result);
        verify(magicNumbersMock, times(1)).setName("Björn Borg");
    }

    @Test
    public void testSetNameWithNullInput() {
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        boolean result = fortuneTeller.setName(null);
        assertFalse("should return false for null input", result);
    }

    @Test
    public void testSetNameWithEmptyStringInput() {
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        boolean result = fortuneTeller.setName("");
        assertFalse("should return false for empty input", result);
    }
    
        
    @Test
    public void testSetIncome() {
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        boolean result = fortuneTeller.setIncome("25000");
        assertTrue("should return true for valid input", result);
        verify(magicNumbersMock, times(1)).setIncome(25000);
    }

    @Test
    public void testSetIncomeWithInvalidInput() {
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        boolean result = fortuneTeller.setIncome("not an integer");
        assertFalse("should return false for invalid input", result);
    }
    
    @Test
    public void testSetIncomeWithVeryLargeInput() {
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        boolean result = fortuneTeller.setIncome("10000001");
        assertFalse("should return false for invalid input", result);
    }
    /*
        @Test
    public void testSetAIncomeWithNegativeInput() {
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        boolean result = fortuneTeller.setIncome("-1");
        assertFalse("should return false for invalid input", result);
    }
    */
    
    @Test
    public void testSetLocationWithValidInput() {
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        boolean result = fortuneTeller.setLocation("Karlskrona");
        assertTrue("should return true for valid input", result);
        verify(magicNumbersMock, times(1)).setLocation("Karlskrona");
    }

    @Test
    public void testSetLocationWithNullInput() {
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        boolean result = fortuneTeller.setLocation(null);
        assertFalse("should return false for null input", result);
    }

    @Test
    public void testSetLocationWithEmptyStringInput() {
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        boolean result = fortuneTeller.setLocation("");
        assertFalse("should return false for empty input", result);
    }
    
    
    @Test
    public void testSetAge() {
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        boolean result = fortuneTeller.setAge("25");
        assertTrue("should return true for valid input", result);
        verify(magicNumbersMock, times(1)).setAge(25);
    }

    @Test
    public void testSetAgeWithInvalidInput() {
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        boolean result = fortuneTeller.setAge("not an integer");
        assertFalse("should return false for invalid input", result);
    }
    /*
    @Test
    public void testSetAgeWithVeryOldInput() {
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        boolean result = fortuneTeller.setAge("131");
        assertFalse("should return false for invalid input", result);
    }
    
        @Test
    public void testSetAgeWithNegativeInput() {
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        boolean result = fortuneTeller.setAge("-1");
        assertFalse("should return false for invalid input", result);
    }
    */
    
        
    @Test
    public void testSetHeight() {
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        boolean result = fortuneTeller.setHeight("180");
        assertTrue("should return true for valid input", result);
        verify(magicNumbersMock, times(1)).setHeight(180);
    }

    @Test
    public void testSetHeightWithInvalidInput() {
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        boolean result = fortuneTeller.setHeight("not an integer");
        assertFalse("should return false for invalid input", result);
    }
    /*
    @Test
    public void testSetHeightWithNegativeInput() {
        MagicNumbers magicNumbersMock = mock(MagicNumbers.class);
        Translator translatorMock = mock(Translator.class);
        FortuneTeller fortuneTeller = new FortuneTeller(magicNumbersMock, translatorMock);
        boolean result = fortuneTeller.setHeight("-1");
        assertFalse("should return false for invalid input", result);
    }
    */
}
