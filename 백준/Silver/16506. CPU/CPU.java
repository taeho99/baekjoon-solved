import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static HashMap<String, String> map = new HashMap<>();
	public static void main(String[] args) throws IOException {
		mapInit();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int size = Integer.parseInt(br.readLine());
		while(size-- > 0) {
			st = new StringTokenizer(br.readLine());
			String opCode = map.get(st.nextToken()) + "0";
			String rD = formatNumber("%03d", st.nextToken());
			String rA = formatNumber("%03d", st.nextToken());
			String rB = formatNumber(opCode.endsWith("10") ? "%04d" : "%03d", st.nextToken());;

			sb.append(opCode).append(rD).append(rA).append(rB);
			if (rB.length() == 3) sb.append('0');
			sb.append('\n');
		}
		System.out.print(sb);
	}

	static String formatNumber(String format, String input) {
		return String.format(format, Integer.parseInt(Integer.toBinaryString(Integer.parseInt(input))));
	}

	static void mapInit() {
		map.put("ADD", "00000"); map.put("ADDC", "00001");
		map.put("SUB", "00010"); map.put("SUBC", "00011");
		map.put("MOV", "00100"); map.put("MOVC", "00101");
		map.put("AND", "00110"); map.put("ANDC", "00111");
		map.put("OR", "01000"); map.put("ORC", "01001");
		map.put("NOT", "01010");
		map.put("MULT", "01100"); map.put("MULTC", "01101");
		map.put("LSFTL", "01110"); map.put("LSFTLC", "01111");
		map.put("LSFTR", "10000"); map.put("LSFTRC", "10001");
		map.put("ASFTR", "10010"); map.put("ASFTRC", "10011");
		map.put("RL", "10100"); map.put("RLC", "10101");
		map.put("RR", "10110"); map.put("RRC", "10111");
	}
}
