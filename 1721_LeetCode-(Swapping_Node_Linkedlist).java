#Approach -1

class Solution {
    static int count(ListNode head){
        ListNode Temp = head;
        int cnt =0;
        
        while(Temp!=null){
            cnt++;
            Temp = Temp.next;
        }
        return cnt;    
    }
    public ListNode swapNodes(ListNode head, int k) {
        int cnt = count(head);
        
        ListNode F = head;
        for(int i=0;i<k-1;i++){
            F = F.next;
        }
        
        ListNode S = head;
        for(int i=0;i<cnt-(k);i++){
            S = S.next;
        }
        
        int temp = F.val;
        F.val = S.val;
        S.val = temp;
        
        return head;
        
    }
}


#Approach - 2
  
  class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode first =head;
        ListNode second = head;
        ListNode fast = head;
        ListNode slow= second;
        
        for(int i=0;i<k-1;i++){
            fast = fast.next;
        }
        first = fast;
        
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        
        second = slow;
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        
        return head;
        
    }
}

*************************** OR **************************************************8
  
  JAVA CODE
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
      ListNode prev = head, curr = head, fn = head;
       for(int i = 0; i < k - 1; i ++) {
         prev = prev.next;
       }
      fn = prev;
      
      while(prev.next != null) {
        prev = prev.next;
        curr = curr.next;
      }
      
      int temp = fn.val;
      fn.val = curr.val;
      curr.val = temp;
      
      return head;
    }
}
