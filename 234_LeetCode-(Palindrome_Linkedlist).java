#Approach-1 ***************************** (Naive Approach) ************************

Time Complexity: O(N)
Reason: Iterating through the list to store elements in the array.

Space Complexity: O(N)
Reason: Using an array to store list elements for further computations.

class Solution {
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        
        ListNode temp = head;
        while(temp!=null){
            arr.add(temp.val);
            temp = temp.next;
        }
        for(int i=0;i<arr.size()/2;i++){
            if(arr.get(i)!=arr.get(arr.size()-i-1))
                return false;
        }
        return true;
    }
}

#Approach-2 *******************(optimized)********************************
Time Complexity: O(N/2)+O(N/2)+O(N/2)
Reason: O(N/2) for finding the middle element, reversing the list from the middle element, and traversing again to find palindrome respectively.

Space Complexity: O(1)
Reason: No extra data structures are used.

class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null) return true;
            
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = reverseList(slow.next);
        slow = slow.next;
        ListNode temp = head;
        
        while(slow!=null){
            if(temp.val!=slow.val)
                return false;
            slow = slow.next;
            temp = temp.next;   
        }
        return true;
    }
    static ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode nex = null;
        
        while(head!=null){
            nex = head.next;
            head.next = prev;
            prev = head;
            head = nex;
        }return prev;
    }
}

#Approach -3 ************************* (Recursion) *********************************

class Solution {
    ListNode node;
    
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;   
        if(node == null) node = head;   //node points at front
        
        boolean bool = isPalindrome(head.next); //send head to end
        
        if(head.val == node.val)    //compare the front and end nodes
            node = node.next;
        else
            bool = false;
        
        return bool;
    }
}
