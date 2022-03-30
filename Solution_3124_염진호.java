import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution_3124_염진호{
  static PriorityQueue<Node> wList;
  static int[] parents;
  static class Node implements Comparable<Node>{
    int a;
    int b;
    long w;
    public Node(int a,int b,long w){
      this.a=a;
      this.b=b;
      this.w=w;
    }
    @Override
    public int compareTo(Node o) {
      return (int) (this.w-o.w);
    }
  }
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb =new StringBuilder();
    int T=Integer.parseInt(st.nextToken());
    for(int t=0;t<T;t++){
      st=new StringTokenizer(br.readLine());
      int V=Integer.parseInt(st.nextToken());
      int E=Integer.parseInt(st.nextToken());
      wList=new PriorityQueue<>();
      parents=new int[V+1];

      for(int i=0;i<V+1;i++){
        parents[i]=i;
      }

      for(int i=0;i<E;i++){
        st=new StringTokenizer(br.readLine());
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());
        long w=Long.parseLong(st.nextToken());
        wList.add(new Node(a,b,w));
      }
      long answer=0;
      int count=1;
      while(count<V){
        Node now =wList.poll();
        if(union(now.a, now.b)){
          count++;
          answer+=now.w;
        }
      }
      System.out.printf("#%d %d\n",t+1,answer);
    }
    bw.flush();
    bw.close();
    br.close();
  }
  static int findParent(int a){
    if(parents[a]==a)return a;

    parents[a]=findParent(parents[a]);
    return parents[a];
  }

  static boolean union(int a,int b){
    int aRoot=findParent(a);
    int bRoot=findParent(b);
    if(aRoot==bRoot){
      return false;
    }else{
      parents[bRoot]=aRoot;
      return true;
    }
  }
}
