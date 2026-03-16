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
                height += 20;
                leavesColor = null; // leaves drop
                break;
            case SPRING:
                height += 30;
                leavesColor = Color.GREEN;
                break;
            case SUMMER:
                height += 30;
                break; // Gives fruit but leaves stay green
            case FALL:
                height += 20;
                leavesColor = Color.YELLOW; // Turn yellow
                break;
        }
    }
}
