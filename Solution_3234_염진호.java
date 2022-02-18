import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution_3234_염진호 {
  static int N,answer;
  static int[] arr,ord;
  static boolean[] chk;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int Tc=Integer.parseInt(st.nextToken());
    for(int t=1;t<=Tc;t++){
      answer=0;
      N=Integer.parseInt(br.readLine());
      arr=new int[N];
      chk=new boolean[N];
      ord=new int[N];
      st=new StringTokenizer(br.readLine());
      for(int i=0;i<N;i++){
        arr[i]=Integer.parseInt(st.nextToken());
      }
      per(0);
      bw.write("#"+t+" "+answer+"\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }
  static void per(int cnt){
    if(cnt == N) {
      subset(0,0,0);
      return;
    }
    for (int i = 0; i < N; i++) {
      if (!chk[i]) {
        chk[i] = true;
        ord[cnt] = arr[i];
        per(cnt + 1);  
        chk[i] = false;
      }
    }
  }
  static void subset(int ind,int lC,int rC){
    if(lC<rC){
      return;
    }
    if(ind==N){
      answer+=1;
    }else{
      subset(ind+1,lC+ord[ind],rC);
      subset(ind+1,lC,rC+ord[ind]);
    }
  }
}
