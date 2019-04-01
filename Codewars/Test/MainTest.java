import com.codewars.Main;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertArrayEquals;

public class MainTest {
    @Test
    public void testSolution() {
        assertEquals(23, new Main().solution(10));
    }

    @Test
    public void testFindEvenIndex() {
        assertEquals(3,Main.findEvenIndex(new int[] {1,2,3,4,3,2,1}));
        assertEquals(1,Main.findEvenIndex(new int[] {1,100,50,-51,1,1}));
        assertEquals(-1,Main.findEvenIndex(new int[] {1,2,3,4,5,6}));
        assertEquals(3,Main.findEvenIndex(new int[] {20,10,30,10,10,15,35}));
        assertEquals(-1,Main.findEvenIndex(new int[] {-8505, -5130, 1926, -9026}));
        assertEquals(1,Main.findEvenIndex(new int[] {2824, 1774, -1490, -9084, -9696, 23094}));
        assertEquals(6,Main.findEvenIndex(new int[] {4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4}));
    }

    @Test
    public void validPins() {
        assertEquals(true, Main.validatePin("1234"));
        assertEquals(true, Main.validatePin("0000"));
        assertEquals(true, Main.validatePin("1111"));
        assertEquals(true, Main.validatePin("123456"));
        assertEquals(true, Main.validatePin("098765"));
        assertEquals(true, Main.validatePin("000000"));
        assertEquals(true, Main.validatePin("090909"));
    }

    @Test
    public void nonDigitCharacters() {
        assertEquals(false, Main.validatePin("a234"));
        assertEquals(false, Main.validatePin(".234"));
    }

    @Test
    public void invalidLengths() {
        assertEquals(false, Main.validatePin("1"));
        assertEquals(false, Main.validatePin("12"));
        assertEquals(false, Main.validatePin("123"));
        assertEquals(false, Main.validatePin("12345"));
        assertEquals(false, Main.validatePin("1234567"));
        assertEquals(false, Main.validatePin("-1234"));
        assertEquals(false, Main.validatePin("1.234"));
        assertEquals(false, Main.validatePin("00000000"));
    }

    private double precision = 0.0000000000001;

    @Test
    public void sampleTestCases() {
        assertEquals(1.0, Main.findUniq(new double[]{0, 1, 0}), precision);
        assertEquals(2.0, Main.findUniq(new double[]{1, 1, 1, 2, 1, 1}), precision);
    }

    @Test
    public void test1() {
        assertEquals(3, Main.bouncingBall(3.0, 0.66, 1.5));
    }
    @Test
    public void test2() {
        assertEquals(15, Main.bouncingBall(30.0, 0.66, 1.5));
    }

    private static void testing(boolean actual, boolean expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        System.out.println("Fixed Tests scramble");
        testing(Main.scramble("rkqodlw","world"), true);
        testing(Main.scramble("cedewaraaossoqqyt","codewars"),true);
        testing(Main.scramble("katas","steak"),false);
        testing(Main.scramble("scriptjavx","javascript"),false);
        testing(Main.scramble("scriptingjava","javascript"),true);
        testing(Main.scramble("scriptsjava","javascripts"),true);
        testing(Main.scramble("javscripts","javascript"),false);
        testing(Main.scramble("aabbcamaomsccdd","commas"),true);
        testing(Main.scramble("commas","commas"),true);
        testing(Main.scramble("sammoc","commas"),true);
    }

    @Test
    public void testNormalCondition() {
        assertEquals(9, Main.solveSuperMarketQueue(new int[] { 2, 2, 3, 3, 4, 4 }, 2));
    }

    @Test
    public void testEmptyArray() {
        assertEquals(0, Main.solveSuperMarketQueue(new int[] {}, 1));
    }

    @Test
    public void testSingleTillManyCustomers() {
        assertEquals(15, Main.solveSuperMarketQueue(new int[] { 1, 2, 3, 4, 5 }, 1));
    }

    @Test
    public void testBigN() {
        assertEquals(5, Main.solveSuperMarketQueue(new int[] { 1, 2, 3, 4, 5}, 100));
    }

    @Test
    public void testRandomValues() {
        assertEquals(10, Main.solveSuperMarketQueue(new int[] { 5, 7, 3, 3, 5, 7, 4}, 5));

    }

    @Test
    public void walkingTest() {
        assertEquals("Should return true", true, Main.isValid(new char[] {'n','s','n','s','n','s','n','s','n','s'}));
        assertEquals("Should return false", false, Main.isValid(new char[] {'w','e','w','e','w','e','w','e','w','e','w','e'}));
        assertEquals("Should return false", false, Main.isValid(new char[] {'w'}));
        assertEquals("Should return false", false, Main.isValid(new char[] {'n','n','n','s','n','s','n','s','n','s'}));
    }

    @Test
    public void orderTest1() {
        assertThat(Main.order("is2 Thi1s T4est 3a"), equalTo("Thi1s is2 3a T4est"));
    }

    @Test
    public void orderTest2() {
        assertThat(Main.order("4of Fo1r pe6ople g3ood th5e the2"), equalTo("Fo1r the2 g3ood 4of th5e pe6ople"));
    }

    @Test
    public void orderTest3() {
        assertThat("Empty input should return empty string", Main.order(""), equalTo(""));
    }

    @Test
    public void testSimpleDirReduc() {
        assertArrayEquals("\"NORTH\", \"SOUTH\", \"SOUTH\", \"EAST\", \"WEST\", \"NORTH\", \"WEST\"",
                new String[]{"WEST"},
                Main.dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}));
        assertArrayEquals("\"NORTH\",\"SOUTH\",\"SOUTH\",\"EAST\",\"WEST\",\"NORTH\"",
                new String[]{},
                Main.dirReduc(new String[]{"NORTH","SOUTH","SOUTH","EAST","WEST","NORTH"}));
    }

    @Test
    public void BasicTests1() {
        System.out.println("****** Basic Tests small numbers******");
        List<Integer> ts = new ArrayList<>(Arrays.asList(50, 55, 56, 57, 58));
        int n = Main.chooseBestSum(163, 3, ts);
        assertEquals(163, n);
        ts = new ArrayList<>(Arrays.asList(50));
        Integer m = Main.chooseBestSum(163, 3, ts);
        assertEquals(null, m);
        ts = new ArrayList<>(Arrays.asList(91, 74, 73, 85, 73, 81, 87));
        n = Main.chooseBestSum(230, 3, ts);
        assertEquals(228, n);
    }








}