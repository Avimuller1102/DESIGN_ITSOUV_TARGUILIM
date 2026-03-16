import java.util.Random;
import java.util.Scanner;

public class SeasonUtilTest {
    static final int TOTAL = 8;
    static final int ANIMAL_MIN_INITIAL_WEIGHT = 200;
    static final int ANIMAL_MAX_INITIAL_WEIGHT = 250;
    static final int TREE_MIN_INITIAL_HEIGHT = 150;
    static final int TREE_MAX_INITIAL_HEIGHT = 200;
    static final Season INITIAL_SEASON = Season.FALL;
    static Random random;

    public static void main(String[] args) {
        System.out.println("Enter Seed: ");
        Scanner scanner = new Scanner(System.in);
        random = new Random(scanner.nextInt());

        Animal[] animals = initializeAnimals();
        Tree[] trees = initializeTrees();

        // build the paired array BEFORE sorting - we want animal[i] next to tree[i]
        // sorting later won't break the pairs since seasonables holds direct references
        Seasonable[] seasonables = new Seasonable[TOTAL * 2];
        for (int i = 0; i < TOTAL; i++) {
            seasonables[2 * i]     = animals[i];
            seasonables[2 * i + 1] = trees[i];
        }

        // show sorted snapshots before the season loop
        SeasonUtil.sortSeasonable(animals);
        System.out.println("\n---Sorting animals---");
        System.out.println(SeasonUtil.reportAll(animals));

        SeasonUtil.sortSeasonable(trees);
        System.out.println("\n---Sorting trees---");
        System.out.println(SeasonUtil.reportAll(trees));

        // original pairing - each caribou with its olive tree, each bear with its fig tree
        System.out.println("\n---All together---\n");
        System.out.println(SeasonUtil.reportAll(seasonables));

        // run through 6 full season changes and print state after each one
        System.out.println("\n---change six seasons for animals and trees---\n");
        for (int i = 0; i < 6; i++) {
            for (Seasonable seasonable : seasonables) {
                seasonable.changeSeason();
            }
            System.out.println("\n---All together after changing season---\n");
            System.out.println(SeasonUtil.reportAll(seasonables));
        }

        // final sorted views after all the season changes
        System.out.println("\n---Sorting animals after season change---\n");
        SeasonUtil.sortSeasonable(animals);
        System.out.println(SeasonUtil.reportAll(animals));

        System.out.println("\n---Sorting trees after season change---\n");
        SeasonUtil.sortSeasonable(trees);
        System.out.println(SeasonUtil.reportAll(trees));
    }

    // random int in [min, max)
    public static int rand(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Invalid range");
        }
        return random.nextInt(max - min) + min;
    }

    // first 4 are caribous, last 4 are bears - all start in FALL
    private static Animal[] initializeAnimals() {
        Animal[] animals = new Animal[TOTAL];
        for (int i = 0; i < TOTAL; i++) {
            if (i < 4)
                animals[i] = new Caribou(rand(ANIMAL_MIN_INITIAL_WEIGHT, ANIMAL_MAX_INITIAL_WEIGHT), INITIAL_SEASON);
            else
                animals[i] = new Bear(rand(ANIMAL_MIN_INITIAL_WEIGHT, ANIMAL_MAX_INITIAL_WEIGHT), INITIAL_SEASON);
        }
        return animals;
    }

    // first 4 are olive trees, last 4 are fig trees - all start in FALL
    private static Tree[] initializeTrees() {
        Tree[] trees = new Tree[TOTAL];
        for (int i = 0; i < TOTAL; i++) {
            if (i < 4)
                trees[i] = new OliveTree(rand(TREE_MIN_INITIAL_HEIGHT, TREE_MAX_INITIAL_HEIGHT), INITIAL_SEASON);
            else
                trees[i] = new FigTree(rand(TREE_MIN_INITIAL_HEIGHT, TREE_MAX_INITIAL_HEIGHT), INITIAL_SEASON);
        }
        return trees;
    }
}
