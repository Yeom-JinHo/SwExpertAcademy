import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_2309_염진호 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr= new int[9];
		for(int i =0; i<9;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		for(int j=0;j<9;j++) {
			for(int k=j+1;k<9;k++) {
				if(Arrays.stream(arr).sum()-arr[j]-arr[k]==100) {
					arr[j]=0;
					arr[k]=0;
					Arrays.sort(arr);
					for(int a :arr) {
						if(a!=0){
							System.out.println(a);
						}
					}
				}
			}
		}
	}
}
