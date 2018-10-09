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

public class SolutionTwo {

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
		ListNode result = new SolutionTwo().addTwoNumbers(l1, l2);
		result.print();
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode headNode = new ListNode(0);
		ListNode p = l1;
		ListNode q = l2;
		ListNode cur = headNode;
		int carry = 0;
		while (p != null || q != null) {
			int x = (p == null) ? 0 : p.val;
			int y = (q == null) ? 0 : q.val;
			int sum = x + y + carry;
			carry = sum / 10;
			cur.next = new ListNode(sum % 10);
			cur = cur.next;
			if (p != null) {
				p = p.next;
			}
			if (q != null) {
				q = q.next;
			}
		}
		if (carry > 0) {
			cur.next = new ListNode(carry);
		}
		return headNode.next;

	}
}