public class FigTree extends Tree {

    FigTree(int height, Season season) {
        super(height, season, null);
        if (season == Season.SPRING || season == Season.SUMMER) {
            this.leavesColor = Color.GREEN;
        } else if (season == Season.FALL) {
            this.leavesColor = Color.YELLOW;
        } else if (season == Season.WINTER) {
            this.leavesColor = null;
        }
    }

    @Override
    public String toString() {
        Season current = getCurrentSeason();
        if (current == Season.WINTER) {
            return "Fig tree. My height is: " + height + " and I have no leaves";
        } else if (current == Season.SUMMER) {
            return "Fig tree. I give fruit. My height is: " + height + " and my color is: " + leavesColor;
        }
        return "Fig tree. My height is: " + height + " and my color is: " + leavesColor;
    }

    @Override
    public void changeSeason() {
        super.changeSeason();
        switch (getCurrentSeason()) {
            case WINTER:
                height = (int) Math.round(height + 20.0);
                leavesColor = null;
                break;
            case SPRING:
                height = (int) Math.round(height + 30.0);
                leavesColor = Color.GREEN;
                break;
            case SUMMER:
                height = (int) Math.round(height + 30.0);
                break;
            case FALL:
                height = (int) Math.round(height + 20.0);
                leavesColor = Color.YELLOW;
                break;
        }
    }
}
