import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution_1233_염진호{
  static int nodeLen,start;
  static Node[] nodeList;
  static boolean[] chked;
  static int[] maxNum;
  static int maxDep;
  static class Node{
    int val;
    Node next;
    Node(int val,Node next){
      this.val=val;
      this.next=next;
    }
  }
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;
    int T=10;
    for(int tc=1;tc<=T;tc++){
      st=new StringTokenizer(br.readLine());
      nodeLen=Integer.parseInt(st.nextToken());
      start=Integer.parseInt(st.nextToken());
      nodeList=new Node[100+1];
      chked=new boolean[100+1];
      maxNum=new int[100+1];
      maxDep=0;

      st=new StringTokenizer(br.readLine());
      for(int l=0;l<nodeLen/2;l++){
    	int from = Integer.parseInt(st.nextToken());
        int to =Integer.parseInt(st.nextToken());
        nodeList[from]=new Node(to,nodeList[from]);
      }
      bfs(start);
      bw.write("#"+tc+" "+maxNum[maxDep]+"\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }
  static void bfs(int start){
    chked[start]=true;
    Queue<int[]> que= new LinkedList<>();
    que.add(new int[]{start,1});
    while(!que.isEmpty()){
      int[] now=que.poll();
      int nowVal=now[0];
      int dep=now[1];
      for(Node node=nodeList[nowVal];node!=null;node=node.next){
        if(!chked[node.val]){
          chked[node.val]=true;
          que.add(new int[]{node.val,dep+1});
          maxNum[dep]=Math.max(node.val,maxNum[dep]);
          maxDep=Math.max(maxDep,dep);
        }
      }
    }
  }
}
