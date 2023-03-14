public class AList<dog>{
	@SuppressWarnings("unchecked")
     dog[] items;
     int size;
    @SuppressWarnings("unchecked")
    public AList(){
    	
     	size=0;   
     	this.items=(dog[])new Object[100];  
    } @SuppressWarnings("unchecked")
    public void addLast(dog item){
    	
        this.size++;
        if(this.isFull()){
            dog a[]=(dog[])new Object[size+1];
            System.arraycopy(this.items,0,a,0,size);
            a[size]=item;
            this.items=a;
            this.size=this.size+1;
            return;
        }
        this.items[size]=item;
    }@SuppressWarnings("unchecked")
    public boolean isFull(){
    	
    	if(this.size==this.items.length){
    		return true;
    	}
    	return false;
    }@SuppressWarnings("unchecked")
    public dog getLast(){
    	
     	return this.items[this.items.length-1];
    }@SuppressWarnings("unchecked")
    public dog get(int i){
    	
    	return this.items[i];
    }@SuppressWarnings("unchecked")
    public int  size(){
    	
    	return this.size;
    }@SuppressWarnings("unchecked")
    public dog removeLast(){
    	size--;
        dog a=this.items[this.size-1];
        this.items[this.size-1]=null;
        return a;
    }
    public void insertBack(int x){

    }
    /*
    */
    @SuppressWarnings("unchecked")
    public static void main(String[]args) throws ClassCastException{
    	AList <Character>a1=new AList<Character>();
    	a1.addLast('a');
    	a1.addLast('b');
    	System.out.println(a1.items[0]);
    	System.out.println(a1.items[1]);
    }
}
/*

   int[]a=new int[size+1];
   System.arraycopy(items,0,a,0,size);
   a[size]=11;
   items=a;
   size=size+1;
*/




