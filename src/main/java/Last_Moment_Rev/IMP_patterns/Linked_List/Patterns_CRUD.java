package Last_Moment_Rev.IMP_patterns.Linked_List;

public class Patterns_CRUD {

   public static class Node {
        int data ;
        Node next ;

        public Node(int data  ){
            this.data = data ;
            this.next = null ;
        }
    }

public static Node head ;
public static Node tail ;

    public static void main(String[] args) {
        Patterns_CRUD ll = new Patterns_CRUD() ;
        ll.addFirst(1);
    }

    public static void addFirst(int data){
        // create new node
            Node newNode = new Node(data);
            newNode.next = head ;
            head =  newNode ;
    }

    public static void addLast(int data){
        // create newNode
        Node newNode = new Node(data);
        // then tail next link newNode:
        tail.next = newNode ;
        //make newNode tail:
        tail = newNode ;
    }

    public static void addMiddle( int idx , int data){
            Node newNode = new Node(data);
            Node temp = head ;
            int i = 0 ;
            while( i < idx-1){
                temp = temp.next;
                i++;
            }
            // i = idx-1 :-> prev
            newNode.next = temp.next;
            temp.next = newNode ;
    }

    public static void deletNode(int idx ){

        if(head == null ){
            return;
        }

        if(idx == 0){
            head = head.next;
            return;
        }

        Node temp = head ;
        Node prev = null ;
        int i = 0 ;

        while(temp != null){
            // If we got the idx then skip it
            if( i  == idx ){
                prev.next = temp.next;
                return;
            }
            // move pointer ahead:
            prev = temp ;
            temp = temp.next ;
            i++;
        }
    }

    public static int findLength( ){
        Node temp = head ;
        int count = 0 ;
        while(temp!=null){
            temp = temp.next;
            count++;
        }
        return count ;
    }

    public static void reverse(){
        Node prev = null ;
        Node curr = head ;

        while(curr != null ){
            Node next = curr.next;
            curr.next = prev ;
            prev = curr ;
            curr = next ;
        }
        head = prev ;
    }
//----------------------------------------------------------------------------------------------------------------------------
    /// Merge Sort :- very Imp:-
    public static Node merge(Node head1 , Node head2){
        // create  temp
        Node mergedLL = new Node(-1);
        Node temp = mergedLL ;

        //check sorting and add to temp
        while(head1 != null && head2 != null ){

            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }

        while(head1 != null ){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while(head2!= null ){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        // bcoz in head temp is stored not correct order:
        return mergedLL.next ;
    }

    public static Node getMid(Node head){
        Node slow = head ;
        Node fast = head.next ; // for 1st half of the middle:
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow ;
    }

    public static Node mergeSort( Node head ){
        //base case:
        if(head == null || head.next == null){
            return head ;
        }
        // find middle:
        Node mid = getMid(head);
        //left merge
        Node rightHead = mid.next;
        mid.next = null ;

        // pointer for merge
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        return merge(newLeft , newRight) ;
    }
//----------------------------------------------------------------------------------------------------------------------------
}
