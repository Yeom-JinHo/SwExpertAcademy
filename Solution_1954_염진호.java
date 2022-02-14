import java.util.Scanner;

public class Solution_1954_염진호 {
	// 우 하 좌 상  
	static int[] dr= {0,1,0,-1};
	static int[] dc= {1,0,-1,0};
	static String[][] arr;
	static int nowN;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tc=Integer.parseInt(sc.next());
		for(int i =0;i<tc;i++) {
			int len = Integer.parseInt(sc.next());
			arr=new String[len][len];
			nowN=1;
			recursion(0,0,len);
			System.out.println("#"+(i+1));
			printArr(len);
		}
	}
	public static void printArr(int len) {
		for(int z=0;z<len;z++) {
			System.out.println(String.join(" ",arr[z]));
		}
	}
	public static void recursion(int r , int c ,int len) {
		int realR=r;
		int realC=c;
		if(len>=1) {
			arr[r][c]=Integer.toString(nowN++);
			for(int i =0;i<4;i++) {
				for(int j=0;j<len-1;j++) {
					int tr=r+dr[i];
					int tc=c+dc[i];
					if(realR==tr && realC==tc) {
						recursion(realR+1,realC+1,len-2);
						break;
					}
					arr[tr][tc]=Integer.toString(nowN++);
					r=tr;
					c=tc;
				}
			}
		}
	}
}
