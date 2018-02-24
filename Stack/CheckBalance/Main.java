
public class Main {

	public static void main(String[] args){

		String str= "[a{b/(c-d)+e/(f+g)}-h]";
		if(checkBalance(str))
			System.out.println(str+ "is balanced.");
		else System.out.println(str+ "is not balanced.");
		
	}
	
	public static boolean checkBalance(String item){
		StackImpl<Character> c=new StackImpl<>(item.length());
		for(char ch: item.toCharArray()){
			switch(ch){
			case '{':
			case '[':
			case '(':
				c.push(ch);
				break;
			case ')':
				if(c.isEmpty() || c.pop() != '(')
					return false;
				break;
			case ']':
				if(c.isEmpty() || c.pop() != '[')
					return false;
				break;
			case '}':
				if(c.isEmpty() || c.pop() != '{')
					return false;
				break;
				
			}
		}
		return c.isEmpty();
	}
}
