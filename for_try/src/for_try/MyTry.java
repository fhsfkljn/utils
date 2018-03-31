package for_try;

class Base{
	int num=1;
	public Base(){
		this.print();
		num=2;
	}
	public void print() {
		System.out.println("Base:" + num);
	}
}

class Sub extends Base{
	int num=3;
	public Sub(){
		this.print();
		num=4;
	}
	public void print(){
		System.out.println("Sub:" + num);
	}
}

abstract class Father{
	private static volatile Father father = null;
	public static Father getFahter(){
		return father;
	}
	public abstract void print();
}

class Son extends Father{

	@Override
	public void print() {
		System.out.println("sum");
		
	}
	
}

public class MyTry {
	private int i=0;
	private static Father father = Father.getFahter();
	private void test(String str){
		System.out.println(str.hashCode());
		switch (str) {
		case "hello":
			System.out.println("hello".hashCode());
			System.out.println("hello");
			break;
		case "hi":
			System.out.println("hi");
			break;
		case "fuck":
			System.out.println("fuck");
			break;
		case "bit":
			System.out.println("bit");
			break;

		default:
			break;
		}
		
	}
	
	public static void fc(){
		father.print();
	}
	
	public static void main(String[] args) {
		MyTry.fc();
	}
}
