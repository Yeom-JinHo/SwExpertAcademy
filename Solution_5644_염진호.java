import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;
// 문제가 복잡하다 설계 먼저.
    /* 체크리스트
      1. BC에 두명의 사용자가 접근할 떄 최댓값 찾기. << 까다로울듯
      2. 0초부터 충전 할 수 있또록 V
      3. A,B 위치 관계성 없다 V
      4. 인덱스가 xy이다 주의! V
      r,c 로 보고 배열 재구성
    */

    /*  1번째 접근
      BC를 어떻게 할꺼냐? DFS로 배열로 카운트 or 매번 계산
      DFS 배열로 하면 겹치는 값 계산이 어려울듯

      매번 계산으로<<

      매번 계산으로 하고  BC는 최대 8개니 BC의 좌표를 담는 배열 만들기

      A,B 동시에 이동!

      그리고 계속해서 이동-- 4방 ( 멈추기도 가능 )
    */ 
//

class Solution_5644_염진호{
  static int M,A;
  static int[] dr={0,-1,0,1,0};// 멈춤, 상 우 하 좌
  static int[] dc={0,0,1,0,-1};// 멈춤, 상 우 하 좌
  static int[] aCommands,bCommands;// a,b 입력 이동좌표
  static int[][] apIndex; // Ap 좌표  [r,c]
  static int[] apPower,apLen;// Ap 파워, ap 도달 길이
  static int result; // 결과값이 숫자하나지만 디버깅을 위해서 배열로 할당<< 차후 바꾸자
  static int[] possibleA,possibleB; // 가능한 Ap 값
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    // 입력
    int T =Integer.parseInt(st.nextToken());
    for(int tc=1;tc<=T;tc++){
      st=new StringTokenizer(br.readLine());
      M=Integer.parseInt(st.nextToken());
      A=Integer.parseInt(st.nextToken());

      aCommands=new int[M];// A 이동경로
      bCommands=new int[M];// B 이동경로
      // A 입력
      st=new StringTokenizer(br.readLine());
      for(int i=0;i<M;i++){
        aCommands[i]=Integer.parseInt(st.nextToken());
      }
      // B 입력
      st=new StringTokenizer(br.readLine());
      for(int i=0;i<M;i++){
        bCommands[i]=Integer.parseInt(st.nextToken());
      }
      apIndex=new int[A][2];
      apPower=new int[A+1]; // power 계산부분에서 쓰레기값 0을 주기 위해 A+1
      apLen=new int[A];
      possibleA=new int[A];
      possibleB=new int[A];
      // Ap 입력
      for(int i=0;i<A;i++){
        st=new StringTokenizer(br.readLine());
        int apC=Integer.parseInt(st.nextToken())-1;//인덱스 주의!
        int apR=Integer.parseInt(st.nextToken())-1;//!!!
        apIndex[i][0]=apR;
        apIndex[i][1]=apC;
        apLen[i]=Integer.parseInt(st.nextToken());
        apPower[i]=Integer.parseInt(st.nextToken());
      }
      result=0;
      move(0,0,9,9,0);
      bw.write("#"+tc+" "+result+"\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }
  static void findPossibleAp(int sr,int sc,int[] possibleList){
    for(int a=0;a<A;a++){
      int apR=apIndex[a][0];
      int apC=apIndex[a][1];
      int len=Math.abs(apR-sr)+Math.abs(apC-sc);
      if(len<=apLen[a]){
        possibleList[a]=a;
      }else{
        possibleList[a]=A; // 쓰레기값 0
      }
    }
  }
  /*
    @param asr,asc : a의 시작 좌표
    @parma bsr,bsc : b의 시작 좌표
  */
  // 이동하기 전에 충전해야함 !! <<< 중요
  static void move(int asr,int asc,int bsr,int bsc,int cnt){
    //ap를 다 돌면서 할당 할 수 있는 ap 계산
    int maxPower=0;
    // 이중 포문 << 조금 비효율적인거 같은데 공간복잡도생각하면 시간으로 떼우자
    // A에 할당된 ap찾고 다시 B에 할당된 ap 
    findPossibleAp(asr, asc, possibleA);
    findPossibleAp(bsr, bsc, possibleB);

    // 이 부분 더 효율적인 방법이 있을꺼 같은데 
    // 생각이 안나네용
    for(int a=0;a<A;a++){
      for(int b=0;b<A;b++){
        // a,b 를 돈다 a,b에 할당된 ap가 같다면! 즉 apIndex값이 쓰레기 값이 아니라면!!
        // 둘이 겹칠경우
        if(a==b && possibleA[a]!=A && possibleB[b]!=A){
          maxPower=Math.max(maxPower,apPower[possibleA[a]]);
        }else{// ap가 둘이 안겹칠 경우
          maxPower=Math.max(maxPower,apPower[possibleA[a]]+apPower[possibleB[b]]);
        }
      }
    }
    result+=maxPower;
    if(cnt==M)
        return;
    // 밖으로 나가는 경우는 없으므로 다음만 돌자
    move(asr+dr[aCommands[cnt]],asc+dc[aCommands[cnt]],bsr+dr[bCommands[cnt]],bsc+dc[bCommands[cnt]],cnt+1);
  }
}