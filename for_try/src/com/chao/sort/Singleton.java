package com.chao.sort;



public class Singleton {
	
	//单例设计模式的几种写法（线程安全）
	//1.静态内部类
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
	
	
	//2.双重校验锁
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
	
	//3.饿汉式初始化
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
	
	//4.直接使用synorized代码块
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
