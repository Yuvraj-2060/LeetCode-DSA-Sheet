class Solution { 
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
    ListNode first = head;
    ListNode second = head;
        
        for(int i=1;i<=n;i++)
            second = second.next;
        
        if(second==null)
            return head.next;
        
        while(second.next!=null){
            second = second.next;
            first = first.next;
        }
        first.next = first.next.next;
        return head;
    }
}
