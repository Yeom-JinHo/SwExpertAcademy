import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1861_염진호 {
	static int[][] graph;
	static int l;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	static int roomCount;
	static Queue<int[]> que;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int tc=Integer.parseInt(br.readLine());
		for(int t=1;t<=tc;t++) {
			l=Integer.parseInt(br.readLine());
			graph=new int[l][l];
			for(int i=0;i<l;i++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				for(int j=0;j<l;j++) {
					graph[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			int maxRoom=0;
			int maxStart=10001;
//			for(int r=0;r<l;r++) {
//				for(int c=0;c<l;c++) {
//					roomCount=1;
//					dfs(r,c);
//					if(roomCount==maxRoom) {
//						maxStart=Math.min(maxStart,graph[r][c]);
//					}else if(roomCount>maxRoom) {
//						maxRoom=roomCount;
//						maxStart=graph[r][c];
//					}
//				}
//			}
			for(int r=0;r<l;r++) {
				for(int c=0;c<l;c++) {
					roomCount=bfs(r,c);
					if(roomCount==maxRoom) {
						maxStart=Math.min(maxStart,graph[r][c]);
					}else if(roomCount>maxRoom) {
						maxRoom=roomCount;
						maxStart=graph[r][c];
					}
				}
			}
			sb.append("#"+t).append(" "+maxStart).append(" "+maxRoom+"\n");
		}
		System.out.println(sb);
		br.close();
	}
//	static void dfs(int sr,int sc) {
//		int nowN=graph[sr][sc];
//		int r=sr;
//		int c=sc;
//		for(int i=0;i<4;i++) {
//			int tr=r+dr[i];
//			int tc=c+dc[i];
//			if(tc>=0 && tr>=0 && tc<l && tr<l) {
//				if(graph[r][c]+1==graph[tr][tc]) {
//					dfs(tr,tc);
//					roomCount++;
//					break;
//				}
//			}
//		}
//	}

	static int bfs(int sr,int sc) {
		que=new LinkedList<int[]>();
		int[] init= {sr,sc};
		que.offer(init);
		int r=sr;
		int c=sc;
		while(!que.isEmpty()) {
			int[] now=que.poll();
			r=now[0];
			c=now[1];
			int nowN=graph[r][c];
			for(int i=0;i<4;i++) {
				int tr=r+dr[i];
				int tc=c+dc[i];
				if( tc>=0 && tr>=0 && tc<l && tr<l) {
					if((nowN+1)==graph[tr][tc]) {
						int[] tmp= {tr,tc};
						que.offer(tmp);
					}
				}
			}
		}
		return graph[r][c]-graph[sr][sc]+1;
	}

}
