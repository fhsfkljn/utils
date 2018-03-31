package com.newcode.code;

import java.util.ArrayList;
import java.util.LinkedList;

class TreeNode {
	int val = 0;
	TreeNode left = null;
	TreeNode right = null;

	public TreeNode(int val) {
		this.val = val;
	}
}

public class Solution2 {

	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
		boolean result = false;

		if (root1 != null && root2 != null) {
			// 先找到根节点再进行判断

			if (root1.val == root2.val) {
				result = isTrue(root1, root2);
			}
			if (!result) {
				result = HasSubtree(root1.left, root2);
			}
			if (!result) {
				result = HasSubtree(root1.right, root2);
			}

		}

		return result;
	}

	public boolean isTrue(TreeNode root1, TreeNode root2) {
		if (root2 == null) {
			return true;
		}

		if (root1 == null) {
			return false;
		}

		if (root1.val != root2.val) {
			return false;
		}

		return isTrue(root1.left, root2.left) && isTrue(root1.right, root2.right);
	}

	public ArrayList<Integer> printMatrix(int[][] matrix) {
		 ArrayList<Integer> result = new ArrayList<>();

			if (matrix == null) {
				return result;
			}
			int col = matrix.length;
			int row = matrix[0].length;

			int left = 0, top = 0, right = row - 1, bottom = col - 1;
			while (left <= right && top <= bottom) {
				for(int i=left;i<=right;i++){
					result.add(matrix[top][i]);
				}
				for(int i=top+1;i<=bottom;i++){
					result.add(matrix[i][right]);
				}
				if(top!=bottom){
					for(int i=right-1;i>=left;i--){
						result.add(matrix[bottom][i]);
					}
				}
				if(left!=right){
					for(int i=bottom-1;i>top;i--){
						result.add(matrix[i][left]);
					}
				}
				left++;
				top++;
				right--;
				bottom--;
			}
			
			return result;

	}
	
	public static void main(String[] args) {
		int [][] matrix = {{1},{2},{3},{4},{5}};
		ArrayList<Integer> list = new Solution2().printMatrix(matrix);
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}
}
