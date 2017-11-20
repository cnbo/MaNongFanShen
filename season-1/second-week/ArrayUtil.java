
public class ArrayUtil {

	/**
	 * 给定一个整形数组 a,對数组的值进行置换 
	 * 例如：a = [7, 9, 30, 3]，置换后为 [3, 30, 9, 7] 
	 * 如果： a = [7, 9, 30, 3, 4]，置换后为 [4, 3, 30, 9, 7]
	 */
	public static void reversArray(int[] origin) {
		int left = 0;
		int right = origin.length - 1;
		for (; left < right; left++, right--) {
			origin[right] ^= origin[left];
			origin[left] ^= origin[right];
			origin[right] ^= origin[left]; 
		}	
	}
	
	/**
	 * 现在有如下的一个数组；
	 * int oldArr[] = {1, 3, 4, 5, 0, 0, 6, 6, 0, 5, 4, 7, 6, 7, 0, 5} 
	 * 要求将以上数组中为 0 的项去掉，将不为 0 的值存入一个新的数组，
	 * 生成的新数组为：{1, 3, 4, 5, 6, 6, 5, 4, 7, 6, 7, 5}
	 */
	public static int[] removeZero(int[] oldArray) {
		MyLinkedList list = new MyLinkedList();
		for (int num : oldArray) {
			if (num == 0) {
				continue;
			}
			list.addFirst(new Integer(num));
		}
		
		return transferListToArray(list);
	}
	
	/**
	 * 给定两个已经排序号的整形数组， a1 和 a2，创建一个新的数组 a3，
	 * 使得 a3 包含 a1 和 a2 的所有元素 
	 * 例如： a1 = [3, 5, 7, 8] a2 = [4, 5, 6, 7] 则 a3 为 [3, 4, 5, 6, 7, 8]
	 */
	public static int[] merge(int[] array1, int[] array2) {
		MyLinkedList list = new MyLinkedList();
		int len1 = array1.length - 1;
		int len2 = array2.length - 1;
		int index1 = 0;
		int index2 = 0;
		
		while (index1 <= len1 && index2 <= len2) {
			int insertNum = 0;
			if (array1[index1] < array2[index2]) {
				insertNum = array1[index1];
				index1++;
			} else if (array1[index1] == array2[index2]) {
				insertNum = array1[index1];
				index1++;
				index2++;
			} else if (array1[index1] > array2[index2]) {
				insertNum = array2[index2];
				index2++;
			}
			if (list.size() == 0 || (insertNum > (Integer) list.get(0))) {
				list.addFirst(new Integer(insertNum));
			}
		}
		
		while (index1 <= len1) {
			if (array1[index1] > (Integer) list.get(0)) {
				list.addFirst(new Integer(array1[index1]));
			}
			index1++;
		}
		
		while (index2 <= len2) {
			if (array2[index2] > (Integer) list.get(0)) {
				list.addFirst(new Integer(array2[index2]));
			}
			index2++;
		}
		
		
		return transferListToArray(list);
	}
	
	/**
	 * 把一个已经存满数据的数组 oldArray 的容量进行扩展，
	 * 扩展后的数据大小为 oldArray.length 
	 * 注意，老数组的元素在新数组中需要保持 
	 * 例如 oldArray = [2, 3, 5], size = 3, 则返回的数组为 [2, 3, 5, 0, 0, 0]
	 */
	public static int[] grow(int[] oldArray, int size) {
		int[] newArray = new int[oldArray.length + size];
		System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);
		
		return newArray;
	}
	
	/**
	 * 斐波拉契数列为：1, 1, 2, 3, 5, 8, 13, 21... 
	 * 给定一个最大值，返回小于该值得数列
	 * 例如： max = 15, 则返回的数组应该为 [1, 1, 2, 3, 5, 8, 13]
	 *  max = 1, 则返回空数组 []
	 */
	public static int[] fibonacci(int max) {
		if (max == 1) {
			return new int[0];
		}
		
		int num1 = 1;
		int num2 = 1;
		int count = 0;
		MyLinkedList list = new MyLinkedList();
		while (num2 < max) {
			if (count == 0 || count == 1) {
				list.addFirst(new Integer(1));
			} else {
				list.addFirst(new Integer(num2));
			}
			if (++count >= 2) {
				int temp = num1 + num2;
				num1 = num2;
				num2 = temp;
			}
		}
		
		return transferListToArray(list);
	}	
	
	/**
	 * 返回小于给定最大值 max 的所有素数数组 
	 * 例如 max = 23，返回的数组为 [2, 3, 5, 7, 11, 13, 17, 19]
	 */
	public static int[] getPrimes(int max) {
		if (max <= 1) {
			return new int[0];
		}
		
		MyLinkedList list = new MyLinkedList();
		for (int i = 2; i < max; i++) {
			if (isPrimeNumber(i)) {
				list.addFirst(new Integer(i));
			}
		}
		
	     return transferListToArray(list);
	}
	
	/**
	 * 判斷一個數是否是素數
	 * @param num
	 * @return
	 */
	private static boolean isPrimeNumber(int num) {
		int i = (int) Math.sqrt((double)num);
		
		while (i > 1) {
			if (num % i-- == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * 所谓“完数”，是指这个数恰好等于它的因子之和，例如 6 = 1 + 2 + 3  
	 *  给定一个最大值 max,返回一个数组，数组中是小于 max 的所有完数
	 */
	public static int[] getPerfectNumbers(int max) {
		MyLinkedList list = new MyLinkedList();
		for (int i = 2; i < max; i++) {
			if (isPerfectNumber(i)) {
				list.addFirst(new Integer(i));
			}
		}
		
	     return transferListToArray(list);
	}
	
	private static boolean isPerfectNumber(int num) {
		int sum = 1;
		int i = (int) Math.sqrt((double)num);
		while (i > 1) {
			if (num % i == 0) {
				sum += i + (num / i);
			}
			i--;
		}
		
		if (sum != num) {
			return false;
		}
		return true;
	}
	
	/**
	 * 用seperator 把数组 array 给连接起来 
	 * 例如 rray = [3, 8, 9], seperator = "-" 
	 * 则返回值为 "3-8-9"
	 */
	
	public static String join(int[] array, String swperator) {
		StringBuilder sb = new StringBuilder();
		for (int num : array) {
			sb.append(num).append("-");
		}
		sb.deleteCharAt(sb.length() - 1);

		return sb.toString();
	}
	
	private static int[] transferListToArray(MyLinkedList list) {
		if (list.size() == 0) {
			return new int[0];
		}
		
		int[] array = new int[list.size()];
		for (int i = array.length - 1; i >= 0; i--) {
			array[i] = (Integer) list.removeFirst();
		}
		
		return array;
	}
	
}
