import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution_7465_염진호{
  static int N,M;
  static int[] parents;
  static boolean[] chk;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int T=Integer.parseInt(st.nextToken());
    for(int tc=1;tc<=T;tc++){
      st=new StringTokenizer(br.readLine());
      N=Integer.parseInt(st.nextToken());
      M=Integer.parseInt(st.nextToken());
      parents=new int[N+1];
      chk=new boolean[N+1];
      for(int k=1;k<=N;k++){
        parents[k]=k;
      }
      for(int i=0;i<M;i++){
        st=new StringTokenizer(br.readLine());
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());
        union(a,b);
      }
      for(int j=1;j<=N;j++){
        chk[findParent(j)]=true;
      }
      int answer=0;
      for(int j=1;j<=N;j++){
        if(chk[j]){
          answer+=1;
        }
      }
      bw.write("#"+tc+" "+answer+"\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }
  static void union(int a, int b){
    int aRoot =findParent(a);
    int bRoot =findParent(b);
    if(aRoot!=bRoot){
      parents[bRoot]=aRoot;
    }
  }
  static int findParent(int a){
    if(parents[a]==a) return a;
    return parents[a]=findParent(parents[a]);
  }
}