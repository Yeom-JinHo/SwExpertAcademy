import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Solution_6908_염진호{
  static int[] guArr=new int[9];
  static int[] inArr=new int[9];
  static int[] chk;
  static int[] tmpInArr=new int[9];
  static int guScore,inScore;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int tc=Integer.parseInt(st.nextToken());
    for(int t=1;t<=tc;t++){
      guScore=0;
      inScore=0;
      chk=new int[18];
      st=new StringTokenizer(br.readLine());
      // 규영이 인풋ㅅ받기
      for(int i=0;i<9;i++){
        int input=Integer.parseInt(st.nextToken());
        guArr[i]=input;
        chk[input-1]=1;
      }
      // 인영이 숫자 배열 찾기
      int tmpCnt=0;
      for(int i=0;i<18;i++){
        if(chk[i]==0){
          inArr[tmpCnt]=i+1;
          tmpCnt++;
        }
      }
      comb(0);
      bw.write("#"+t+" "+guScore+" "+inScore+"\n");;
    }
    bw.flush();
    bw.close();
    br.close();
  }
  //순열
  static void comb(int cnt){
    if(cnt==9){
      int tmpGuScore=0;
      int tmpInScore=0;
      for(int i=0;i<9;i++){
        if(guArr[i]>tmpInArr[i]){
          tmpGuScore+=guArr[i]+tmpInArr[i];
        }else if(guArr[i]<tmpInArr[i]){
          tmpInScore+=guArr[i]+tmpInArr[i];
        }
      }
      if(tmpGuScore>tmpInScore){
        guScore+=1;
      }else if(tmpGuScore<tmpInScore){
        inScore+=1;
      }
    }else{
      for(int i=0;i<18;i++){
        if(chk[i]==0){
          chk[i]=1;
          tmpInArr[cnt]=i+1;
          comb(cnt+1);
          chk[i]=0;
        }
      }
    }
  }
}