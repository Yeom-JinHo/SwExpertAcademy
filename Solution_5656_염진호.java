import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution_5656_염진호{
  static int N,W,H;
  static int[][] arr;
  static int[][] progress;
  static int answer;
  static Queue<Point> que=new LinkedList<>();
  static int[] dr={-1,0,1,0};
  static int[] dc={0,1,0,-1};
  static class Point{
    int r;
    int c;
    int l;
    public Point(int r,int c,int l){
      this.r=r;
      this.c=c;
      this.l=l;
    }
  }
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int T =Integer.parseInt(st.nextToken());
    for(int t=1;t<=T;t++){
      st=new StringTokenizer(br.readLine());
      N=Integer.parseInt(st.nextToken());
      W=Integer.parseInt(st.nextToken());
      H=Integer.parseInt(st.nextToken());
      arr=new int[H][W];
      
      progress=new int[H][W];
      for(int r=0;r<H;r++){
        st=new StringTokenizer(br.readLine());
        for(int c=0;c<W;c++){
          arr[r][c]=Integer.parseInt(st.nextToken());
        }
      }
      deepCopy(arr, progress);
      answer=Integer.MAX_VALUE;
      dfs(0);
      System.out.printf("#%d %d\n",t,answer);
    }
    bw.flush();
    bw.close(); 
    br.close();
  }
  static void dfs(int count){
    if(count==N){
      answer=Math.min(answer, countBall());
      return;
    }
    int[][] tmp=new int[H][W];;
    for(int i=0;i<W;i++){
      deepCopy(progress, tmp);
      shot(i);
      fall();
      dfs(count+1);
      deepCopy(tmp,progress);
    }
  }
  static int countBall(){
    int count=0;
    for(int r=0;r<H;r++){
      for(int c=0;c<W;c++){
        if(progress[r][c]>0)
          count+=1;
      }
    }
    return count;
  }
  static void deepCopy(int[][] origin,int[][] copy){
    for(int r=0;r<H;r++){
      for(int c=0;c<W;c++){
        copy[r][c]=origin[r][c];
      }
    }
  }
  static void bomb(Point start){
    que.add(start);

    while(!que.isEmpty()){
      Point now= que.poll();
      progress[now.r][now.c]=0;
      for(int i=0;i<4;i++){
        for(int j=1;j<=now.l-1;j++){
          int tr=now.r+dr[i]*j;
          int tc=now.c+dc[i]*j;
          if(tr>=0 && tc>=0 && tr<H && tc<W){
            if(progress[tr][tc]>0){
              que.add(new Point(tr, tc, progress[tr][tc]));
              progress[tr][tc]=0;
            }
          }
        }
      }
    }
  }

  static void fall(){
    Queue<Integer> fallQ=new LinkedList<>();
    for(int c=0;c<W;c++){
      for(int r=H-1;r>=0;r--){
        if(progress[r][c]>0){
          fallQ.add(progress[r][c]);
        }
        progress[r][c]=0;
      }
      int insertInd=H-1;
      while(!fallQ.isEmpty()){
        progress[insertInd][c]=fallQ.poll();
        insertInd-=1;
      }
    }
  }
  static void shot(int index){
    for(int r=0;r<H;r++){
      if(progress[r][index]>0){
        bomb(new Point(r, index, progress[r][index]));
        return;
      }
    }
  }
}