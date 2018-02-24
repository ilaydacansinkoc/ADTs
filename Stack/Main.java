
public class Main {

	public static void main(String[] args){
		StackImpl<Integer> s=new StackImpl<>(5);
		s.push(2);
		s.push(1);
		s.pop();
		s.peek();
	}
}
