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
	 * 二分查找，在一个有序数组中查找对应的值，如果值存在，返回其存在的下标，如果不存在，返回其插入的位置
	 * 
	 * @param nums
	 *            有序数组
	 * @param target
	 *            查询的数
	 * @return 返回查询的数对应的位置
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
	 * 找出单向链表中第一个环的入口节点
	 * 
	 * @param pHead
	 * @return 返回该入口节点的ListNode
	 */
	// public ListNode EntryNodeOfLoop(ListNode pHead) {
	// ListNode fast = pHead;
	// ListNode slow = pHead;
	// while (fast != null && fast.next != null) {
	// fast = fast.next.next;
	// slow = slow.next;
	// // 当快指针 与 慢指针相遇时，说明一定有环
	// if (fast == slow) {
	// fast = pHead;
	// // 再次相遇
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
	 * 给定一个序列（至少含有 1 个数），从该序列中寻找一个连续的子序列，使得子序列的和最大。 例如，给定序列
	 * [-2,1,-3,4,-1,2,1,-5,4]， 连续子序列 [4,-1,2,1] 的和最大，为 6。
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
