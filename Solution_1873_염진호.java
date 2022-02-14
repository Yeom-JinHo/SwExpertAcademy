import java.util.Scanner;

public class Solution_1873_염진호 {
	public static char[][] map;
	public static char[] tankLook= {'^','v','<','>'};
	public static char[] movCommands= {'U','D','L','R'};
	public static int[] dr= {-1,1,0,0};
	public static int[] dc= {0,0,-1,1};
	public static void main(String args[]) throws Exception
	{	
		Scanner sc = new Scanner(System.in);
		int T,H,W;
		int startR,startC;
		String commands;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{	
			H=sc.nextInt();
			W=sc.nextInt();
			startR=0;
			startC=0;
			map=new char[H][W];
			sc.nextLine();
			for(int r=0;r<H;r++) {
				String line=sc.nextLine();
				for(int c=0;c<line.length();c++) {
					map[r][c]=line.charAt(c);
					// 미리 시작점이 어딘지 파악  
					for(char dir:tankLook) {
						if(map[r][c]==dir) {
							startR=r;
							startC=c;
							break;
						}
					}
				}
			}
//			int commandLen=sc.nextInt();
			sc.nextLine();  // command 길이 보관할 필요 X
			commands=sc.nextLine();
			gameStart(startR,startC,commands);
			System.out.print("#"+test_case+" ");
			printMap();
		}
	}
	public static void gameStart(int sr,int sc,String commands) {
		int r=sr;
		int c=sc;
		
		for(int i=0;i<commands.length();i++) {
			char command=commands.charAt(i);
			int tr;
			int tc;
			switch(command) {
				case 'S':
					int shotDir=-1;
					// shot 방향 지정 
					for(int j=0;j<tankLook.length;j++) {
						if(tankLook[j]==map[r][c]) {
							shotDir=j;
							break;
						}
					}

					tr=r;
					tc=c;
					
					while(true) {
						tr=tr+dr[shotDir];
						tc=tc+dc[shotDir];
						if(tr>=0 && tc>=0 && tr<map.length && tc<map[0].length) {
							if(map[tr][tc]=='#')
								break;
							if(map[tr][tc]=='*') {
								map[tr][tc]='.';
								break;
							}
						}else {
							break;
						}
					}
					break;
					
				case 'U':
				case 'D':
				case 'R':
				case 'L':
					int movDir=-1;
					for(int j=0;j<movCommands.length;j++) {
						if(movCommands[j]==command) {
							movDir=j;
							break;
						}
					}
					tr=r+dr[movDir];
					tc=c+dc[movDir];
					if(tr>=0 && tc>=0 && tr<map.length && tc<map[0].length) {
						if(map[tr][tc]=='.') {
							map[r][c]='.';
							r=tr;
							c=tc;
						}
					}
					map[r][c]=tankLook[movDir];
					break;
				
			
			}
//			System.out.println("--"+command+"실행 "+"now r "+r+" c "+c);
//			printMap();
//			System.out.println();
		}
		
	}
	public static void printMap() {
		for(int r=0;r<map.length;r++) {
			for(int c=0;c<map[r].length;c++ ) {
				System.out.print(map[r][c]);
			}
			System.out.println();
		}
	}

}
