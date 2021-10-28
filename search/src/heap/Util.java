package heap;

public class Util {
	private static Runtime rt = Runtime.getRuntime();
	
	public static long printHeap(int idx) {
		rt.gc();
		
		long t= rt.totalMemory();
		long f = rt.freeMemory();
		long u=t-f;
		u/=1024;
		
		System.out.println(String.format("%d HEAP:%,8d Kbytes", idx,u));
		return u;
	}

}
