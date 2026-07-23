class BrowserHistory {
    class Node {
        String url;
        Node next;
        Node prev;
        Node(String url) {
            this.url = url;
        }
        Node(String url, Node next, Node prev) {
            this.url = url;
            this.next = next;
            this.prev = prev;
        }
    }
    Node curr;

    public BrowserHistory(String homepage) {
        curr = new Node(homepage);
    }
    
    public void visit(String url) {
        Node newNode = new Node(url);
        curr.next = newNode;
        newNode.prev = curr;
        curr = curr.next;
    }
    
    public String back(int steps) {
        while(steps>0) {
            if(curr.prev != null) {
                curr = curr.prev;
                steps--;
            }else {
                break;
            }
        }
        return curr.url;
    }
    
    public String forward(int steps) {
        while(steps > 0) {
            if(curr.next != null) {
                curr = curr.next;
                steps--;
            }else {
                break;
            }
        }
        return curr.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */