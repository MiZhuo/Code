package site.mizhuo.code;

/**
 * Design your implementation of the linked list. You can choose to use the singly linked list or the doubly linked list. A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node. If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.
 *
 * Implement these functions in your linked list class:
 *
 * get(index) : Get the value of the index-th node in the linked list. If the index is invalid, return -1.
 * addAtHead(val) : Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
 * addAtTail(val) : Append a node of value val to the last element of the linked list.
 * addAtIndex(index, val) : Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
 * deleteAtIndex(index) : Delete the index-th node in the linked list, if the index is valid.
 * Example:
 *
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
 * linkedList.get(1);            // returns 2
 * linkedList.deleteAtIndex(1);  // now the linked list is 1->3
 * linkedList.get(1);            // returns 3
 * Note:
 *
 * All values will be in the range of [1, 1000].
 * The number of operations will be in the range of [1, 1000].
 * Please do not use the built-in LinkedList library.
 */
public class MyLinkedList {
    private static class Node{
        int val;
        Node next;
        Node(int val,Node next){
            this.next = next;
            this.val = val;
        }
    }
    private Node head;
    private int size;
    /** Initialize your data structure here. */
    public MyLinkedList() {

    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index >= this.size || index < 0){
            return  -1;
        }
        Node temp = head;
        for(int i = 0;i < index;i++){
            temp = temp.next;
        }
        return temp.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node temp = new Node(val,this.head);
        this.head = temp;
        this.size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(this.size == 0){
            head = new Node(val,null);
        }else{
            Node temp = head;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = new Node(val,null);
        }
        this.size ++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > this.size){
            return;
        }
        if(index <= 0){
            addAtHead(val);
        }else{
            Node temp = head;
            for (int i = 0;i < index - 1;i++){
                temp = temp.next;
            }
            Node node = new Node(val,temp.next);
            temp.next = node;
            this.size ++;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index >= this.size || index < 0){
            return;
        }
        if(index == 0){
            head = head.next;
        }else{
            Node temp = head;
            for (int i = 0;i < index - 1;i++){
                temp = temp.next;
            }
            temp.next = temp.next.next;
            this.size --;
        }
    }
}
