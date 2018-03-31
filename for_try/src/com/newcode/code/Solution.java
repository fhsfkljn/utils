package com.newcode.code;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Solution {
	public int Fibonacci(int n) {
		// if(n<=1){
		// return n;
		// }else{
		// return Fibonacci(n-1)+Fibonacci(n-2);
		// }

		// if (n <= 1) {
		// return n;
		// }
		//
		// int[] record = new int[n + 1];
		// record[0] = 0;
		// record[1] = 1;
		// for(int i=2;i<=n;i++){
		// record[i] = record[i-1]+record[i-2];
		// }
		// return record[n];

//		if (n <= 1) {
//			return n;
//		}
//
//		int a = 0;
//		int b = 1;
//		int re = 0;
//		for (int i = 2; i <= n; i++) {
//			re = a+b;
//			a = b;
//			b = re;
//		}
//		return re;
		
//		if(n == 0){
//			return 0;
//		}
//		
//		if(n==1||n==2){
//			return n;
//		}
//		
//		int first = 2;
//		int record = 0;
//		for(int i = 3;i<=n;i++){
//			record = first*2;
//			first = record;
//		}
//		return record;
		
		if(n==0){
            return 0;
         }else if(n==1||n==2){
            return n;
        }else{
             return 2*Fibonacci(n-1);
         }
	}
	
	public double power(double base, int exponent) {
//        if(exponent==0){
//            return 1;
//        }else if(exponent==1){
//            return base;
//        }else{
//            return base*power(base,exponent-1);
//        }
		
//		if(exponent==0){
//			return 1;
//		}
//		
//		if(exponent>0){
//			if(exponent==1){
//				return base;
//			}
//			
//			double record = base;
//			
//			for(int i=2;i<=exponent;i++){
//				base = base * record;
//			}
//			return base;
//		}else {
//			if(exponent==-1){
//				return 1/base;
//			}
//			
//			base = 1/base;
//			double record = base;
//			
//			for(int i=-2;i>=exponent;i--){
//				base = base * record;
//			}
//			
//			return base;
//		}
		
		return Math.pow(base, exponent);
        
  }
	
	public void reOrderArray(int [] array) {
//		LinkedList<Integer> odd = new LinkedList<>();
//		LinkedList<Integer> even = new LinkedList<>();
//		
//		for(int i=0;i<array.length;i++){
//			if(array[i]%2!=0){
//				odd.add(array[i]);
//			}else {
//				even.add(array[i]);
//			}
//		}
//		
//		int count = 0;
//		
//		while(!odd.isEmpty()){
//			array[count] = odd.removeFirst();
//			count++;
//		}
//		
//		while(!even.isEmpty()){
//			array[count] = even.removeFirst();
//			count++;
//		}
//		
//		for (int num : array) {
//			System.out.print(num+" ");
//		}
		
		for(int i=0;i<array.length;i++){
			for(int j = array.length-1;j>i;j--){
				if(array[j]%2==1&&array[j-1]%2==0){
					int temp = array[j];
					array[j] = array[j-1];
					array[j-1] = temp;
				}
			}
		}
		for (int num : array) {
			System.out.print(num+" ");
		}
	        
	}
	
	public ListNode FindKthToTail(ListNode head,int k) {
//        int length = 1;
//        ListNode p = head;
//        while(p.next!=null){
//            p = p.next;
//            length++;
//        }
//        int node = length - k + 1;
//        
//        for(int i = 1;i<node;i++){
//            head = head.next;
//        }
//        
//        return head;
		
		ListNode pre=null,q=null;
		pre = q = head;
		
		int a =k;
		int count = 0;
		
		while(q!= null){
			q = q.next;
			count++;
			if(k<1){
				pre = pre.next;
			}
			k--;
		}
		
		if(count < a){
			return null;
		}
		
		return pre;
    }
	
	public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode newListNode = null;
        
        if(list1==null){
        	return list2;
        }
        
        if (list2==null) {
			return list1;
		}
        
        if(list1.val>list2.val){
        	newListNode = list2;
        	list2 = list2.next;
        }else {
        	newListNode = list1;
        	list1 = list1.next;
		}
        
        while(list1!=null&&list2!=null){
        	if(list1.val > list2.val){
        		newListNode.next = list2;
        		list2 = list2.next;
        	}else {
        		newListNode.next = list1;
        		list1 = list1.next;
			}
        }
        

        	while(list2!=null && list1==null){
        		newListNode.next = list2;
        		list2 = list2.next;
        	}

        

        	while(list2==null && list1!=null){
        		newListNode.next = list1;
        		list1 = list1.next;
        	}
        	
        	return newListNode;

    }
	
	public static void main(String[] args) {
		//System.out.println(new Solution().Fibonacci(7));
		//System.out.println(new Solution().power(2,-3));
		int [] array = {1,2,3,4,5,6,7,8,9};
		new Solution().reOrderArray(array);
	}
}
