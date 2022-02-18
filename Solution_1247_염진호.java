import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution_1247_염진호{
  static int N,answer;
  static int[][]arr,perArr;
  static int[] home,company;
  static boolean[] chk;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int TC=Integer.parseInt(st.nextToken());
    for(int t=1;t<=TC;t++){
      N=Integer.parseInt(br.readLine());
      answer=Integer.MAX_VALUE;
      arr=new int[N][2];
      perArr=new int[N][2];
      home=new int[2];
      company=new int[2];
      chk=new boolean[N];
      st=new StringTokenizer(br.readLine());
      company[0]=Integer.parseInt(st.nextToken());
      company[1]=Integer.parseInt(st.nextToken());
      home[0]=Integer.parseInt(st.nextToken());
      home[1]=Integer.parseInt(st.nextToken());
      for(int i=0;i<N;i++){
        arr[i][0]=Integer.parseInt(st.nextToken());
        arr[i][1]=Integer.parseInt(st.nextToken());
      }
      per(0);
      bw.write("#"+t+" "+answer+"\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }
  static void per(int cnt){
    if(cnt==N){
      // 회사에서 첫 거래처까지 거리
      int sum=0;
      sum+=Math.abs(company[0]-perArr[0][0])+Math.abs(company[1]-perArr[0][1]);
      //거래처 거리
      for(int i=1;i<N;i++){
        sum+=Math.abs(perArr[i][0]-perArr[i-1][0])+Math.abs(perArr[i][1]-perArr[i-1][1]);
      }

      sum+=Math.abs(home[0]-perArr[N-1][0])+Math.abs(home[1]-perArr[N-1][1]);

      answer=Math.min(answer, sum);
    }else{
      for(int i=0;i<N;i++){
        if(!chk[i]){
          chk[i]=true;
          perArr[cnt]=arr[i];
          per(cnt+1);
          chk[i]=false;
        }
      }
    }
  }
}