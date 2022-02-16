import java.util.ArrayList;
import java.util.Scanner;

public class Solution_5215_염진호 {
	static int[] scores;
	static int[] cals;
	static int N;
	static int L;
	static int maxScore;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc=Integer.parseInt(sc.next());
		for(int i=0;i<tc;i++) {
			N=Integer.parseInt(sc.next());
			L=Integer.parseInt(sc.next());
			scores=new int[N];
			cals=new int[N];
			maxScore=0;
			for(int j=0;j<N;j++) {
				int score=Integer.parseInt(sc.next());
				int cal=Integer.parseInt(sc.next());
				scores[j]=score;
				cals[j]=cal;
			}
			selectMenu(0,0,0);
			System.out.printf("#%d %d\n",i+1,maxScore);
		}
		sc.close();
	}
	public static void selectMenu(int index,int sumS,int sumC) {
		if(sumC>L ) {
			return;
		}else if(index==N){
			if(sumS>=maxScore) {
				maxScore=sumS;
			}
			return;
		}
		selectMenu(index+1,sumS+scores[index],sumC+cals[index]);
		selectMenu(index+1,sumS,sumC);
	}
}
