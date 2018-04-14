/** create class for getting and storing food objects*/
class Food {

    /**
     * Set variables for food and cal
     */
    String foodName;
    int calIn = 0;
    String date;

    /**
     * no-args Constructor
     */
    public Food() {
        this.calIn = 0;
        this.foodName = "null";
        this.date = "null";
    }

    /**
     * Constructor
     */
    public Food(String date, String foodName, int calIn) {
        this.foodName = foodName;
        this.calIn = calIn;
        this.date = date;
    }

    /**
     * Set Date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Get Date
     */
    public String getDate() {
        return this.date;
    }

    /**
     * Set foodName
     */
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    /**
     * Get foodName
     */
    public String getFoodName() {
        return this.foodName;
    }

    /**
     * set Cal
     */
    public void setCalIn(int calIn) {
        this.calIn = calIn;
    }

    /**
     * get Cal
     */
    public int getCalIn() {
        return this.calIn;
    }

    /**
     * ToString
     */
    public String toString() {
        return ("Food: " + this.foodName + "\nCalories: " + this.calIn);
    }
}