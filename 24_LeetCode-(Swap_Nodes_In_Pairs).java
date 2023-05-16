class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head; // No need to swap if there are less than 2 nodes
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        while (head != null && head.next != null) {
            ListNode first = head;
            ListNode second = head.next;
            
            // Swapping values of first and second nodes
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
            
            // Move to the next pair
            prev = head;
            head = head.next.next;
        }
        
        return dummy.next;
    }
}
