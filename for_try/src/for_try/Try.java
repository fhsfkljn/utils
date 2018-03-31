package for_try;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Try {
	public static int getMinPath(int[][] arr) {
		if (arr == null && arr.length == 0) {
			return 0;
		}

		int row = arr.length;
		int col = arr[0].length;

		int[][] temp = new int[row][col];
		temp[0][0] = arr[0][0];

		for (int j = 1; j < col; j++) {
			temp[0][j] = temp[0][j - 1] + arr[0][j];
		}

		for (int i = 1; i < row; i++) {
			temp[i][0] = temp[i - 1][0] + arr[i][0];
		}

		System.out.print("[0,0]" + '\t');

		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (arr[i][j - 1] > arr[i - 1][j]) {
					temp[i][j] = temp[i - 1][j] + arr[i][j];
					System.out.print("[" + (i - 1) + "," + j + "]" + '\t');
				} else {
					temp[i][j] = temp[i][j - 1] + arr[i][j];
					System.out.print("[" + i + "," + (j - 1) + "]" + '\t');
				}

			}
		}

		System.out.println("[" + (row - 1) + "," + (col - 1) + "]" + '\t');
		return temp[row - 1][col - 1];

	}

	public static int[] getMinTime(int[] arr, int n) {
		if (arr == null || arr.length == 0) {
			return null;
		}

		int[] temp = new int[arr.length];

		for (int i = 0; i < n; i++) {
			int min = 0;
			for (int j = 1; j < arr.length; j++) {
				if (temp[j - 1] * arr[j - 1] + arr[j - 1] > temp[j] * arr[j] + arr[j]) {
					min = j;
				}
			}

			temp[min]++;
		}
		return temp;
	}

	public static int hammingDistance(int x, int y) {
		char[] arr1 = Integer.toBinaryString(x).toCharArray();
		char[] arr2 = Integer.toBinaryString(y).toCharArray();
		int count = 0;

		for (int i = 0; i < arr1.length; i++) {
			if ((Integer.valueOf((arr1[i])) ^ Integer.valueOf((arr2[i]))) == 1) {
				count++;
			}
		}
		return count;
	}

	public boolean judgeCircle(String moves) {
		int i = 0;
		int j = 0;
		char[] arr = moves.toCharArray();
		for (int k = 0; k < arr.length; k++) {
			if (arr[k] == 'U')
				i++;
			else if (arr[k] == 'D')
				i--;
			else if (arr[k] == 'L')
				j++;
			else if (arr[k] == 'R')
				j--;
		}
		return i == 0 && j == 0;
	}

	public int arrayPairSum(int[] nums) {
		int count = 0;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i += 2) {
			count += nums[i];
		}
		return count;
	}

	public static int findComplement(int num) {
		List<String> list = new ArrayList<>();
		System.out.println(~num);
		System.out.println(Integer.toBinaryString(num));
		System.out.println(Integer.toBinaryString(~num));
		System.out.println((Integer.highestOneBit(num) << 1) - 1);
		return ~num & ((Integer.highestOneBit(num) << 1) - 1);
	}

	public String reverseWords(String s) {
		String[] split = s.split(" ");
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < split.length; i++) {
			str.append(new StringBuffer(split[i]).reverse().toString()).append(" ");
		}
		return str.toString().trim();
	}

	public static List<String> fizzBuzz(int n) {
		List<String> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (i % 3 == 0) {
				list.add("Fizz");
			} else if (i % 5 == 0) {
				list.add("Buzz");
			} else if (i % 3 == 0 && i % 5 == 0) {
				list.add("FizzBuzz");
			} else {
				list.add(i + "");
			}
		}
		return list;
	}

	public static void main(String[] args) {
		// int[] arr = {7,10};
		// int n = 6;
		// int sumTime = 0;
		// int[] time = getMinTime(arr, n);
		// for (int i=1;i<time.length;i++) {
		// System.out.println(time[i-1]);
		// sumTime = Math.max(time[i-1]*arr[i-1], time[i]*arr[i]);
		// }
		// System.out.println(time[arr.length-1]);
		// System.out.println(sumTime);

		// String str1 = new String("hello");
		// String str2 = "hello";
		// String str3 = "he" + "llo";
		//
		// System.out.println(str1.equals(str2));
		// System.out.println(str2.equals(str3));
		// System.out.println(str1.equals(str3));
		//
		// Object object = new Object();
		// System.out.println(object.hashCode());
		// object.equals("hello");

		// System.out.println(hammingDistance(1, 4));
//		int num = findComplement(5);
//		System.out.println(num);
		List<String> list = fizzBuzz(15);
		for (String string : list) {
			System.out.print(string + " ");
		}
	}
}
