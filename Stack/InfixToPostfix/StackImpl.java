import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

public class StackImpl<T> implements StackInterface<T> {

	private int top;
	private T[] stack;
	
	public StackImpl(int size){
		top=-1;
		stack= (T[]) new Object[size];
	}
	
	@Override
	public void push(T newItem) {

		stack[++top]=newItem;
		System.out.println("Item pushed: "+newItem);
	}

	@Override
	public T pop() {
	
		if(isEmpty()) return null;
		System.out.println("Item popped: "+ stack[top]);
		return stack[top--];
	}

	@Override
	public T peek() {

		if(!isEmpty()){
			System.out.println("Peek item: "+stack[top]);
			return stack[top];
		}
		return null;
	}

	@Override
	public boolean isEmpty() {

		if(top==-1)
			return true;
		else return false;
	}

	@Override
	public void clear() {

		while(top!=-1){
			System.out.println("Item deleted: "+ pop());
		}
		
	}
	
	public int size(){
		return top+1;
	}




}
