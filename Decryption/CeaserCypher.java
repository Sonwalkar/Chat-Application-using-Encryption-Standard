package Decryption;

public class CeaserCypher {
    // Encrypts text using a shift od s
    public static StringBuffer decrypt(String text) {
        int s = 5;
        byte ctoi[];
        int check;
        StringBuffer result = new StringBuffer();
        ctoi = text.getBytes();
        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                check = 0;
                check = ((ctoi[i] - s) - 65) % 26;
                if (check < 0) {
                    char ch = (char) ((((((int) text.charAt(i) - s) - 65) % 26) + 65) + 26);
                    result.append(ch);
                } else {
                    char ch = (char) (((((int) text.charAt(i) - s) - 65) % 26) + 65);
                    result.append(ch);
                }

            } else if (Character.isLowerCase(text.charAt(i))) {
                check = 0;
                check = ((ctoi[i] - s) - 97) % 26;
                if (check < 0) {
                    char ch = (char) ((((((int) text.charAt(i) - s) - 97) % 26) + 97) + 26);
                    result.append(ch);
                } else {
                    char ch = (char) (((((int) text.charAt(i) - s) - 97) % 26) + 97);
                    result.append(ch);
                }

            } else {
                char ch = text.charAt(i);
                result.append(ch);
            }
        }
        return result;
    }
}
