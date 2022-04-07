import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution_1953_염진호{
  static int R,C,startR,startC,L;
  static int[][] arr;
  static class Point{
    int r;
    int c;
    int d;
    public Point(int r,int c,int d){
      this.r=r;
      this.c=c;
      this.d=d;
    }
  }
  // 상 하 좌 우
  static int[][] dr={{},{-1,1,0,0},{-1,1},{0,0},{-1,0},{1,0},{1,0},{-1,0}};
  static int[][] dc={{},{0,0,-1,1},{0,0},{-1,1},{0,1},{0,1},{0,-1},{0,-1}};
  static boolean[][] chk;
  static Queue<Point> que;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int T=Integer.parseInt(st.nextToken());
    for(int t=1;t<=T;t++){
      st=new StringTokenizer(br.readLine());
      R=Integer.parseInt(st.nextToken());
      C=Integer.parseInt(st.nextToken());
      startR=Integer.parseInt(st.nextToken());
      startC=Integer.parseInt(st.nextToken());
      L=Integer.parseInt(st.nextToken());
      arr=new int[R][C];
      for(int r=0;r<R;r++){
        st=new StringTokenizer(br.readLine());
        for(int c=0;c<C;c++){
          arr[r][c]=Integer.parseInt(st.nextToken());
        }
      }
      chk=new boolean[R][C];
      bfs(new Point(startR, startC, 1));
      int answer=0;
      for(int r=0;r<R;r++){
        for(int c=0;c<C;c++){
          if(chk[r][c])answer++;
        }
      }
      System.out.printf("#%d %d\n",t,answer);
    }
    bw.flush();
    bw.close();
    br.close();
  }
  static void bfs(Point start){
    que = new LinkedList<>();
    que.add(start);
    chk[start.r][start.c]=true;
    while(!que.isEmpty()){
      Point now =que.poll();
      if(now.d>=L)continue;
      int[] ddr=dr[arr[now.r][now.c]];
      int[] ddc=dc[arr[now.r][now.c]];
      for(int i=0;i<ddr.length;i++){
        int tr=now.r+ddr[i];
        int tc=now.c+ddc[i];
        if(tr>=0 && tc>=0 && tr<R && tc<C){
          if(!chk[tr][tc] && arr[tr][tc]!=0){
            if(ableConnect(now, new Point(tr,tc,0))){
              chk[tr][tc]=true;
              que.add(new Point(tr, tc, now.d+1));
            }
          }
        }
      }
    }
  }
  // start->end는 검증함 end->Start만 검증하면 댐
  static boolean ableConnect(Point start,Point end){
    int[] ddr=dr[arr[end.r][end.c]];
    int[] ddc=dc[arr[end.r][end.c]];
    for(int i=0;i<ddr.length;i++){
      int tr=end.r+ddr[i];
      int tc=end.c+ddc[i];
      if(tr==start.r && tc==start.c)
        return true;
    }
    return false;
  }
}