package Strings;

public class palindromicAnagram {
	static String gameOfThrones(String s) {
		int[] countArr = new int[26];
		for (int i = 0; i < s.length(); i++) {
			countArr[(int) s.charAt(i) - 97]++;
		}
		int count = 0;
		for (int i = 0; i < countArr.length; i++) {
			System.out.print(countArr[i] + " ");
			if (countArr[i] % 2 == 1) {
				count++;
			}
		}
		if (count > 1) {
			return "NO";
		}
		return "YES";
	}

	public static void main(String[] args) {
		System.out.println(gameOfThrones(
				"jzrvgnywrcihhmrsdwywuuevbsygjejufdrlqpjjssqbejvjgwiaqmytgwbralmfqdqivarpsiqyrnjzlrcdfaxlyydzlrgbwzjrbbgvlyteoeezwgddgapeyufmnonjnzboajjnierwivvgbakjabqbxvnkjctybwmdgxqodimofhwhiiskjilggasrfmqiiemoeeejoqxuaudievuogiwmkpdpdvyncmcgqipfzpzzlejpzfffnetyvznyunlwzpesywxzlyywcjndotjcxecsdpsyfdwevdwtzvsmvskzdxdrqovpsxjwpbwuhuacxzxywrmsjwrouwfmmdefapdrrznavoevpdtlugdfextavapidtpgiszbtndqdjlsmhdgpjntgiudjjloecuouuspjxgmhtetajcpsrjaafelqrzwuwkqqeibcqnjjtemcgbxymxatdljvkfrgshyypzaholrjqdoyglwtkymojylufccxjdybcaitmbceeqcldbgozuejspfyrhxckvdpwmkkpmoufqhirpytjcccrjcksznfxquteedustqzjzidoiwzlabejfpbfcgeuczbiexdxnciomlcvjbijfmumdythgxcjwdtaayxpbgdpthkdkuorhjemhxunvwytbuwdstuvbzlxgxassombzqniphwmfwgiqcnjxhgbiryqpajjqvksnzacjwrqvzzldowayddgwdxnfiwyfgqsiqwrpphkoixrxwuxzxdxdclikhgrqwlypirgzaqojpfilzfmzkkcpxmzettwrewionooogczwhjhjqwiaimpfyrjtkiloetduktiqvjmeswniuxkclchkvsdhaqxhmcbwvlmqubvozkytikvvmcfjwlqzbognqhlmuyeqbzeamctwoqrbuxkqidplrxzjgkvakaqnbwpnaijpabquaclifctyauiihfjthbjjyyyyhinjldelirvptqovnyeudpplqy"));
	}

}
