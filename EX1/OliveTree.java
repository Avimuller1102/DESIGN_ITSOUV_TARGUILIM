public class OliveTree extends Tree {

    OliveTree(int height, Season season) {
        super(height, season, Color.GREEN);
    }

    @Override
    public String toString() {
        if (getCurrentSeason() == Season.FALL) {
            return "Olive tree. I give fruit. My height is: " + height + " and my color is: " + leavesColor;
        }
        return "Olive tree. My height is: " + height + " and my color is: " + leavesColor;
    }

    @Override
    public void changeSeason() {
        super.changeSeason();
        switch (getCurrentSeason()) {
            case WINTER:
                height = (int) Math.round(height + 5.0);
                break;
            case SPRING:
                height = (int) Math.round(height + 10.0);
                break;
            case SUMMER:
                height = (int) Math.round(height + 10.0);
                break;
            case FALL:
                height = (int) Math.round(height + 5.0);
                break;
        }
    }
}
