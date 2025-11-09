// generates a formatted daily report summary from all elements.
// this visitor collects and formats data.
class ReportGeneratorVisitor implements TrackerVisitor {
    // using StringBuilder for efficient report generation.
    private final StringBuilder reportBuilder = new StringBuilder();

    @Override
    public int visitStrengthExercise(StrengthExercise element) {
        // collects strength exercise data for the report.
        reportBuilder.append(String.format(" - [strength] %s: %d min at %.1f kg\n",
                element.getName(), element.getDurationMinutes(), element.getWeightKg()));
        return 0; // return value is irrelevant
    }

    @Override
    public int visitCardioExercise(CardioExercise element) {
        // collects cardio exercise data for the report.
        reportBuilder.append(String.format(" - [cardio] %s: %.2f km in %d min\n",
                element.getName(), element.getDistanceKm(), element.getDurationMinutes()));
        return 0;
    }

    @Override
    public int visitMeal(Meal element) {
        // collects meal data for the report.
        reportBuilder.append(String.format(" - [meal] %s: p:%.1f, f:%.1f, c:%.1f\n",
                element.getName(), element.getProteinG(), element.getFatG(), element.getCarbG()));
        return 0;
    }

    // provides the final generated report string.
    public String getReport() {
        return reportBuilder.toString();
    }
}