import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1225_염진호 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Queue<Integer> que =new LinkedList<Integer>();
		for(int tc=1;tc<=10;tc++) {
			br.readLine();
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int i=0;i<8;i++) {
				que.add(Integer.parseInt(st.nextToken()));
			}
			int count=1;
			while(true) {
				int tmp=que.poll()-count;
				if(tmp<=0) {
					que.add(0);
					break;
				}
				que.add(tmp);
				count+=1;
				if(count==6) {
					count=1;
				}
			}
			bw.write("#"+tc+" ");
			while(!que.isEmpty()) {
				bw.write(que.poll()+" ");
			}
			bw.write("\n");
		}
		que.clear();
		bw.flush();
		bw.close();
		br.close();
		
	}

}
