import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_9229_염진호 {
	static int N;
	static int M;
	static int[] arr;
	static boolean[] chk;
	static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int tcLen = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=tcLen; tc++) {
			st=new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			st=new StringTokenizer(br.readLine());
			arr=new int[N];
			chk=new boolean[N];
			answer=-1;
			for(int i =0;i<N;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			solve(0,0);
			bw.write("#"+tc+" "+answer+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
		
	}
	static void solve(int dep,int total) {
		if(dep==2) {
			if(total<=M)
				answer=Math.max(answer, total);
		}else {
			for(int i=0;i<N;i++) {
				if(!chk[i] && total<=M) {
					chk[i]=true;
					solve(dep+1,total+arr[i]);
					chk[i]=false;
				}
			}
		}
	}
}
