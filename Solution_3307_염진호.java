import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution_3307_염진호{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int T =Integer.parseInt(st.nextToken());
    for(int t=1;t<=T;t++){
      st = new StringTokenizer(br.readLine());
      int N=Integer.parseInt(st.nextToken());
      int[] dp=new int[N+1];
      int[] arr=new int[N+1];
      st = new StringTokenizer(br.readLine());
      for(int i=1;i<=N;i++){
        arr[i]=Integer.parseInt(st.nextToken());
      }
      int answer=0;
      for(int i=1;i<=N;i++){
        for(int j=i-1;j>=0;j--){
          if(arr[j]<arr[i]){
            dp[i]=Math.max(dp[i],dp[j]+1);
          }
        }
        answer=Math.max(answer,dp[i]);
      }

      System.out.printf("#%d %d\n",t,answer);
    }
    bw.flush();
    bw.close();
    br.close();
  }
}
