class MyLinkedList {
    class Node {
        int val;
        Node next;
        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
        Node (int val) {
            this.val = val;
        }
    }
    public MyLinkedList() {
        
    }
    Node head;
    public int get(int index) {
        int idx = 0;
        Node temp = head;
        while(temp != null) {
            if(idx == index) return temp.val;
            idx++;
            temp = temp.next;
        }
        return -1;
    }
    
    public void addAtHead(int val) {
        if(head == null) {
            head =  new Node(val);
             return;
        }
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }
    
    public void addAtTail(int val) {
        if(head == null) {
            head = new Node(val);
            return;
        }
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        Node newNode = new Node(val);
        temp.next = newNode;
    }
    
    public void addAtIndex(int index, int val) {
        int cnt = 0;
        if(index == 0) {
            addAtHead(val);
            return;
        }
        Node temp = head;
        while(temp != null && cnt < index - 1) {
    temp = temp.next;
    cnt++;
}
        if(temp == null) return;
        Node newNode = new Node(val);
        newNode.next = temp.next;
        temp.next = newNode;
    }
    
    public void deleteAtIndex(int index) {
        if(head == null) return;
        if(index == 0) {
            head = head.next;
            return;
        }
        int cnt = 0;
        Node temp = head;
       while(temp != null && cnt < index - 1) {
    temp = temp.next;
    cnt++;
}
        if (temp == null || temp.next == null)
    return;
        temp.next = temp.next.next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */