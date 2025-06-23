import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int plugCnt = Integer.parseInt(st.nextToken());
		int deviceCnt = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		List<Integer> seq = new ArrayList<>();
		for (int idx=0; idx<deviceCnt; idx++) {
			seq.add(Integer.parseInt(st.nextToken()));
		}

		Set<Integer> set = new HashSet<>();

		int result = 0;
		for (int idx=0; idx<deviceCnt; idx++) {
			int deviceNum = seq.get(idx);
			if (set.contains(deviceNum)) continue;
			if (set.size() < plugCnt) {
				set.add(deviceNum);
				continue;
			}

			int maxSeq = -1, maxDeviceNum = -1;
			for (int pluggedDeviceNum : set) {
				List<Integer> subSeq = seq.subList(idx+1, deviceCnt);
				int subSeqIdx = subSeq.indexOf(pluggedDeviceNum);
				if (subSeqIdx == -1) {
					maxDeviceNum = pluggedDeviceNum;
					break;
				}
				if (maxSeq < subSeqIdx) {
					maxSeq = subSeqIdx;
					maxDeviceNum = pluggedDeviceNum;
				}
			}

			set.remove(maxDeviceNum);
			set.add(deviceNum);
			result++;
		}

		System.out.println(result);
	}
}