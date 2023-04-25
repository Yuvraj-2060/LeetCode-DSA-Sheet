public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        while(headB!=null){
            ListNode temp = headA;
            while(temp!=null){
                if(headB==temp)
                    return headB;
                temp = temp.next;
            }
            headB = headB.next;
        }
        return null;
    }
}
