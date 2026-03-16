public abstract class Tree implements Comparable, Seasonable {
    protected int height;
    protected Season season;
    protected Color leavesColor;

    Tree(int height, Season season, Color leavesColor) {
        this.height = height;
        this.season = season;
        this.leavesColor = leavesColor;
    }

    @Override
    public Season getCurrentSeason() {
        return season;
    }

    @Override
    public int compareTo(Object o) {
        Tree other = (Tree) o;
        return Integer.compare(this.height, other.height);
    }

    @Override
    public void changeSeason() {
        switch (season) {
            case WINTER: season = Season.SPRING; break;
            case SPRING: season = Season.SUMMER; break;
            case SUMMER: season = Season.FALL; break;
            case FALL: season = Season.WINTER; break;
        }
    }
}
