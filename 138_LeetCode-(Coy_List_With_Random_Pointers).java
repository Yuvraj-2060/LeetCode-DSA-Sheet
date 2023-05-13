#Approach-1 (Naive Approach)
  
  class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        
        // Step 1: Create a copy of each node and insert it between the original nodes
        Node current = head;
        while (current != null) {
            Node copy = new Node(current.val);
            copy.next = current.next;
            current.next = copy;
            current = copy.next;
        }
        
        // Step 2: Assign random pointers for the copied nodes
        current = head;
        while (current != null) {
            if (current.random != null)
                current.next.random = current.random.next;
            current = current.next.next;
        }
        
        // Step 3: Separate the original and copied nodes
        Node newHead = head.next;
        Node original = head;
        Node copied = newHead;
        
        while (original != null) {
            original.next = original.next.next;
            copied.next = (copied.next != null) ? copied.next.next : null;
            original = original.next;
            copied = copied.next;
        }
        
        return newHead;
    }
}

++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

#Approach-2 (Using HashMap)
  
class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)  
            return null;
        Map<Node,Node> mp = new HashMap<Node,Node>();
        
        Node temp = head;
        //Copy All The Nodes
        while(temp!=null){
            mp.put(temp,new Node(temp.val));
            temp = temp.next;
        }
        temp = head;
        while(temp!=null){
            mp.get(temp).next = mp.get(temp.next);
            mp.get(temp).random = mp.get(temp.random);
            temp = temp.next;
        }
        return mp.get(head);
    }
}
