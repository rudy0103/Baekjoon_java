package sk2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Process {

		int type;
		int start;
		int end;
		int startIdx;
		int endIdx;
		String value;

		public Process(int type, int start, int end, int startIdx, int endIdx) {
			this.type = type;
			this.start = start;
			this.end = end;
			this.startIdx = startIdx;
			this.endIdx = endIdx;
		}

		public Process(int type, int start, int end, int startIdx, int endIdx, String value) {
			this.type = type;
			this.start = start;
			this.end = end;
			this.startIdx = startIdx;
			this.endIdx = endIdx;
			this.value = value;
		}

		public String read(String[] arr) {
			StringBuilder sb = new StringBuilder();
			for (int i = this.startIdx; i <= endIdx; i++) {
				sb.append(arr[i]);
			}
			return sb.toString();
		}

		public void write(String[] arr) {
			for (int i = startIdx; i <= endIdx; i++) {
				arr[i] = this.value;
			}
		}

	}

	public static void main(String[] args) {

		String[] arr = { "1","1","1","1","1","1","1"};
		String[] processes = { "write 1 12 1 5 8","read 2 3 0 2","read 5 5 1 2","read 7 5 2 5","write 13 4 0 1 3","write 19 3 3 5 5","read 30 4 0 6","read 32 3 1 5" };

		System.out.println(Arrays.toString(solution(arr, processes)));

	}

	public static String[] solution(String[] arr, String[] processes) {
		int readCnt = 1;
		int useTime = 0;
		int currTime = 0;
		int endTimeCurrProcess = -1;
		char currState = 'e';

		ArrayDeque<String> res = new ArrayDeque<>();

		ArrayDeque<Process> job = new ArrayDeque<>();
		PriorityQueue<Process> waitQ = new PriorityQueue<>(new Comparator<Process>() {
			@Override // 쓰기1>읽기2
			public int compare(Process o1, Process o2) {
				if (o1.type != o2.type) {
					return o1.type - o2.type;
				} else
					return o1.start - o2.start;
			}
		});
//		-------------------------------------------------------------------------
		StringTokenizer st = null;
		for (int i = 0; i < processes.length; i++) {
			st = new StringTokenizer(processes[i]);
			int type = 0;
			String tmpType = st.nextToken();
			if (tmpType.contains("read"))
				type = 2;
			else
				type = 1;
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int startIdx = Integer.parseInt(st.nextToken());
			int endIdx = Integer.parseInt(st.nextToken());
			if (type == 1) {
				String value = st.nextToken();
				Process process = new Process(type, start, end, startIdx, endIdx, value);
				job.add(process);
			} else {
				Process process = new Process(type, start, end, startIdx, endIdx);
				job.add(process);
			}
		}
		// --------------------------------------------------------------------------
		// 시간마다 잡큐에서 뺄수 있는거 빼고(요청 시간이 다 다름)
		// 작업을 수행 할 수 있으면 하고 수행 못하면 대기

		while (!(job.isEmpty() && waitQ.isEmpty())) {
			
			currTime++;

			if (currTime >= endTimeCurrProcess) {
				currState = 'e';
			}
			

			while (!job.isEmpty()&&job.peek().start <= currTime) {
				waitQ.add(job.poll());
			}

			while (!waitQ.isEmpty()) {
				

				if (currState == 'e') {
					Process process = waitQ.poll();
					int type = process.type;
					if (type == 2) {// 읽기
						currState = 'r';
						endTimeCurrProcess = Math.max(endTimeCurrProcess, currTime + process.end);
						res.add(process.read(arr));
						readCnt++;
					} else {
						currState = 'w';
						endTimeCurrProcess = Math.max(endTimeCurrProcess, currTime + process.end);
						process.write(arr);
					}
				} else if (currState == 'r') {
					while (!waitQ.isEmpty() && waitQ.peek().type == 2) {
						Process process = waitQ.poll();
						readCnt++;
						endTimeCurrProcess = Math.max(endTimeCurrProcess, currTime + process.end);
						res.add(process.read(arr));
					}
					break;
				} else {
					break;
				}
			}
			
			if (currState != 'e') {
				useTime++;
			}

		}
		if(endTimeCurrProcess>currTime) useTime+=endTimeCurrProcess-currTime-1;
//		---------------------------------------------------------------------
		// 최종 사용 작업을 더하고 결과 배열 만들어서 리턴
		res.add(String.valueOf(useTime));
		String[] answer = new String[readCnt];
		int idx = 0;
		while (!res.isEmpty())
			answer[idx++] = res.poll();

		return answer;
	}

}
