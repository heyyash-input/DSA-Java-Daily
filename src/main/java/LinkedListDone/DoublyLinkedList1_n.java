package LinkedListDone;

public class DoublyLinkedList1_n {
    public class  Node {
        int data ;
        Node next ;
        Node prev ;

        public Node(int data){
            this.data = data ;
            this.next = null;
            this.prev = null ;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void print(){
        Node temp = head ;
        while(temp!=null){
            System.out.print(temp.data + "<->");
            temp =  temp.next ;
        }
        System.out.println("null");
    }

//    add
    public  void addFirst(int data) {
        Node newNode = new Node( data) ;
        size++;
        if(head == null){
            head = tail = newNode ;
             return;
        }
        newNode.next = head ;
        head.prev = newNode ;
        head = newNode ;
    }

//    remove
    public int removeFirst( ){
        if(head == null){
            System.out.println("Doubly ll is empty");
            return Integer.MIN_VALUE ;
        }
        if(size == 1){
            int val = head.data ;
            head = tail = null ;
            size--;
            return val ;
        }
        int val = head.data ;
        head = head.next ;
        head.prev = null ; // Line error for single LL
        size-- ;
        return val ;
    }

    public void reversDll(){
        Node curr = head ;
        Node prev = null ;
        Node next ;
        while (curr != null ){
            next = curr.next ;
            curr.next= prev;
            curr.prev = next;
            prev = curr ;
             curr = next;
        }
        head = prev ;
   }

    public static void main(String[] args) {
        DoublyLinkedList1_n dll = new DoublyLinkedList1_n() ;
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.print();
        System.out.println(size);

//        dll.removeFirst();
//        dll.print();
//        System.out.println(size);
        dll.reversDll();
        dll.print();
    }

}
