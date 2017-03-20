package src.Algorithm;

public class KMP {
    public static int kmp(String mainstr, String str) {
        int[] next = getNextArray(str);
        char[] mainStrArray = mainstr.toCharArray();
        char[] strArray = str.toCharArray();
        int i = 0, j = 0;
        while (i < mainstr.length()) {
            if (j == strArray.length) {
                return i - j;
            }
            if (strArray[j] == mainStrArray[i]) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = next[j - 1];
                }
            }
        }
        if (j == strArray.length) {
            return i - j;
        }
        return -1;
    }

    private static int[] getNextArray(String str) {
        int[] next = new int[str.length()];
        next[0] = 0;
        char[] strArray = str.toCharArray();
        int i = 0, j = 1;
        while (j < str.length()) {
            if (strArray[i] == strArray[j]) {
                next[j++] = i + 1;
                i++;
            } else {
                if (i == 0) {
                    next[j++] = 0;
                } else {
                    i = next[i - 1];
                }
            }
        }
        return next;
    }

}
