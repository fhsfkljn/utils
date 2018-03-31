package com.chao.function;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class Function {
	/**
	 * ���ֲ��ң���һ�����������в��Ҷ�Ӧ��ֵ�����ֵ���ڣ���������ڵ��±꣬��������ڣ�����������λ��
	 * 
	 * @param nums
	 *            ��������
	 * @param target
	 *            ��ѯ����
	 * @return ���ز�ѯ������Ӧ��λ��
	 */
	// public static int searchInsert(int[] nums, int target) {
	// int low = 0,high = nums.length-1;
	// while(low<=high){
	// int mid = low + (high-low)/2;
	// if(target==nums[mid]) return mid;
	// else if(target<nums[mid]) high = mid-1;
	// else low = mid+1;
	// }
	// return low;
	// }

	public static int searchInsert(int[] nums, int target) {
		int low = 0,high = nums.length-1;
		while(low<=high){
			int mid = low+(high-low)/2;
			if(nums[mid]==target) return mid;
			else if(target<nums[mid]) high = mid-1;
			else low = mid+1;
		}
		return low;
	}

	/**
	 * �ҳ����������е�һ��������ڽڵ�
	 * 
	 * @param pHead
	 * @return ���ظ���ڽڵ��ListNode
	 */
	// public ListNode EntryNodeOfLoop(ListNode pHead) {
	// ListNode fast = pHead;
	// ListNode slow = pHead;
	// while (fast != null && fast.next != null) {
	// fast = fast.next.next;
	// slow = slow.next;
	// // ����ָ�� �� ��ָ������ʱ��˵��һ���л�
	// if (fast == slow) {
	// fast = pHead;
	// // �ٴ�����
	// while (fast != slow) {
	// fast = fast.next;
	// slow = slow.next;
	// }
	// return fast;
	// }
	// }
	// return null;
	// }

	public ListNode EntryNodeOfLoop(ListNode pHead) {
		ListNode fast = pHead;
		ListNode slow = pHead;
		while(fast!=null && fast.next!=null){
			fast = fast.next.next;
			slow = slow.next;
			if(fast==slow){
				fast=pHead;
				while(fast!=slow){
					fast = fast.next;
					slow = slow.next;
				}
				return fast;
			}
		}
		return null;
	}

	/**
	 * ����һ�����У����ٺ��� 1 ���������Ӹ�������Ѱ��һ�������������У�ʹ�������еĺ���� ���磬��������
	 * [-2,1,-3,4,-1,2,1,-5,4]�� ���������� [4,-1,2,1] �ĺ����Ϊ 6��
	 * 
	 * @param args
	 */
//	public static int maxSubArray(int[] nums) {
//		int maxSoFar = nums[0], maxEndingHere = nums[0];
//		for (int i = 1; i < nums.length; ++i) {
//			maxEndingHere = Math.max(maxEndingHere + nums[i],nums[i]);
//			maxSoFar = Math.max(maxSoFar, maxEndingHere);
//		}
//		return maxSoFar;
//	}
	
	public static int maxSubArray(int[] nums){
		int max = nums[0],temp = nums[0];
		for(int i=1;i<nums.length;i++){
			temp = Math.max(temp+nums[i], nums[i]);
			max = Math.max(temp, max);
		}
		return max;
	}
	

	public static void main(String[] args) {
		//searchInsert
//		int[] arr = { 1, 2, 4, 5, 6, 8, 9, 10, 12, 14, 17 };
//		System.out.println(searchInsert(arr, 1));
		
		//maxSubArray
		int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(arr));
	}
}
