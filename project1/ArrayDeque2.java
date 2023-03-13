@SuppressWarnings("unchecked")
public class ArrayDeque2<dog>{
    
   /*
    i use genericity so that my Array can accomodate any types of data,which includes
 reference data type and basic data type
   */
    dog[] items;
    int size;
    int nextFirst;
    int nextLast;
    /*
        Throgh this method ,i learn that we can only
      instantiation a variable through main method, not
      including normal method.
    */
    public ArrayDeque2(){
    	//cast type conversion
      
      this.size=0;
      this.nextFirst=2;
      this.nextLast=7;
    }
    public void addFirst(dog item){
    	this.size++;
    	this.items[nextFirst]=item;
    	nextFirst++;
    	if(nextFirst==9){
    		nextFirst=0;
    	}
    }
    public void addLast(dog item){
    	this.size++;
    	this.items[nextLast]=item;
    	nextLast++;
    	if(nextLast==9){
    		nextLast=0;
    	}
    }
    public void printDeque(){
    	for(int i=0;i<this.items.length;i++){
    		if(this.items[i]==null){
    			continue;
    		}
    		System.out.print(this.items[i]);
    	}
    }
    public int size(){
    	return this.size;
    }
    public boolean isEmpty(){
    	for(int i=0;i<this.items.length;i++){
    		if(this.items[i]!=null){
    			return false;
    		}
    	}
    	return true;
    }
    public dog removeFirst(){
       if(nextFirst==0){
       	nextFirst=9;
       }
       dog a=this.items[nextFirst-1];
       this.items[nextFirst-1]=null;
       nextFirst--;
       return a;
    }

    public static void main(String[]args){
    	@SuppressWarnings("unchecked")
    	ArrayDeque2<Character>a1=new ArrayDeque2<>();
    	a1.items=new Character[9];
    	a1.addFirst('a');
        System.out.println(a1.items[2]);
    	a1.removeFirst();
        if(a1.isEmpty()){
        	System.out.println("successful");
        }
        
    }








}