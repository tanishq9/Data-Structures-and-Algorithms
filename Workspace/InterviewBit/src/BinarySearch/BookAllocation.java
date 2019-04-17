package BinarySearch;

public class BookAllocation {

	public static void main(String[] args) {
		int students = 2;
		int[] books = { 10, 20, 30, 40 };
		System.out.println(bs(books, books.length, students));
	}

	static int bs(int[] books, int num_books, int num_students) {
		int min = books[0];
		int max = 0;
		for (int i = 0; i < books.length; i++) {
			max += books[i];
			min = Math.min(min, books[i]);
		}
		int mid = (min + max) / 2;
		int s = min, e = max;
		int ans = -1;
		while (s <= e) { // Till start doesn't overshoot end
			System.out.println(mid);
			mid =(s+e)/2;
			if (isValid(books, num_books, num_students, mid)) {
				e = mid -1;
				ans = mid;
			} else {
				s = mid + 1;
			}
		}
		return ans;
	}

	private static boolean isValid(int[] books, int num_books, int num_students, int mid) {
		int current_Pages = 0, current_students = 1;
		for (int i = 0; i < num_books; i++) {
			if (current_Pages + books[i] > mid) {
				current_students += 1;
				if (current_students > num_students) {
					return false;
				}
				current_Pages = books[i];
			} else {
				current_Pages += books[i];
			}
		}
		return true;
	}

}
