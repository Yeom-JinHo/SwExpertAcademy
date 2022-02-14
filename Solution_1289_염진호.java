import java.util.Scanner;

public class Solution_1289_염진호 {

	public static void main(String[] args) {
		char turn;
		int count;
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		sc.nextLine();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{	
			turn='1';
			count=0;
			String inp=sc.nextLine();
			for(int i =0; i<inp.length();i++) {
				if(inp.charAt(i)==turn) {
					turn=turn=='0'?'1':'0';
					count+=1;
				}
			}
			System.out.printf("#%d %d\n",test_case,count);
		}
	}

}
