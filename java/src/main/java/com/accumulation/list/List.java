package com.accumulation.list;

/**
 * @author : liushaogeng
 * create at:  2021/1/22
 * @description:
 */
public class List {
    public static class Node{
        private int val;
        private Node next;

        public Node(int _val){
            val = _val;
            next = null;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node node) {
            this.next = node;
        }
    }
    public Node merge(Node n1, Node n2){
        Node pHead = null;
        if(n1.next == null ){
            return n2;
        }
        if(n2.next == null){
            return n1;
        }
        if(n1.val > n2.val){
            pHead = n2;
            pHead.next = merge(n1, n2.next);
        }else{
            pHead = n1;
            pHead.next = merge(n1.next, n2);
        }
       return pHead;
    }

    // 非递归
    public Node mergeNoRec(Node n1, Node n2){
        Node pHead= new Node(0);

        Node ret = pHead;

        while(n1 != null || n2 != null){
            if(n1 == null){
                pHead.next = n2;
                pHead = pHead.next;
                break;
            }else if(n2 == null){
                pHead.next = n1;
                pHead = pHead.next;
                break;
            }else{
                if(n1.val > n2.val){
                    pHead.next = n2;
                    pHead = pHead.next;
                    n2 = n2.next;
                }else{
                    pHead.next = n1;
                    pHead = pHead.next;
                    n1 = n1.next;
                }
            }
        }
        return ret.next;
    }

    public Node MergeTwoOrderedLists(Node l1, Node l2)
    {
        Node temp=new Node(0);
        Node head=temp;//保留头节点的引用
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val)
            {
                temp.next=l1;
                l1=l1.next;
            }
            else
            {
                temp.next=l2;
                l2=l2.next;
            }
            temp=temp.next;
        }
        if(l1==null)  temp.next=l2;//l1子序列为空，则直接拼届l2
        if(l2==null)  temp.next=l1;
        return head.next;//返回头节点指向的序列
    }
}
