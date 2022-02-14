import java.util.Scanner;
import java.util.Stack;

public class Solution_1218_염진호 {
	static Stack<Character> stack;
	static Character[] tokens;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T=10;
		for(int test_case = 1; test_case <= T; test_case++)
		{	
			stack = new Stack<>();
			int n =sc.nextInt();
			sc.nextLine();
			tokens=new Character[n];
			String input=sc.nextLine();
			for(int i=0;i<input.length();i++) {
				char now=input.charAt(i);
				if(now=='(' || now=='['||now=='{'||now=='<') {
					stack.push(now);
				}else if(now==')' && stack.peek()=='(') {
					stack.pop();
				}else if(now==']' && stack.peek()=='[') {
					stack.pop();
				}else if(now=='}' && stack.peek()=='{') {
					stack.pop();
				}else if(now=='>' && stack.peek()=='<') {
					stack.pop();
				}else {
					break;
				}
			}
			if(stack.empty()) {
				System.out.printf("#%d %d\n",test_case,1);
			}else {
				System.out.printf("#%d %d\n",test_case,0);
			}
		}
	}
}