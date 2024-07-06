package lt.techin;

public class Meal {

    String name;

    String calories;


    public Meal(String name, String calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName(int i) {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCalories(int i) {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }
}
