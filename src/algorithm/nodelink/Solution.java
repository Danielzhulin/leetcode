/**
 * Project: LeetCode
 * File: Solution.java
 */
package algorithm.nodelink;

/**
 * @author Daniel Zhu
 *         You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
 *         order and each of their nodes contain a single digit.
 *         Add the two numbers and return it as a linked list.
 *         You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *         Example:
 *         Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *         Output: 7 -> 0 -> 8
 *         Explanation: 342 + 465 = 807.
 */

public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		ListNode result = new Solution().addTwoNumbers(l1, l2);
		result.print();
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode pre = null;
		ListNode p1 = l1;
		ListNode p2 = l2;
		int plus = 0;
		while (p1 != null && p2 != null) {
			int tmp = p1.val + p2.val + plus;
			plus = tmp / 10;
			p1.val = tmp % 10;
			pre = p1;
			p1 = p1.next;
			p2 = p2.next;
		}
		if (p1 == null && p2 != null) {
			pre.next = p2;
			while (plus > 0 && p2 != null) {
				int tmp = p2.val + plus;
				p2.val = tmp % 10;
				plus = tmp / 10;
				pre = p2;
				p2 = p2.next;
			}
			if (plus > 0) {
				pre.next = new ListNode(plus);
			}
		} else if (p2 == null && p1 != null) {
			while (plus > 0 && p1 != null) {
				int tmp = p1.val + plus;
				p1.val = tmp % 10;
				plus = tmp / 10;
				pre = p1;
				p1 = p1.next;
			}
			if (plus > 0) {
				pre.next = new ListNode(plus);
			}
		} else if (plus > 0) {
			pre.next = new ListNode(plus);
		}
		return l1;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	public void print() {
		ListNode next = null;
		next = this.next;
		System.out.println(val);
		while (next != null) {
			System.out.println(next.val);
			next = next.next;
		}
	}
}
