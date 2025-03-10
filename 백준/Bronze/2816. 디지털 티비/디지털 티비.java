import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int size = Integer.parseInt(br.readLine());
		String[] channelList = new String[size];
		for(int idx=0; idx<size; idx++) {
			channelList[idx] = br.readLine();
		}

		for (int idx=0; idx<size; idx++) {
			if ("KBS1".equals(channelList[idx])) {
				for (int pointer=idx; pointer>0; pointer--) {
					String tmp = channelList[pointer];
					channelList[pointer] = channelList[pointer-1];
					channelList[pointer-1] = tmp;
					sb.append("4");
				}
				break;
			}
			sb.append("1");
		}

		for (int idx=0; idx<size; idx++) {
			if ("KBS2".equals(channelList[idx])) {
				for (int pointer=idx; pointer>1; pointer--) {
					String tmp = channelList[pointer];
					channelList[pointer] = channelList[pointer-1];
					channelList[pointer-1] = tmp;
					sb.append("4");
				}
				break;
			}
			sb.append("1");
		}

		System.out.print(sb);
	}
}