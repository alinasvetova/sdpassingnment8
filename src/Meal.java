// a concrete element representing a tracked meal.
class Meal implements TrackerElement {
    private final String name;
    private final double proteinG;
    private final double fatG;
    private final double carbG;

    public Meal(String name, double proteinG, double fatG, double carbG) {
        this.name = name;
        this.proteinG = proteinG;
        this.fatG = fatG;
        this.carbG = carbG;
    }

    // getters
    public double getProteinG() { return proteinG; }
    public double getFatG() { return fatG; }
    public double getCarbG() { return carbG; }
    public String getName() { return name; }

    @Override
    public String getDetails() {
        return String.format("%s (p:%.1f, f:%.1f, c:%.1f)", name, proteinG, fatG, carbG);
    }

    @Override
    public int accept(TrackerVisitor visitor) {
        return visitor.visitMeal(this);
    }
}