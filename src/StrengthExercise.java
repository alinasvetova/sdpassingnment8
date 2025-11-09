// a concrete element representing a strength workout.
class StrengthExercise implements TrackerElement {
    private final String name;
    private final int durationMinutes;
    private final double weightKg;

    // constructor initializes all fields.
    public StrengthExercise(String name, int durationMinutes, double weightKg) {
        this.name = name;
        this.durationMinutes = durationMinutes;
        this.weightKg = weightKg;
    }

    // getters
    public int getDurationMinutes() { return durationMinutes; }
    public double getWeightKg() { return weightKg; }
    public String getName() { return name; }

    @Override
    public String getDetails() {
        return String.format("%s (%d min, %.1f kg)", name, durationMinutes, weightKg);
    }

    @Override
    public int accept(TrackerVisitor visitor) {
        // delegates the operation to the specific visitor method.
        return visitor.visitStrengthExercise(this);
    }
}