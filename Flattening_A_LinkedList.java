class GfG
{
    Node flatten(Node root)
    {
	    if(root==null || root.next==null)
	        return root;
	        
	   root.next = flatten(root.next);
	   root = mergeList(root,root.next);
	   
	   return root;
    }
    static Node mergeList(Node a,Node b){
        Node temp = new Node(0);
        Node res = temp;
        
        while(a!=null && b!=null){
            if(a.data<b.data){
                temp.bottom = a;
                temp = temp.bottom;
                a = a.bottom;
            }
            else{
                temp.bottom = b;
                temp = temp.bottom;
                b = b.bottom;
            }
        }
        if(a!=null){
            temp.bottom = a;
        }
        if(b!=null){
            temp.bottom = b;
        }
        return res.bottom;
    }
}
