import java.util.Scanner;

public class Solution_1208_염진호 {
	public static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			arr=new int[100];
			int dump=sc.nextInt();
			for(int i=0;i<100;i++) {
				arr[i]=sc.nextInt();
			}
			System.out.print("#"+test_case+" ");
			System.out.println(solve(dump));
		}
	}
	public static int solve(int count) {
		int max=0;
		int min=101;
		int maxIndex=-1;
		int minIndex=-1;
		while(count>0) {
			for(int i=0;i<100;i++) {
				if(arr[i]>max) {
					max=arr[i];
					maxIndex=i;
				}
				if(arr[i]<min) {
					min=arr[i];
					minIndex=i;
				}
			}
			if(max-min<=1) {
				break;
			}
			arr[maxIndex]-=1;
			arr[minIndex]+=1;
//			System.out.println("min index"+minIndex+" val :"+arr[minIndex]+" max index"+maxIndex+" val :"+arr[maxIndex]);
			count--;
			max=0;
			min=101;
			maxIndex=-1;
			minIndex=-1;
		}
		for(int i=0;i<100;i++) {
			if(arr[i]>max) {
				max=arr[i];
				maxIndex=i;
			}
			if(arr[i]<min) {
				min=arr[i];
				minIndex=i;
			}
		}
		return arr[maxIndex]-arr[minIndex];
	}
}
