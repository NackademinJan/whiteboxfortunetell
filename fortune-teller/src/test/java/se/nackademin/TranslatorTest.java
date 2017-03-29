/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.nackademin;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author testautomatisering
 */
public class TranslatorTest {
    
   /**
     * Test of getNoun method, of class Translator.
     */

    @Test
    public void testGetNoun() {
        System.out.println("getNoun");
        int idx = 0;
        Translator instance = new Translator();
        String expResult = "en lönehöjning";
        String result = instance.getNoun(idx);
        assertEquals(expResult, result);
    }
   /*
    @Test
    public void testGetNounWithNegativInput() {
        System.out.println("getNoun");
        int idx = -1;
        Translator instance = new Translator();
        
        String expResult = "en lönehöjning";
        String result = instance.getNoun(idx);
        assertEquals(expResult, result);
    }
    */

    /**
     * Test of getVerb method, of class Translator.
     */
    @Test
    public void testGetVerb() {
        System.out.println("getVerb");
        int idx = 0;
        Translator instance = new Translator();
        String expResult = "springa";
        String result = instance.getVerb(idx);
        assertEquals(expResult, result);
    }

    /**
     * Test of getAdjective method, of class Translator.
     */
    @Test
    public void testGetAdjective() {
        System.out.println("getAdjective");
        int idx = 0;
        Translator instance = new Translator();
        String expResult = "stor";
        String result = instance.getAdjective(idx);
        assertEquals(expResult, result);
    }
    
}
