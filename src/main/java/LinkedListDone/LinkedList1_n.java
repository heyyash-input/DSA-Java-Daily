package LinkedListDone;

public class LinkedList1_n {
    public static void main(String[] args) {
    LinkedList1_n ll =  new LinkedList1_n();

    ll.addLast(1);
    ll.addLast(2);
    ll.addLast(5);
//    ll.addLast(1);
//    ll.add(2 , 3);
    ll.print(); /* 1->2->3->4->5->null */
//        System.out.println(ll.size);
//        ll.removeFirst();
//        ll.print();
//        ll.removeLast();
//        ll.print();
//        System.out.println(iterativeSearch(3));
//        System.out.println(iterativeSearch(10));
//        System.out.println(recursiveSearch(3));
//        System.out.println(recursiveSearch(10));
//        ll.reverseLinkedList();
        System.out.println(ll.isPlaindrome());
        ll.print();

    }

   public static class Node{
        int data ;
        Node next ;

        Node(int data){
            this.data = data ;
            this.next= null;
        }
    }

    public static Node head ;
    public static Node tail ;
    public static int size; /// by default java size =0 ;

//--------------------------------------------------------------------------------------------------------------

//  Add to the first to the  LL
    public void addFirst(int data){
//        1) Create new node:-
        Node newNode = new Node(data) ;
        size++ ;
        if (head == null){
            head =tail = newNode ;
            return;
        }
//        2) newNode = head
        newNode.next = head ; //Link
//        3) get head value to newNode
        head = newNode ;
    }

//---------------------------------------------------------------------------------------------------------------

//    Add to the last of LL
    public void addLast(int data){
//        1) create newNode
        Node newNode = new Node(data);
        size++;
        if (head == null){
            head = tail ;
            tail = newNode ;
            return;
        }
        tail.next= newNode ;
        tail =  newNode ;
    }

//-----------------------------------------------------------------------------------------------------------------

// Print LL
    public void print(){
        if (head == null){
            System.out.println("LL is empty ");
        }
        Node temp = head ;
        while (temp!=null){
            System.out.println("->" + temp.data);
            temp =temp.next;
        }
        System.out.println("null"); // next line
    }

//------------------------------------------------------------------------------------------------------------------

    public Node findMid(Node head){
        Node slow = head ;
        Node fast = head ;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //// we got the middle it is in middle ////
        return slow ;
    }

//-------------------------------------------------------------------------------------------------------------

    public boolean isPlaindrome(){
        if (head == null || head.next == null){
            return true ;
        }
//        STEP 01 :- Find mid
        Node midNode = findMid(head);
//        STEP 02 :- reverse 2nd half
        Node prev = null ;
        Node curr = midNode ;
        Node next ;
        while (curr != null){
            next = curr.next ;
            curr.next = prev ;
            prev = curr ;
            curr = next;
        }
//        STEP 03 :- Check left and right accordingly
        Node right = prev;
        Node left = head;
        while(right != null){
            if(left.data != right.data){
                return false ;
            }
            left = left.next;
            right = right.next;
        }
        return true ;
    }

//-------------------------------------------------------------------------------------------------------------------

//    Add middle of LL
    public void add(int idx , int data){
        if (head == null ){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data );
        size++;
        Node temp = head ;
        int i = 0 ;
        while (i < idx - 1){
            temp = temp.next ;
            i++ ;
        }
        newNode.next =temp.next ;
        temp.next = newNode ;
    }

    public int removeFirst(){
        if (size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE ;
        }
//      special case where head and tail is same
        else if (size == 1) {
            int data = head.data;
            head = tail = null ;
            return data ;
        }
        int data = head.data ;
        head = head.next ;
        size-- ;
        return data ;
    }

    public int removeLast(){
        if (size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE ;
        }else if(size == 1){
            int data = head.data;
            head = tail = null ;
            size = 0 ;
            return data;
        }
       // prev:- i = size-2 ;
        Node prev = head ;
        for(int i=0 ; i< size-2;i++){
            prev =prev.next ;
        }
        int data  = prev.next.data;
        prev.next = null;
        tail = prev;
        size -- ;
        return data ;
    }

    public static int  iterativeSearch(int key){
        Node temp = head ;
        int i = 0 ;
        while (temp!=null){
            if (temp.data == key){ // key found case
                System.out.print ("Found at ");
                return i ;
            }
            temp = temp.next;
            i++;
        }
        // key not found case
        System.out.print("not found");
        return -1 ;
    }

    public static int helper (Node head , int key){
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0 ;
        }
        int idx = helper(head.next,key) ;
        if(idx == -1) {
            return -1 ;
        }
        return idx+1;

    }
    public static int recursiveSearch(int key){
        return helper(head , key ) ;
    }

//-------------------------------------------------------------------------------------------------------------

    public static void reverseLinkedList(){
        Node prev = null ;
        Node curr = tail = head ;
        Node next ;
        while (curr != null){
             next = curr.next ;
            curr.next = prev ;
            prev = curr ;
            curr = next ;
        }
        head = prev ;
    }

//--------------------------------------------------------------------------------------------------------------------

///  Delete Node from end Nth position :-
    public static void deleteNthFromEndN(int n){
//        calculate size first :-
        int size = 0 ;
        Node temp = head ;
        while(temp != null){
            size++;
            temp = temp.next;
        }
//        delete head if target is head counting size :-
        if (n == size) { 
            head = head.next ;
        }
//        size - n :-
        int i = 1 ;
        int iToFind= size - n ;
        Node prev = head ;
        while (i < iToFind){
            prev = prev.next ;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

//------------------------------------------------------------------------------------------------------------

///    Detecting cycle in LL:-
    public static boolean checkCycle(){
        Node slow = head ;
        Node fast = head ;
        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next ;
            if(slow == fast){
                return true ;
            }
        }
        return false ;
    }

//------------------------------------------------------------------------------------------------------------

///    Removing cycle from LL:-
    public static void removeCycle(){
//        Detect cycle:-
        Node slow = head ;
        Node fast = head;
        boolean cycle = false ;
//        Find cycle first:-
        while (fast != null && fast.next!=null ){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow ){
                cycle = true ;
                break ;
            }
        }
        if (cycle == false){
            return;
        }
//        find meeting point:-
        slow = head ;
        Node prev = null ; // last node
        while(fast!=slow){
            prev  = fast ;
            slow = slow.next ;
            fast = fast.next;
        }
//        remove cycle -> last.next = null
        prev.next = null ; // removed the last starting point of the code
    }

//-------------------------------------------------------------------------------------------------------------

////  MergeSort Linked List VVIMPP Pattern :- asked in interview VVVVIMPPPP
    public Node getMid(Node head){
        Node slow = head ;
        Node fast = head.next;
        while(fast!= null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow ; //is my mid-node which we need
    }

public Node merge(Node head1 , Node head2) {
        Node mergedLL = new Node(-1);
        Node temp = mergedLL ;
        while(head1 != null && head2 != null){
            if (head1.data <= head2.data){
                temp.next =  head1;
                head1 = head1.next ;
                temp = temp.next;
            }else{
                temp.next = head2;
                head2 =head2.next;
                temp = temp.next;
            }
        }
        while(head1!=null){
            temp.next =  head1;
            head1 = head1.next ;
            temp = temp.next;
        }

        while(head2!=null){
             temp.next =  head2;
             head2 = head2.next ;
             temp = temp.next;
    }
        return mergedLL.next; // skip -1 temp
}
    public  Node mergeSort(Node head){
        if ( head == null || head.next == null){
            return head ;
        }
//        Find mid:-
        Node mid = getMid(head) ;
//        Left and Right MS:-
        Node righthead = mid.next;
        mid.next= null ;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(righthead);

//        Merge :-
        return merge(newLeft , newRight);
//        TC- O(N log N )
    }

//---------------------------------------------------------------------------------------------------------------

/// Zig-Zag merge:-
public void zigZag(){
//    Find mid :-
    Node slow = head ;
    Node fast = head.next; // for first half
    while(fast!=null && fast.next!=null){
        slow = slow.next;
        fast = fast.next.next;
    }
    Node mid = slow ;

//  Reverse 2nd half :- we need 3 variable and 4 steps
    Node curr = mid.next;
    mid.next = null ;
    Node prev = null ;
    Node next ;

    while (curr != null ){
        next = curr.next;
        curr.next = prev ;
        prev = curr ;
        curr = next ;
    }

    Node left = head ;
    Node right = prev ;
    Node nextL , nextR ;
//    alt merge :- zig-zag merge
    while (left!=null && right!=null){
        nextL = left.next;
        left.next = right ;
        nextR = right.next;
        right.next = nextL;

        left = nextL ;  // Update the value
        // of the Node to move ahead
        right = nextR ;
    }
}

//-------------------------------------------------------------------------------------------------------------

}

