import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		long start = System.currentTimeMillis();
		for(int tc=0;tc<T;tc++) {
			HashMap<String, Integer> hmap = new HashMap<>();
			int n=Integer.parseInt(br.readLine());
			if(n==0) {
				sb.append("0\n");
				continue;
			}
			for(int i=0;i<n;i++) {
				st=new StringTokenizer(br.readLine());
				String name=st.nextToken();
				String type=st.nextToken();
				
				if(hmap.containsKey(type)) {
					int tmp=hmap.get(type)+1;
					hmap.put(type, tmp);
				}else {
					hmap.put(type, 1);
				}
			}
			int [] cntByType=new int[hmap.size()];
			int [] isSelected=new int[hmap.size()];
			
			int idx=0;
			for(Entry<String,Integer> e:hmap.entrySet()) {
				cntByType[idx++]=e.getValue()+1;
			}
			int res=1;
			for(int i=0;i<cntByType.length;i++) {
				res*=cntByType[i];
			}
			sb.append(res-1).append("\n");	
		}
		System.out.println(sb.toString());
	}
}
