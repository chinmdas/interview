package com.practice.chin.ds;

public class ArrayToBST {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		ArrayToBST.sortedArrayToBST(arr);

	}

	public static TreeNode sortedArrayToBST(int[] nums) {

		return helper(nums, 0, nums.length - 1);
	}

	private static TreeNode helper(int[] nums, int low, int high) {
		System.out.println("low = "+low+", high = "+high);
		if (low > high) {
			return null;
		}

		int mid = low + (high - low) / 2;
		System.out.println("mid = "+mid);
		System.out.println("nums[mid] = "+nums[mid]);
		System.out.println("-----------------");
		// center val of sorted array as the root of the bst
		TreeNode head = new TreeNode(nums[mid]);

		// left of the mid value should go to the left of this root node to satisfy bst
		head.left = helper(nums, low, mid - 1);
		// right of the mid value should go to the right of this root node to satisfy
		// bst
		head.right = helper(nums, mid + 1, high);
		return head;

	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
