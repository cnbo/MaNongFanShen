import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class ArrayUtilTest {

	@Test
	public void testReversArray() {
//		int[] nums = {7, 9, 30, 3, 4};
//		int[] testNums = {4, 3, 30, 9, 7};
		int[] nums = {7, 9, 30, 3};
		int[] testNums = {3, 30, 9, 7};
		ArrayUtil.reversArray(nums);
		
		Assert.assertArrayEquals(nums, testNums);
	}

	@Test
	public void testRemoveZero() {
		int[] oldArray = {1, 3, 4, 5, 0, 0, 6, 6, 0, 5, 4, 7, 6, 7, 0, 5};
		int[] testArray = {1, 3, 4, 5, 6, 6, 5, 4, 7, 6, 7, 5};
		int[] newArray = ArrayUtil.removeZero(oldArray);
		
		Assert.assertArrayEquals(testArray, newArray);
	}

	@Test
	public void testMerge() {
		int[] array1 = {3, 5, 7, 8};
		int[] array2 = {4, 5, 6, 7};
		int[] testArray = {3, 4, 5, 6, 7, 8};
		
		int[] mergeArray = ArrayUtil.merge(array1, array2);
		
		Assert.assertArrayEquals(testArray, mergeArray);
	}

	@Test
	public void testGrow() {
		int[] oldArray = {2, 3, 5};
		int[] testArray = {2, 3, 5, 0, 0, 0};
		
		int[] newArray = ArrayUtil.grow(oldArray, oldArray.length);
		
		Assert.assertArrayEquals(testArray, newArray);
	}

	@Test
	public void testFibonacci() {
		int max = 15;
		int[] testArray = {1, 1, 2, 3, 5, 8, 13};
		
		int[] resultArray = ArrayUtil.fibonacci(max);
		
		Assert.assertArrayEquals(testArray, resultArray);
	}

	@Test
	public void testGetPrimes() {
		int max = 23;
		int[] testArray = {2, 3, 5, 7, 11, 13, 17, 19};
		
		int[] resultArray = ArrayUtil.getPrimes(max);
		
		Assert.assertArrayEquals(testArray, resultArray);
	}

	@Test
	public void testGetPerfectNumbers() {
		int max = 1000;
		int[] testArray = {6, 28, 496};
		
		int[] resultArray = ArrayUtil.getPerfectNumbers(max);
		
		Assert.assertArrayEquals(testArray, resultArray);
	}

	@Test
	public void testJoin() {
		int[] originArray = {1, 2, 3, 4, 5, 6, 7};
		String testStr = "1-2-3-4-5-6-7";
		
		String resultStr = ArrayUtil.join(originArray, "-");
		
		Assert.assertEquals(testStr, resultStr);
	}

}
