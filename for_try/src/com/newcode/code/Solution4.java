package com.newcode.code;

import java.util.ArrayList;
import java.util.Stack;

public class Solution4 {
	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
		return root;
	}

	private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
		if (startPre > endPre || startIn > endIn) {
			return null;
		}

		TreeNode root = new TreeNode(pre[startPre]);
		for (int i = startIn; i <= endIn; i++) {
			if (pre[startPre] == in[i]) {
				root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
				root.right = reConstructBinaryTree(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
				return root;
			}
		}
		return root;
	}

	public ListNode FindKthToTail(ListNode head, int k) {
		ListNode pre = null, p = null;
		pre = p = head;

		int a = k;
		int count = 0;

		while (p != null) {
			p = p.next;
			count++;
			if (k < 1) {
				pre = pre.next;
			}
			k--;
		}

		if (a > count) {
			return null;
		}
		return pre;
	}

	public ListNode ReverseList(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode pre = null, next = null;
		while(head!=null){
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}
	
	public ListNode Merge(ListNode list1,ListNode list2){
		if(list1==null){
			return list2;
		}
		if(list2==null){
			return list1;
		}
		
		if(list1.val<list2.val){
			list1.next = Merge(list1.next, list2);
			return list1;
		}else{
			list2.next = Merge(list1, list2.next);
			return list2;
		}
	}
	

}
