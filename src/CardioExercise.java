// a concrete element representing a cardio workout.
class CardioExercise implements TrackerElement {
    private final String name;
    private final int durationMinutes;
    private final double distanceKm;

    public CardioExercise(String name, int durationMinutes, double distanceKm) {
        this.name = name;
        this.durationMinutes = durationMinutes;
        this.distanceKm = distanceKm;
    }

    // getters
    public int getDurationMinutes() { return durationMinutes; }
    public double getDistanceKm() { return distanceKm; }
    public String getName() { return name; }

    @Override
    public String getDetails() {
        return String.format("%s (%d min, %.2f km)", name, durationMinutes, distanceKm);
    }

    @Override
    public int accept(TrackerVisitor visitor) {
        return visitor.visitCardioExercise(this);
    }
}