package com.newcode.code;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution6 {
	private int cnt;
	private int[] aux;

	public int InversePairs(int[] array) {
		cnt = 0;
		if (array != null)
			aux = new int[array.length];
		mergeSort(array, 0, array.length - 1);
		return cnt;
	}

	private void mergeSort(int[] array, int low, int high) {
		if (low >= high) {
			return;
		}
		int mid = low + (high - low) / 2;
		mergeSort(array, low, mid);
		mergeSort(array, mid + 1, high);
		merge(array, low, mid, high);
	}
	// TODO Auto-generated method stub

	private void merge(int arr[], int low, int mid, int high) {
		int i = low;
		int j = mid + 1;

		for (int k = low; k < high + 1; k++) {
			aux[k] = arr[k];
		}

		for (int k = low; k < high + 1; k++) {
			if (i > mid)
				arr[k] = aux[j++];
			else if (j > high)
				arr[k] = aux[i++];
			else if (aux[i] > aux[j]) {
				arr[k] = aux[j++];
				cnt += mid + 1 - i;
			} else {
				arr[k] = aux[i++];
			}
			cnt %= 1000000007;
		}
	}

	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		ListNode p1 = pHead1;
		ListNode p2 = pHead2;

		Map<ListNode, Integer> map = new HashMap<>();

		while (p1 != null) {
			map.put(p1, null);
			p1 = p1.next;
		}

		while (p2 != null) {
			if (map.containsKey(p2)) {
				return p2;
			} else {
				p2 = p2.next;
			}
		}

		return null;
	}

	public int GetNumberOfK(int[] array, int k) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (k == array[i]) {
				count++;
				if (i + 1 < array.length && k != array[i + 1]) {
					break;
				}
			}
		}
		return count;
	}
	
	int count = 0;
	
	public int TreeDepth(TreeNode root) {
		if(root==null){
			return 0;
		}
		
        int max = 1;
        
        moreDeeper(root,max);
        return count;
        
    }

	private void moreDeeper(TreeNode root, int max) {
		
		boolean flag = true;
		
		if(root.left != null){
			if(flag){
				max++;
				flag = false;
			}
			moreDeeper(root.left, max);
		}
		
		if(root.right!=null){
			if(flag){
				max++;
				flag = false;
			}
			moreDeeper(root.right, max);
		}
		
		count = Math.max(count, max);
		
	}
	
	public boolean IsBalanced_Solution(TreeNode root){
		if(root == null){
			return true;
		}
		if(Math.abs(getHeight(root.left)-getHeight(root.right))>1){
			return false;
		}
		return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
	}

	private int getHeight(TreeNode root) {
		if(root == null){
			return 0;
		}
		return Math.max(getHeight(root.left), getHeight(root.right))+1;
	}
	
	public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        List<Integer> list = new LinkedList<>();
        for(int i=0;i<array.length;i++){
        	if(list.contains(array[i])){
        		list.remove(Integer.valueOf(array[i]));
        	}else {
				list.add(array[i]);
			}
        }
        num1[0] = list.remove(0);
        num2[0] = list.remove(0);
    }
	
	
	public static void main(String[] args) {
		int[] array = {2,4,3,6,3,2,5,5};
		int[] num1 = new int[1];
		int[] num2 = new int[1];
		new Solution6().FindNumsAppearOnce(array, num1, num2);
		System.out.println(num1[0]+" " + num2[0]);
	}

}
