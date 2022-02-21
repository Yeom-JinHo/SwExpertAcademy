import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1233_염진호 {
	static String[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb= new StringBuilder();
		for(int tc=1;tc<=10;tc++) {
			int n=Integer.parseInt(br.readLine());
			arr=new String[n+1];
			int result=1;
			for(int j=1;j<=n;j++) {
				st=new StringTokenizer(br.readLine());
				st.nextToken();
				String value=st.nextToken();
				// 없어도 되는 부분  
				if(result==0) {
					continue;
				}
				// 리프노드가 아닌데 숫자다? fail	
				if(st.hasMoreTokens()) {
					if(value.matches("[0-9]+")){
						result=0;
					}
				}else {// 리프노든데 연산자다? fail
					if(value.matches("[-*+/]")) {
						result=0;
					}
				}
			}
			sb.append("#"+tc+" "+result+"\n");
		}
		System.out.println(sb);
		br.close();
	}
}
