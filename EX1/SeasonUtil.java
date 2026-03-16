import java.util.Arrays;

public class SeasonUtil {

    public static void sortSeasonable(Comparable[] seasonables) {
        Arrays.sort(seasonables);
    }
    
    public static void sort(Comparable[] comparable) {
        Arrays.sort(comparable);
    }

    static String reportAll(Seasonable[] seasonables) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < seasonables.length; i++) {
            sb.append(seasonables[i].toString());
            if (i < seasonables.length - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
