package pl.droidsonroids.romannumeralsconverter.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RomanNumeralConverterTest {

    private RomanNumeralConverter romanNumeralConverter;
    
    @Before
    public void setUp() throws Exception {
        romanNumeralConverter = new RomanNumeralConverter();
    }

    @Test(expected = IllegalStateException.class)
    public void testZero() throws Exception {
        //noinspection ResultOfMethodCallIgnored
        romanNumeralConverter.convert(0);
    }

    @Test(expected = IllegalStateException.class)
    public void testNegative() throws Exception {
        //noinspection ResultOfMethodCallIgnored
        romanNumeralConverter.convert(-1);
    }

    @Test
    public void testOne() throws Exception {
        assertEquals("I", romanNumeralConverter.convert(1));
    }

    @Test
    public void testTwo() throws Exception {
        assertEquals("II", romanNumeralConverter.convert(2));
    }

    @Test
    public void testThree() throws Exception {
        assertEquals("III", romanNumeralConverter.convert(3));
    }

    @Test
    public void testFour() throws Exception {
        assertEquals("IV", romanNumeralConverter.convert(4));
    }

    @Test
    public void testFive() throws Exception {
        assertEquals("V", romanNumeralConverter.convert(5));
    }

    @Test
    public void testSix() throws Exception {
        assertEquals("VI", romanNumeralConverter.convert(6));
    }

    @Test
    public void testEleven() throws Exception {
        assertEquals("XI", romanNumeralConverter.convert(11));
    }

    @Test
    public void testFourteen() throws Exception {
        assertEquals("XIV", romanNumeralConverter.convert(14));
    }

    @Test
    public void test256() throws Exception {
        assertEquals("CCLVI", romanNumeralConverter.convert(256));
    }

    @Test
    public void test1999() throws Exception {
        assertEquals("MCMXCIX", romanNumeralConverter.convert(1999));
    }
}