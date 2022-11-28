class Node{
    Node next,bottom;
    int data;
    public Node(int d){
        data = d;
        next = null;
        bottom = null;
    }
}
class GfG
{
    
    Node merge(Node a, Node b){
        Node head;
        Node ptr;
        if(a.data < b.data){
            head = a;
            a = a.bottom;
        }else{
            head = b;
            b = b.bottom;
        }
        ptr = head;
        while(a != null && b != null){
            if(a.data < b.data){
                ptr.bottom = a;
                a = a.bottom;
            }else{
                ptr.bottom = b;
                b = b.bottom;
            }
            ptr = ptr.bottom;
        }
        if(a != null){
            ptr.bottom = a;
        }
        if(b != null){
            ptr.bottom = b;
        }
        return head;
    }
    
    Node flatten(Node root)
    {
	    if(root.next == null)
	        return root;
        
        return merge(root, flatten(root.next));
    }
}