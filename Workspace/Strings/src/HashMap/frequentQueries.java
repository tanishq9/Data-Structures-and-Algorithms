package HashMap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class frequentQueries {
	// Complete the freqQuery function below.
	static List<Integer> freqQuery(List<List<Integer>> queries) {
		HashMap<Integer, Integer> map = new HashMap<>();
		ArrayList<Integer> list = new ArrayList<>();
		Boolean flag = false;
		for (int i = 0; i < queries.size(); i++) {
			int decide = queries.get(i).get(0);
			int element = queries.get(i).get(1);
			if (decide == 1) {
				if (map.containsKey(element)) {
					map.put(element, map.get(element) + 1);
				} else {
					map.put(element, 1);
				}
			} else if (decide == 2) {
				if (map.containsKey(element)) {
					map.remove(element, map.get(element));
				}
			} else if (decide == 3) {
				Set<Integer> set = map.keySet();
				flag = false;
				for (Integer k : set) {
					if (map.get(k) == 1) {
						flag = true;
						break;
					}
				}
				if (flag == true) {
					list.add(1);
				} else {
					list.add(0);
				}

			}
		}
		return list;
	}

	public static void main(String[] args) {
	/*	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int q = Integer.parseInt(bufferedReader.readLine().trim());

		List<List<Integer>> queries = new ArrayList<>();

		IntStream.range(0, q).forEach(i -> {
			try {
				queries.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
						.map(Integer::parseInt).collect(toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		List<Integer> ans = freqQuery(queries);

		bufferedWriter.write(ans.stream().map(Object::toString).collect(joining("\n")) + "\n");

		bufferedReader.close();
		bufferedWriter.close();*/
	}
}
