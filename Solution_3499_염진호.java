import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_3499_염진호 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] arr;
		StringBuilder sb;
		int t = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=t;tc++) {
			int l = Integer.parseInt(br.readLine());
			arr=new String[l];
			sb= new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<l;j++) {
				arr[j]=st.nextToken();
			}
			sb.append("#").append(tc);
			for(int k=0;k<l/2;k++) {
				sb.append(' ').append(arr[k]).append(' ').append(arr[k+(int)Math.ceil(1.0*l/2)]);
			}
			if(l%2!=0) {
				sb.append(' ').append(arr[l/2]);
			}
			bw.write(sb.toString());
			bw.write("\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}

}
