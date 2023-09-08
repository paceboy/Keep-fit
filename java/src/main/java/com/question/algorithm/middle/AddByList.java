package com.question.algorithm.middle;

/**
 * @author liushaogeng
 * @date 2022/10/7 12:51
 * @description
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *  
 *
 * 提示：
 *
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AddByList {
    public ListNode addTwoNumber(ListNode l1, ListNode l2){
        ListNode ret = new ListNode();
        ListNode listNode = ret;
        int carry = 0;
        while(l1 != null || l2 != null){
            if (l1 !=null && l2 != null) {
                listNode.val = (l1.val + l2.val + carry) % 10;
                carry = (l1.val + l2.val + carry) / 10;
            }else if(l1 !=null){
                listNode.val = (l1.val + carry) % 10;
                carry = (l1.val + carry) / 10;
            }else {
                listNode.val = (l2.val  + carry) % 10;
                carry = (l2.val + carry) / 10;
            }

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;

            if (carry != 0 || l1 != null || l2 != null) {
                ListNode next = new ListNode(carry);
                listNode.next = next;
                listNode = listNode.next;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        AddByList addByList = new AddByList();
        ListNode l1 = new ListNode(2);
        ListNode ln2 = new ListNode(4);
        ListNode ln3 = new ListNode(3);
        l1.next = ln2;
        ln2.next = ln3;

        ListNode l2 = new ListNode(5);
        ln2 = new ListNode(6);
        ln3 = new ListNode(4);

        l2.next = ln2;
//        ln2.next = ln3;

        ListNode l3 = addByList.addTwoNumber(l1, l2);
        while(l3!= null){
            System.out.print(l3.val);
            l3 = l3.next;
        }
    }
}
