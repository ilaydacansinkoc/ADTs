
public class Main {

	public static void main(String[] args){

		String str= "(a+b)*c";
		System.out.println(infixToPostfix(str));
		
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

	public static String infixToPostfix(String str){
		
		String result="";
		StackImpl<Character> s=new StackImpl<>(str.length());
		for(char ch:str.toCharArray()){
			// If encountered with non operand character, then add them into result string.
			if(ch != '+' && ch != '-'&& ch != '*'&& ch != '/' && ch!='(' && ch!=')')
				result+=ch;
			// If encountered char is operator
			else{
				// If encountered char is not ( or )
				if(ch != '(' && ch!=')'){
					if(s.isEmpty())
						s.push(ch);

					else{
						// Check precedence of char at the top of the stack and current char
						while(getPrec(s.peek()) >= getPrec(ch) ){
							// If char at stack has higher precedence than pop it and append to the result string.
							result+=s.pop();
							if(s.isEmpty())
								break;
						}
						// If not then push it onto stack
						s.push(ch);
					}
				}
				else{
					if(ch=='(')
	                       s.push(ch);
	                   else
	                   {
	                       while(s.peek()!='(')
	                       {
	                           result=result+s.pop();
	                       }
	                       s.pop();
	                   }
				}
			}
		}
		while(!s.isEmpty()){
			result+=s.pop();
		}
		
		return result;
	}
	
	public static int getPrec(char ch){
		 if(ch=='+'||ch=='-')
	            return 1;
         if(ch=='*'||ch=='/')
	            return 2;
         if(ch=='('||ch==')')
	            return 0;
         return -1;
	}
}

