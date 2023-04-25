public class Solution {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> ht = new HashSet<>();
        
        while(head!=null){
            if(ht.contains(head))
                return true;
            ht.add(head);
            head = head.next;
        }
        return false;
    }
}
