package b15686_치킨배달;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
	
	static int [] selected;
	static int n,m;
	static int min=Integer.MAX_VALUE;
	
	static ArrayList<int[]> houseList= new ArrayList<>(); //집의 위치를 저장하는 list
	static ArrayList<int[]> chikenList = new ArrayList<>(); // 치킨 집의 위치를 저장하는 list
	
	static void getDistance(int [] list) {
		
		int [] minDistance=new int[houseList.size()];
		
		for(int i=0;i<houseList.size();i++) { //집마다 치킨집과 거리가 최소가 되는 거리를 구함
			for(int j=0;j<list.length;j++) {
				int distance=Math.abs(houseList.get(i)[0]-chikenList.get(list[j])[0])+
						Math.abs(houseList.get(i)[1]-chikenList.get(list[j])[1]);
				if(minDistance[i]==0) {
					minDistance[i]=distance;
				}else if(minDistance[i]==1) break; //거리가 1이면 더이상 진행할 필요가 없음
				else {
					minDistance[i]=distance<minDistance[i]?distance:minDistance[i];
				}
			}
		}
		int distanceSum=0;
		for(int i=0;i<minDistance.length;i++) {
			distanceSum+=minDistance[i]; //각 집마다의 치킨거리를 더해  도시의 치킨거리 구함
		}
		min=distanceSum<min?distanceSum:min; //최소가 되는 도시의 치킨거리를 갱신
	}
	
	static void makeCombination(int cnt, int start) {
		if(cnt==m) {
			getDistance(selected); //M개를 뽑았으면 getDistance함수를 호출
		}else {
			for(int i=start;i<chikenList.size();i++) {
				selected[cnt]=i;
				makeCombination(cnt+1, i+1);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String [] inp=br.readLine().split(" ");
		n= Integer.parseInt(inp[0]);
		m= Integer.parseInt(inp[1]);
		selected = new int[m];  //M개의 치킨집의 순서를 저장하는 배열 
		int [][]map = new int[n][n];
		for(int i=0;i<n;i++) {
			inp=br.readLine().split(" ");
			for(int j=0;j<n;j++) {
				map[i][j]=Integer.parseInt(inp[j]);
				if(map[i][j]==1) houseList.add(new int[] {i,j}); //집이면 
				if(map[i][j]==2) chikenList.add(new int[] {i,j});// 치킨집이면
			}
		}
		makeCombination(0,0); //M개를 뽑는 조합
		bw.write(min+"");
		bw.close();
	}
}
