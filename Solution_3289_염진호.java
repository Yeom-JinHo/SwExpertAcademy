import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution_3289_염진호{
  static int N,M;
  static int[] parents;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int T=Integer.parseInt(st.nextToken());
    for(int tc=1;tc<=T;tc++){
      StringBuilder sb=new StringBuilder();
      st=new StringTokenizer(br.readLine());
      N=Integer.parseInt(st.nextToken());
      M=Integer.parseInt(st.nextToken());
      parents=new int[N+1];
      for(int k=1;k<=N;k++){
        parents[k]=k;
      }
      for(int i=0;i<M;i++){
        st=new StringTokenizer(br.readLine());
        int command=Integer.parseInt(st.nextToken());
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());
        if(command==0){
          union(a,b);
        }else if (command==1){
          int headEquals=findParent(a)==findParent(b)?1:0;
          sb.append(headEquals);
        }
      }
      bw.write("#"+tc+" "+sb+"\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }
  static void union(int a,int b){
    int aRoot = findParent(a);
    int bRoot = findParent(b);
    if (aRoot!=bRoot){
      parents[bRoot]=aRoot;
    }
  }
  static int findParent(int a){
    if(a==parents[a]) return a;
    return parents[a]=findParent(parents[a]);
  }
}
