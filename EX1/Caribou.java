public class Caribou extends Animal {

    Caribou(int weight, Season season) {
        super(weight, season, season == Season.WINTER ? Color.WHITE : Color.BROWN);
    }

    @Override
    public String toString() {
        Season current = getCurrentSeason();
        if (current == Season.WINTER) {
            return "Caribou: I am migrating south. My weight is: " + weight + " and my color is: " + color;
        } else if (current == Season.SUMMER) {
            return "Caribou: I am migrating north. My weight is: " + weight + " and my color is: " + color;
        }
        return "Caribou: My weight is: " + weight + " and my color is: " + color;
    }

    @Override
    public void changeSeason() {
        super.changeSeason();
        switch (getCurrentSeason()) {
            case WINTER:
                color = Color.WHITE;
                break;
            case SPRING:
                color = Color.BROWN;
                break;
            case SUMMER:
                break;
            case FALL:
                break;
        }
    }
}
