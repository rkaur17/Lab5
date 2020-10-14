class ListNode {

    private int data;
    private ListNode next;

    // Constructor creating a node
    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
    // Getter setter methods
    public int getData() {
        return this.data;
    }
    public void setData(int data) {
        this.data = data;
    }
    public ListNode getNext() {
        return this.next;
    }
    public void setNext(ListNode next) {
        this.next = next;
    }
}


class LinkedList {

    // 'head' points to the first node in list
    ListNode head;

    // Constructor for LinkedList
    LinkedList(ListNode node) {
        this.head = node;
    }

    // Adding a node at the end of the current list
    public void add(ListNode node) {
        ListNode temp = this.head;
        // Traversing list to the last node
        while(temp.getNext() != null) {
            temp = temp.getNext();
        }
        // Adding new node at the last.
        temp.setNext(node);
    }

    // Adding a node at a specified position in current list
    public void add(ListNode node, int pos) {
        // If 'pos' == 0, add in the beginning
        if(pos == 0) {
            node.setNext(this.head);
            this.head = node;
        }
        // Else add specified position
        else {
            ListNode temp = this.head;
            // Traverse list to the appropriate position to add new node
            while(pos > 1) {
                temp = temp.getNext();
                pos--;
            }
            // Adding new node
            node.setNext(temp.getNext());
            temp.setNext(node);
        }
    }

    // Returning node at specified position
    public ListNode get(int pos) {
        ListNode ans = this.head;
        // Traversing list to the specified position
        while(pos != 0) {
            ans = ans.getNext();
            pos--;
        }
        return ans;
    }

    // Removing node from specified position
    public ListNode remove(int pos) {
        ListNode ans = this.head;
        // If 'pos' == 0 remove head.
        if(pos == 0) {
            this.head = this.head.getNext();
        }
        // Else remove node from specified position
        else {
            // Traverse list to the specified position
            while(pos > 1) {
                ans = ans.getNext();
                pos--;
            }
            // Rearranging pointers
            ListNode temp = ans.getNext();
            ans.setNext(temp.getNext());
            ans = temp;
        }
        return ans;
    }

    // Reversing list content
    // reversing links rather than reversing values
    public ListNode reverse(ListNode head) {
        // If there is only one node in list no need to reverse links
        if(head.getNext() == null) {
            return head;
        }
        // Else reverse links using 3 pointers
        // And return new head
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = head.getNext();
        while(next != null) {
            curr.setNext(prev);
            prev = curr;
            curr = next;
            next = curr.getNext();
        }
        curr.setNext(prev);
        return curr;
    }

    // print contents of list
    public void print() {
        ListNode temp = this.head;
        // Traversing the whole list and printing data values.\
        while(temp != null) {
            System.out.print(temp.getData()+" ");
            temp = temp.getNext();
        }
        System.out.println();
    }
}

class Solution1 {
    public static void main(String ...args) {

        // Creating list object.
        LinkedList list = new LinkedList(new ListNode(1));
        // Adding node in list.
        list.add(new ListNode(2));
        list.add(new ListNode(3));
        list.add(new ListNode(5));
        list.add(new ListNode(6));
        list.add(new ListNode(7));
        // Adding node at a specified position
        list.add(new ListNode(4), 3);
        // Printing list contents
        System.out.println("List contents are : ");
        list.print();
        // Reversing list.
        list.head = list.reverse(list.head);
        System.out.println("List contents after reversing list : ");
        list.print();
        // Removing an element from a specified position
        ListNode temp = list.remove(4);
        System.out.println("Removed element is : "+temp.getData());
        System.out.println("List contents after removing an element from list : ");
        list.print();
        // Getting an element from list from a specified position
        temp = list.get(4);
        System.out.println("Element at 4'th position : "+temp.getData());
        // Finally printing list contents.
        System.out.println("List contents are : ");
        list.print();
    }
}


