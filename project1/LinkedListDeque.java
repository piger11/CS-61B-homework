public class LinkedListDeque<dog>{
     class Node{
         public Node prev;
         public Node next;
         public dog item;
         public Node(dog d){
         	this.item=d;
         	this.prev=null;
         	this.next=null;
         }
         public Node(){
         	this.prev=null;
         	this.next=null;
         }
     }
     public Node sentinel;
     public Node last;
     public int size;
     public LinkedListDeque(dog d){
     	Node a=new Node(d);
     	this.sentinel=new Node();
     	this.last=new Node();
     	this.sentinel.prev=null;
     	this.sentinel.next=a;
     	this.last.next=null;
     	this.last.prev=a;
     	a.prev=this.sentinel;
     	a.next=this.last;
     }
     public void addFirst(dog item){

     }
     public void addLast(dog item){

     }
     public boolean isEmpty(){

     }
     public int size(){

     }
     public void printDeque(){

     }
     public dog removeFirsy(){

     }
     public dog removeLast(){

     }
     public dog get (int index){
        
     }
     public static void main(String[]args){

     	LinkedListDeque<String> a=new LinkedListDeque<>("hello world");
     	System.out.println(a.sentinel.next.item);
     	System.out.println(a.last.prev.item);
     }


}