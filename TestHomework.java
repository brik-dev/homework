import lesson_f.homework.CheckArray;
import org.junit.Assert;
import org.junit.Test;

public class TestHomework {

    @Test
    public void arrayTailAfterLastFourTest_1(){
        int[] in = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[] out = {1,7};

        Assert.assertArrayEquals(out, CheckArray.arrayTailAfterLastFour(in));
    }

    @Test
    public void arrayTailAfterLastFourTest_2(){
        int[] in = {0, 5, 4, 7, 2, 8};
        int[] out = {7,2,8};

        Assert.assertArrayEquals(out, CheckArray.arrayTailAfterLastFour(in));
    }

    @Test(expected = RuntimeException.class)
    public void arrayTailAfterLastFourTest_3(){
        int[] in = {8, 6, 9};
        CheckArray.arrayTailAfterLastFour(in);
    }

    @Test
    public void TestCheckArrayFor1And4_1(){
        int[] in = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        Assert.assertTrue(CheckArray.checkArrayFor1And4(in));
    }

    @Test
    public void TestCheckArrayFor1And4_2(){
        int[] in = {0, 5, 4, 7, 2, 8};
        Assert.assertTrue(CheckArray.checkArrayFor1And4(in));
    }

    @Test
    public void TestCheckArrayFor1And4_3(){
        int[] in = {8, 6, 9};
        Assert.assertFalse(CheckArray.checkArrayFor1And4(in));
    }
}
