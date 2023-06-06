
public class Caesar {

	String text = "";
	int stellen;

	char[] a = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
			'u', 'v', 'w', 'x', 'y', 'z' };

	public void encrypt(String input, int x) {
		x = x % 26;
		stellen = x;
		
		char[] enc = new char[a.length];

		for (int i = 0; i < a.length; i++) {
			enc[i] = a[(i + x) % a.length];
		}

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			int index = -1;
			if (Character.isLowerCase(c)) {
				index = c - 'a';
				if (index >= 0 && index < a.length) {
					text += enc[index];
				}
			} else {
				text += c;
			}
		}
	}

	public String decrypt() {
        String decryptedText = "";

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            int index = -1;
            if (Character.isLowerCase(c)) {
                index = findIndex(a, c);
                if (index >= 0 && index < a.length) {
                    decryptedText += a[(index - stellen + a.length) % a.length];
                }
            } else {
                decryptedText += c;
            }
        }

        return decryptedText;
    }

	public String getEncrypted() {
		return text;
	}
	
	private int findIndex(char[] arr, char c) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == c) {
				return i;
			}
		}
		return -1;
	}
}
