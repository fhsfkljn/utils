package com.chao.sort;



public class Singleton {
	
	//�������ģʽ�ļ���д�����̰߳�ȫ��
	//1.��̬�ڲ���
//	private Singleton(){}
//	
//	private static class T{
//		private static Singleton t = new Singleton();
//	}
//	
//	public static Singleton getInstance(){
//		return T.t;
//	}
	
//	private Singleton(){}
//	
//	private static class T{
//		private static Singleton t = new Singleton();
//	}
//	
//	public  static Singleton getInstance(){
//		return T.t;
//	}
	
	
	//2.˫��У����
//	private static volatile Singleton t = null;
//	
//	private Singleton(){}
//	
//	public static Singleton getInstance() {
//		if(t==null){
//			synchronized (Singleton.class) {
//				t = new Singleton();
//			}
//		}
//		return t;
//	}
	
//	private static volatile Singleton t = null;
//	
//	private Singleton(){}
//	
//	public static Singleton getInstance(){
//		if(t==null){
//			synchronized (Singleton.class) {
//				t = new Singleton();
//			}
//		}
//		return t;
//	}
	
	//3.����ʽ��ʼ��
//	private static Singleton t = new Singleton();
//	
//	private Singleton(){}
//	
//	public static Singleton getInstance(){
//		return t;
//	}
	
//	private static Singleton t = new Singleton();
//	
//	private Singleton(){}
//	
//	public static Singleton getInstance(){
//		return t;
//	}
	
	//4.ֱ��ʹ��synorized�����
//	private static Singleton t = null;
//	
//	private Singleton(){}
//	
//	public synchronized static Singleton getIntance() {
//		if(t==null){
//			t = new Singleton();
//		}
//		return t;
//	}
	
//	private static Singleton t = null;
//	
//	private Singleton(){}
//	
//	public synchronized static Singleton getInstance(){
//		if(t==null){
//			t = new Singleton();
//		}
//		return t;
//	}
}
