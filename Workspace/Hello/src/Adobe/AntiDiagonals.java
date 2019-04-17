package Adobe;

import java.util.ArrayList;

public class AntiDiagonals {
	public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
		int num_layers = A.size();
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < 2 * num_layers - 1; i++) {
			res.add(getIthLayerList(A, i));
		}
		return res;
	}

	public ArrayList<Integer> getIthLayerList(ArrayList<ArrayList<Integer>> list, int layer) {
		ArrayList<Integer> layerList = new ArrayList<>();
		for (int i = 0; i <= layer; i++) {
			int j = layer - i;
			if (i < list.size() && j < list.size()) {
				layerList.add(list.get(i).get(j));
			}
		}
		return layerList;
	}
}
