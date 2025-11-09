// the visitor interface (defines the contract for all visitors).
// it declares a visit method for every concrete element type.
interface TrackerVisitor {
    // operation for strength exercise element.
    int visitStrengthExercise(StrengthExercise element);

    // operation for cardio exercise element.
    int visitCardioExercise(CardioExercise element);

    // operation for meal element.
    int visitMeal(Meal element);
}