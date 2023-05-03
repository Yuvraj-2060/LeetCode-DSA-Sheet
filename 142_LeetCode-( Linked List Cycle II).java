#Approach-1 
  
Time Complexity: O(N)
Reason: Iterating the entire list once.

Space Complexity: O(N)
Reason: We store all nodes in a hash table.

public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> ht = new HashSet<>();
        
        while(head!=null){
            if(ht.contains(head))
                return head;
            ht.add(head);
            head = head.next;
        }
        return null;
    }
}

#Approach-2 ************************(Hare & Tortoise OR Fast & Slow Pointer Approach)********************************************

Time Complexity: O(N)
Reason: We can take overall iterations and club them to O(N)

Space Complexity: O(1)
Reason: No extra data structure is used.

public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null||head.next == null) return null;        
        ListNode slow=head;
        ListNode fast=head;
        ListNode entry=head;
        
        while(fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow==fast){
                while(slow!=entry){
                    slow = slow.next;
                    entry = entry.next;
                }
                return slow;
            }
        }return null;
    }
}
