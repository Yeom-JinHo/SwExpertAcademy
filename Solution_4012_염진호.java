import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Solution_4012_염진호{
  static int N;
  static int[][] table;
  static int[] source,tmp;
  static boolean[] chk;
  static LinkedList<int[]> alist,blist;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    // int T=Integer.parseInt(st.nextToken());

    // for(int tc=1;tc<T;t++){
      
    // }
    //st=new StringTonkenizer(br.readline());
    N=Intger.parseInt(st.nextToken());
    table=new int[N][N];
    // 조합표 셋
    for(int i =0;i<N;i++){
      st=new StringTokenizer(br.readLine());
      for(int j=0;i<N;j++){
        table[i][j]=Integer.parseInt(st.nextToken());
      }
    }
    // 식재료 셋
    source=new int[N];
    tmp=new int[N];
    chk=new int[N];
    alist=new LinkedList<>();
    blist=new LinkedList<>();
    for(int i=0;i<N;i++){
      source[i]=i;
    }
    comb(0,0);

    bw.flush();
    bw.close();
    br.close();
  }
  static void per(int[] source,int count,int type){
    if(count==2){
      if(type==0){
        alist.add(tmp.clone());
      }else{
        blist.add(tmp.clone());
      }
    }else{
      for(int i=0;i<source.length;i++){
        if(!chk[i]){
          chk[i]=true;
          tmp[count]=source[i];
          per(source,count+1);
          chk[i]=false;
        }
      }
    }
    
  }
  static void cooking(int[] aSource,int[] bSource){
    per(aSoure,0,0);
    per(bSoure,0,1);
    for(int i=0;aPer.length;i++){
      System.out.printf("al i %d j %d, bl i %d j %d\n",alist.get(i)[0],alist.get(i)[1],blist.get(i)[0],blist.get(i)[1]);
    }
  }
  static void comb(int count,int start){
    if(count==N/2){
      boolean[] chk = new int[N/2];
      for(int t :tmp){
        chk[t]=true;
      }
      int[] aSource= new int[N/2];
      int[] bSource= new int[N/2];
      int aC=0;
      int bc=0;
      for(int i=0;i<N;i++){
        if(tmp[i]){
          aSource[aC]=tmp[i];
          aC++;
        }else{
          bSource[bC]=tmp[i];
          bC++;
        }
      }
      cooking(aSoure,bSource);
    }else{
      for(int i=start;i<N;i++){
        tmp[count]=source[i];
        comb(count+1,i+1);
      }
    }
  }
}
