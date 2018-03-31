package com.newcode.code;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Solution3 {
	
	Stack<Integer> stack = new Stack<>();
	
	public void push(int node) {
        stack.push(node);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int min() {
    	int min = stack.peek();
        int tmp = 0;
        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext()){
            tmp = iterator.next();
            if (min>tmp){
                min = tmp;
            }
        }
        return min;
    }
    
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length==0||popA.length==0){
        	return false;
        }
       
        int popIndex = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0;i<pushA.length;i++){
        	stack.push(pushA[i]);
        	while(!stack.isEmpty() && stack.peek()==popA[popIndex]){
        		stack.pop();
        		popIndex++;
        	}
        }
        
        return stack.isEmpty();
    }
    
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root==null){
        	return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
        	TreeNode node = queue.poll();
        	list.add(node.val);
        	if(node.left!=null){
        		queue.add(node.left);
        	}
        	if(node.right!=null){
        		queue.add(node.right);
        	}
        }
        return list;
    }
    
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0){
        	return false;
        }
        if(sequence.length==1){
        	return true;
        }
        
        return judge(sequence,0,sequence.length-1);
    }
    
    private boolean judge(int[] sequence, int start, int end) {
		if(start >= end){
			return true;
		}
		
		int i = end;
		while(i>start && sequence[i-1]>sequence[end]){
			i--;
		}
		for(int j=i-1;j>=start;j--){
			if(sequence[j]>sequence[end]){
				return false;
			}
		}
		return judge(sequence, start, i-1) && judge(sequence, i, end-1);
		
	}
    
    public boolean VerifySquenceOfBST2(int [] sequence){
    	int length = sequence.length;
    	
    	if(length==0){
    		return false;
    	}
    	if(length==1){
    		return true;
    	}
    	
    	int i = 0;
    	while(--length!=0){
    		while(sequence[length]>sequence[i]){
    			i++;
    		}
    		while(sequence[length]<sequence[i]){
    			i++;
    		}
    		if(i<length){
    			return false;
    		}
    		i = 0;
    	}
    	return true;
    }

	public static void main(String[] args) {
//		Solution3 s = new Solution3();
//		s.push(3);
//		System.out.println(s.min());
//		s.push(4);
//		System.out.println(s.min());
//		s.push(2);
//		System.out.println(s.min());
//		s.push(3);
//		System.out.println(s.min());
//		s.pop();
//		System.out.println(s.min());
//		s.pop();
//		System.out.println(s.min());
//		s.pop();
//		System.out.println(s.min());
//		s.push(0);;
//		System.out.println(s.min());
		
		Solution3 s = new Solution3();
		int[] a = {2,9,5,16,17,15,19,18,12};
		System.out.println(s.VerifySquenceOfBST(a));
		
	}
}
