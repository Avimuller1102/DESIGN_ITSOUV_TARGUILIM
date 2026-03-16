public class Bear extends Animal {

    Bear(int weight, Season season) {
        super(weight, season, Color.BROWN);
    }

    @Override
    public String toString() {
        if (getCurrentSeason() == Season.WINTER) {
            return "Bear. I am sleeping. My weight is: " + weight + " and my color is: " + color;
        }
        return "Bear. My weight is: " + weight + " and my color is: " + color;
    }

    @Override
    public void changeSeason() {
        super.changeSeason();
        switch (getCurrentSeason()) {
            case WINTER:
                weight = (int) Math.round(weight * 0.80);
                break;
            case SPRING:
                weight = (int) Math.round(weight * 0.75);
                break;
            case SUMMER:
                weight = (int) Math.round(weight + (weight / 3.0));
                break;
            case FALL:
                weight = (int) Math.round(weight * 1.25);
                break;
        }
    }
}
