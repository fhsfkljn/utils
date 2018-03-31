package for_try;

import java.util.ArrayList;
import java.util.Stack;

public class Homework {
	private static int num = 3;

	public static int f(){
		try {
			return 1;
		} catch (Exception e) {
			return 2;
		}finally {
			return 3;
		}
	}
	
	public static void test(String str){
		switch (str) {
		case "hello":
			System.out.println("hello");
			break;
		case "hi":
			System.out.println("hi");
			break;

		default:
			System.out.println("default");
			break;
		}
	}
	
	public static float test2(){
		return 1;
	}
	
	public static int Homework(){
		return 1;
	}
	
	public static void test3(){
//		System.out.println(0+"2");
//		String [] s = new String[2];
//		System.out.println(s[0]);
		
		String str = "hello";
		int i = 6;
		str = i + str;
		System.out.println(str);
		
	}
	
	public static void test4(){
		Short x = 0;
		short a = 1;
		short b = 2;
		int c = 3;
		System.out.println(a+=c);
		a=(short)(a+c);
		System.out.println(7/0.0);
	}
	
	public static void main(String[] args) {
		//System.out.println(f());
		//test("hi");
		//System.out.println(test2());
		//System.out.println(Homework());
		test3();
//		int num = Homework.num;
//		test4();
	}
}
