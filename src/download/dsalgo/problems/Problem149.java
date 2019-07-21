package download.dsalgo.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Given a set of reviews provided by the customers for different hotels and a
 * string containing “Good Words”, you need to sort the reviews in descending
 * order according to their “Goodness Value” (Higher goodness value first). We
 * define the “Goodness Value” of a string as the number of “Good Words” in that
 * string.
 * 
 * Note: Sorting should be stable. If review i and review j have the same
 * “Goodness Value” then their original order would be preserved.
 * 
 * You are expected to use Trie in an Interview for such problems
 * 
 * Constraints:
 * 
 * 1. 1 <= No.of reviews <= 200 2. 1 <= No. of words in a review <= 1000 3. 1 <=
 * Length of an individual review <= 10,000 4. 1 <= Number of Good Words <=
 * 10,000 5. 1 <= Length of an individual Good Word <= 4 6. All the alphabets
 * are lower case (a - z) Input:
 * 
 * S : A string S containing "Good Words" separated by "_" character. (See
 * example below) R : A vector of strings containing Hotel Reviews. Review
 * strings are also separated by "_" character. Output:
 * 
 * A vector V of integer which contain the original indexes of the reviews in
 * the sorted order of reviews.
 * 
 * V[i] = k means the review R[k] comes at i-th position in the sorted order.
 * (See example below) In simple words, V[i]=Original index of the review which
 * comes at i-th position in the sorted order. (Indexing is 0 based) Example:
 * 
 * Input: S = "cool_ice_wifi" R = ["water_is_cool", "cold_ice_drink",
 * "cool_wifi_speed"]
 * 
 * Output: ans = [2, 0, 1] Here, sorted reviews are ["cool_wifi_speed",
 * "water_is_cool", "cold_ice_drink"]
 * 
 * @author kaussark
 *
 */
public class Problem149 {

	public static void main(String[] args) {
		String good = "play_boy";
				// "qghu_eay_nl_dxfi_cvsc_gg_wk_nqdu_wf_fozv_rtk_pr_p_g_rp_rvys_mwcy_y_c_pev_kef_mz_imkk_svw_r_nzk_cxf_tl_gyp_fad_oo_fxz_co_juv_vabo_gpo_ylf_bnpl_vrvi_ya_yeh_q_qrqp_x_j_loov_o_u_wh_s_cb_coks_zkva_xdkn_yj_h_ixjs_nkk_f_ux_zr_bmnm_q_oke_ly_nk_aug_qrcd_iute_ojw_yyz_vs_m_sa_lfvg_b_aaov_zy_nt_kdcp_s_te_j_hdi_co_zc_fw_qi_tv_wvxh";
				//"cool_ice_wifi";
		String[] reviews = {"smart_guy", "girl_and_boy_play", "play_ground" };
//			{ "water_is_cool", "cold_ice_drink",
//				"cool_wifi_speed" };
		System.out.println(new Problem149().solve(good,
				new ArrayList<>(Arrays.asList(reviews))));
	}

	private static class TrieNode {

		Map<Character, TrieNode> children;
		boolean isWordEnd;

		public TrieNode() {
			this.children = new HashMap<>();
			this.isWordEnd = false;
		}

		public String toString() {
			return children.toString();
		}

	}

	public ArrayList<Integer> solve(String A, ArrayList<String> B) {

		TrieNode root = new TrieNode();
		SortedMap<Integer, List<Integer>> rankIndex = new TreeMap<>(
				(key1, key2) -> -key1.compareTo(key2));
		ArrayList<Integer> result = new ArrayList<>();

		// Add good words in Trie
		for (String word : A.split("_")) {
			insertIntoTrie(root, word);
		}

		// Search Good words in reviews
		for (int index = 0; index < B.size(); index++) {
			String review = B.get(index);
			int matches = search(root, review);
			List<Integer> numMatch = rankIndex.get(matches);
			if (numMatch == null) {
				numMatch = new ArrayList<>();
				numMatch.add(index);
				rankIndex.put(matches, numMatch);
			} else {
				rankIndex.get(matches).add(index);
			}
		}

		for (Map.Entry<Integer, List<Integer>> indexRankentry : rankIndex
				.entrySet()) {
			result.addAll(indexRankentry.getValue());
		}

		return result;
	}

	private void insertIntoTrie(TrieNode root, String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char character = word.charAt(i);
			TrieNode node = current.children.get(character);
			if (node == null) {
				node = new TrieNode();
				current.children.put(character, node);
			}
			current = node;
		}
		current.isWordEnd = true;
	}

	private int search(TrieNode root, String word) {
		TrieNode current = root;
		int matchNumber = 0;
		for (int i = 0; i < word.length(); i++) {
			char character = word.charAt(i);
			if (character != '_') {
				TrieNode node = current.children.get(character);
				if (node == null) {
					while (i < word.length() - 1 && character != '_') {
						i++;
						character = word.charAt(i);
						node = current.children.get(character);
					}
				} else {
					current = node;
				}
			}
			if (character == '_') {
				current = root;
			}
			if (current.isWordEnd) {
				matchNumber++;
			}
		}
		return matchNumber;
	}

	private static class IndexRank implements Comparable<IndexRank> {
		Integer index;
		Integer rank;

		public IndexRank(int index) {
			this.index = index;
			this.rank = 0;
		}

		@Override
		public int compareTo(IndexRank o) {
			int comp = -this.rank.compareTo(o.rank);
			if (comp == 0) {
				comp = this.index.compareTo(o.index);
			}
			return comp;
		}

		public String toString() {
			return "Index : " + index + " Rank : " + rank;
		}

	}

	public ArrayList<Integer> _solve(String A, ArrayList<String> B) {
		// Integer[] rank = new Integer[B.size()];
		List<IndexRank> indexRanks = new ArrayList<>();
		ArrayList<Integer> ranks = new ArrayList<>();

		for (int i = 0; i < B.size(); i++) {
			IndexRank currRank = new IndexRank(i);
			for (String word : A.split("_")) {
				if (B.get(i).contains(word)) {
					currRank.rank++;
				}
			}
			indexRanks.add(currRank);
		}

		Collections.sort(indexRanks);

		for (IndexRank rank : indexRanks) {
			ranks.add(rank.index);
		}

		return ranks;
	}
}
