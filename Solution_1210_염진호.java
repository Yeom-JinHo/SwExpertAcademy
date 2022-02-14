import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1210_염진호 {
	// 좌 우 상  
	static int[] dr= {0,0,-1};
	static int[] dc= {-1,1,0};
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		arr=new int[100][100];
		for(int i=0;i<10;i++) {
			br.readLine();
			for(int r=0;r<100;r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int c=0;c<100;c++) {
					arr[r][c]=Integer.parseInt(st.nextToken());
				}
			}
			for(int k=0;k<100;k++) {
				if(arr[99][k]==2) {
					sb.append("#").append(i+1).append(" ").append(solve(99,k)).append('\n');
					break;
				}
			}
		}
		System.out.println(sb);
		br.close();
		
	}
	static int solve(int r,int c) {
		arr[r][c]=0;
		while(true) {
			if(r==0) {
				return c;
			}
			for(int i=0;i<3;i++) {
				int tr=r+dr[i];
				int tc=c+dc[i];
				if (tr>=0 && tr<100 && tc>=0 && tc<100) {
					if(arr[tr][tc]==1) {
						r=tr;
						c=tc;
						arr[r][c]=0;
						break;
					}
				}
			}
		}
	}
}
