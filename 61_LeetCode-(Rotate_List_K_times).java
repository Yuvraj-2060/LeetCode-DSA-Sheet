#Approach-1 
  
Time Complexity: O(Number of nodes present in the list*k)
Reason: For k times, we are iterating through the entire list to get the last element and move it to first.

Space Complexity: O(1)
Reason: No extra data structures are used for computations
  
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        
        if (head == null || head.next == null) return head;
        for (int i = 0; i < k; i++) {
          ListNode temp = head;
          while (temp.next.next != null) temp = temp.next;
          ListNode end = temp.next;
          temp.next = null;
          end.next = head;
          head = end;
        }
        return head;
    }
}


#Approach-2 
  
Time Complexity: O(length of list) + O(length of list – (length of list%k))
Reason: O(length of the list) for calculating the length of the list. O(length of the list – (length of list%k)) for breaking link.

Space Complexity: O(1)
Reason: No extra data structure is used for computation.
  
  class Solution {
    public ListNode rotateRight(ListNode head, int k) {
    if(head == null||head.next == null||k == 0) return head;
    
    ListNode temp = head;
    int length = 1;
    while(temp.next != null) {
        ++length;
        temp = temp.next;
    }
        
    //link last node to first node
    temp.next = head;
    k = k%length; //when k is more than length of list
    int end = length-k; //to get end of the list
    while(end--!=0) 
        temp = temp.next;
    //breaking last node link and pointing to NULL
    head = temp.next;
    temp.next = null;
        
    return head;
    }
}
