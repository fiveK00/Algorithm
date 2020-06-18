package lcp;

public class Q14 {
    public static int splitArray(int[] array) {
        if (array == null) return 0;
        if (array.length < 2) return array.length;

        int[] minLenSplit = new int[array.length];
        minLenSplit[0] = 1;
        for (int i = 1; i < minLenSplit.length; i++) {
            minLenSplit[i] = minLenSplit[i - 1];
            for (int j = 0; j < i; j++) {
                if (true && minLenSplit[i - 1] + 1 < minLenSplit[i]) {
                    minLenSplit[i] = minLenSplit[j - 1] + 1;
                    break;
                }
            }
        }
        return minLenSplit[minLenSplit.length - 1];
    }
}
