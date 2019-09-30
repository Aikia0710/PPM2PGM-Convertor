import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PPMImageTest {
	private PPMImage PPMtest1, PPMtest2, PPMtest3, PPMtest4, PPMtest5;

	@Before
	public void setUp() throws Exception {
        PPMtest1 = new PPMImage("PPMtest1.ppm");
        PPMtest2 = new PPMImage("PPMtest2.ppm");
        PPMtest3 = new PPMImage("PPMtest3.ppm");
        PPMtest4 = new PPMImage("PPMtest4.ppm");
        PPMtest5 = new PPMImage("PPMtest5.ppm");
	}
	
    @Test
    public void PPMtest1() {

        short[][] expected = {{24, 35, 30, 168},
        					{30, 45, 44, 70},
        					{28, 22, 63, 13},
        					{170, 2, 29, 231}};

        short[][] actual = PPMtest1.makeGrey("PPMtest1.pgm");
        assertArrayEquals(expected, actual);
    }


    @Test
    public void PPMtest1a() {
        PPMtest1.makeGrey("PPMtest1.pgm");
        PGMImage expected = new PGMImage("PPMtest1-expected.pgm") ;
        PGMImage actual =   new PGMImage("PPMtest1.pgm");
        assertTrue(actual.equals(expected));
    }
    
    @Test
    public void PPMtest2() {

        short[][] expected = { {31, 112, 11, 27},
        					{18, 213, 63, 106},
        					{59, 90, 43, 18},
        					{18, 9, 15, 17}};

        short[][] actual = PPMtest2.makeGrey("PPMtest2.pgm");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void PPMtest2a() {
        PPMtest2.makeGrey("PPMtest2.pgm");
        PGMImage expected = new PGMImage("PPMtest2-expected.pgm") ;
        PGMImage actual =   new PGMImage("PPMtest2.pgm");
        assertTrue(actual.equals(expected));
    }
    @Test
    public void PPMtest3() {

        short[][] expected = { {3, 33, 1, 170, 36},
        					{2, 158, 3, 0, 53},
        					{0, 2, 63, 27, 2},
        					{93, 23, 19, 122, 243},
        					{95, 28, 30, 102, 255}};

        short[][] actual = PPMtest3.makeGrey("PPMtest3.pgm");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void PPMtest3a() {
        PPMtest3.makeGrey("PPMtest3.pgm");
        PGMImage expected = new PGMImage("PPMtest3-expected.pgm") ;
        PGMImage actual =   new PGMImage("PPMtest3.pgm");
        assertTrue(actual.equals(expected));
    }
    @Test
    public void PPMtest4() {

        short[][] expected = { {1, 33, 0, 170, 26},
        					{19, 143, 22, 47, 44},
        					{0, 24, 64, 17, 8},
        					{93, 31, 8, 188, 155},
        					{16, 16, 36, 24, 245}};

        short[][] actual = PPMtest4.makeGrey("PPMtest4.pgm");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void PPMtest4a() {
        PPMtest4.makeGrey("PPMtest4.pgm");
        PGMImage expected = new PGMImage("PPMtest4-expected.pgm") ;
        PGMImage actual =   new PGMImage("PPMtest4.pgm");
        assertTrue(actual.equals(expected));
    }
    @Test
    public void PPMtest5() {

        short[][] expected = { {42, 36, 0, 140, 2, 44},
								{81, 143, 66, 70, 44, 17},
								{48, 6, 98, 24, 74, 17},
								{170, 7, 16, 182, 174, 153},
								{107, 75, 24, 74, 169, 149},
								{187, 106, 101, 94, 171, 202}};

        short[][] actual = PPMtest5.makeGrey("PPMtest5.pgm");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void PPMTest5a() {
        PPMtest5.makeGrey("PPMtest5.pgm");
        PGMImage expected = new PGMImage("PPMtest5-expected.pgm") ;
        PGMImage actual =   new PGMImage("PPMtest5.pgm");
        assertTrue(actual.equals(expected));
    }
}
