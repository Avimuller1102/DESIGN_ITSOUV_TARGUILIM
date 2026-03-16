import java.util.Arrays;

public class SeasonUtil {
    public static final Season[] SEASONS = Season.values();

    public static void sortSeasonable(Comparable[] seasonables) {
        Arrays.sort(seasonables);
    }
    
    // Also include sort as requested in PDF, though sortSeasonable is tested.
    public static void sort(Comparable[] comparable) {
        Arrays.sort(comparable);
    }

    static String reportAll(Seasonable[] seasonables) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < seasonables.length; i++) {
            sb.append(seasonables[i].toString());
            // No trailing newline so it matches print logic perfectly
            if (i < seasonables.length - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
