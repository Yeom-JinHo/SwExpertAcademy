import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_1228_염진호 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int tc=1;tc<=10;tc++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			ArrayList<Integer> arr = new ArrayList<Integer>();
			for(int i=0;i<n;i++) {
				arr.add(Integer.parseInt(st.nextToken()));
			}
			n=Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				st.nextToken();
				int index=Integer.parseInt(st.nextToken());
				int len=Integer.parseInt(st.nextToken());
				for(int k=0;k<len;k++) {
					arr.add(index+k,Integer.parseInt(st.nextToken()));
				}
			}
			bw.write("#"+tc+" ");
			for(int j=0;j<10;j++) {
				bw.write(arr.get(j)+" ");
			}
		}
		bw.flush();
		br.close();
		bw.close();
	}

}
