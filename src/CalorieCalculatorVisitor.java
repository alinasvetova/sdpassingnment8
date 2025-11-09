// calculates calories burned or consumed for all elements.
// this visitor is responsible for the calculation logic.
class CalorieCalculatorVisitor implements TrackerVisitor {
    // constants for conversion factors (macros to calories)
    private static final int PROTEIN_CAL_FACTOR = 4;
    private static final int FAT_CAL_FACTOR = 9;
    private static final int CARB_CAL_FACTOR = 4;

    @Override
    public int visitStrengthExercise(StrengthExercise element) {
        // estimates calories burned for strength training.
        // logic: duration * 6 + weight factor * 0.5
        return (int) (-(element.getDurationMinutes() * 6 + element.getWeightKg() * 0.5));
    }

    @Override
    public int visitCardioExercise(CardioExercise element) {
        // estimates calories burned for cardio.
        // logic: distance * 70 + duration * 5
        return (int) (-(element.getDistanceKm() * 70 + element.getDurationMinutes() * 5));
    }

    @Override
    public int visitMeal(Meal element) {
        // calculates calories consumed from a meal.
        // logic: protein*4 + fat*9 + carb*4
        return (int) (element.getProteinG() * PROTEIN_CAL_FACTOR +
                element.getFatG() * FAT_CAL_FACTOR +
                element.getCarbG() * CARB_CAL_FACTOR);
    }
}