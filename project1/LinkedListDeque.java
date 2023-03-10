public class LinkedListDeque<dog>{
	/*
	   i use generic type dog so that i can receive any generic type in the elements "item"
	*/
    class Node{
    	/*
    	   the IntNode class includes three variables:item,pre pointer and next pointer

    	*/
    	public dog item;
      public Node prev;
    	public Node next;
    	/*
    	   this instructor method includes the basic initializes for IntNode, not including
    	initializeing for item

    	*/
    	public Node(){
    		this.prev=null;
    		this.next=null;
    	}
    	/*
    	   this instructor method includes initializes for IntNode,including initializing 
    	 for item
    	   */
        public Node(dog i){
        	this.item=i;
        	this.prev=null;
        	this.next=null;
        }
    }  
    /*
       The LinkedListDeque class includes three basic variables:sentinel pointing to the
     head node, last pointing to the last node and size used for caculating the number
     of elements in the LinkedListDeque
    */
    private Node sentinel;
    private Node last;
    private int size;
    public LinkedListDeque(){
      this.size=0;
      this.sentinel=new Node();
      this.last=new Node();
      this.sentinel.next=this.last;
      this.last.prev=this.sentinel;
    }
    public LinkedListDeque(dog d){
    	this.size=1;
    	this.sentinel=new Node();
    	this.last=new Node();
    	Node a=new Node(d);
    	this.sentinel.next=a;
    	this.last.prev=a;
    	a.prev=this.sentinel;
    	a.next=this.last;
    }
    /*
      these methods are used for adding elements in the Double ended queue,one is adding 
   from the sentinel node,another is adding from the last node
    */
    public void addFirst(dog item){
      Node d=new Node(item);
      this.sentinel.next.prev=d;
      d.next=this.sentinel.next;
      this.sentinel.next=d;
      d.prev=this.sentinel;
      size++;
    }
    public void addLast(dog item){
      Node d=new Node(item);
      this.last.prev.next=d;
      d.prev=this.last.prev;
      this.last.prev=d;
      d.next=this.last;
      size++;
    }
    /*
      this method is used for printing all the list elements so that we can find whether
   we do is right
    */
    public void printDeque(){
      Node d=this.sentinel.next;
      while(d.next!=null){
         System.out.print(d.item+" ");
         d=d.next;
      }
    }
    public boolean isEmpty(){
      Node d=this.sentinel.next;
      if(d==null){
         return true;
      }
      return false;
    }
    public int size(){
      return this.size;
    }
    /*
      this method is used for removing the first elements in the double ended list
    */
    public dog removeFirst(){
      dog d=this.sentinel.next.item;
      this.sentinel.next.prev=null;
      this.sentinel.next=this.sentinel.next.next;
      this.sentinel.next.prev.next=null;
      this.sentinel.next.prev=this.sentinel;
      return d;
    }
    /*
       this method is used for removing the  elements in the double ended list 
    */
    public dog removeLast(){
      dog d=this.last.prev.item;
      this.last.prev.next=null;
      this.last.prev=this.last.prev.prev;
      this.last.prev.next.prev=null;
      this.last.prev.next=this.last;
      return d;
    }
    public static void main(String[]args){
       LinkedListDeque<String>d2=new LinkedListDeque<>("hello");
       System.out.println(d2.sentinel.next.item);
       d2.addFirst("nidie");
       d2.addLast("world");
       d2.printDeque();
       d2.removeFirst();
       d2.removeLast();
       d2.printDeque();
    }
 }  
