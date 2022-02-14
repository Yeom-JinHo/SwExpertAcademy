import java.util.Scanner;

public class Solution_2001_염진호 {
	static int[][] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N =sc.nextInt();
			int M =sc.nextInt();
			arr=new int[N][N];
			for(int r=0;r<N;r++) {
				for(int c=0;c<N;c++) {
					arr[r][c]=sc.nextInt();
				}
			}
			int max=0;
			for(int r=0;r<N-M+1;r++) {
				for(int c=0;c<N-M+1;c++) {
					int result=pari(r,c,M);
					if(max<result) {
						max=result;
					}
				}
			}
			System.out.println("#"+test_case+" "+max);
		}
	}
	public static int pari(int r,int c,int len) {
		int sum=0;
		for(int rr=0;rr<len;rr++) {
			for(int cc=0;cc<len;cc++) {
				sum+=arr[r+rr][c+cc];
			}
		}
		return sum;
	}

}
