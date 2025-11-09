import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// the context class that holds the collection of elements.
// it initiates the visitor operations.
class DailyLog {
    private final String logId;
    // uses the TrackerElement interface to store all different types (polymorphism).
    private final List<TrackerElement> elements = new ArrayList<>();

    public DailyLog() {
        // use of UUID for unique identifier.
        this.logId = UUID.randomUUID().toString();
    }

    public void addElement(TrackerElement element) {
        elements.add(element);
    }

    // iterates over all elements and applies the calorie calculator visitor.
    public int calculateNetCalories() {
        CalorieCalculatorVisitor calculator = new CalorieCalculatorVisitor();
        int totalCalories = 0;

        for (TrackerElement element : elements) {
            // double dispatch: the element accepts the visitor.
            totalCalories += element.accept(calculator);
        }

        return totalCalories;
    }

    // generates a full report for the day using the report generator visitor.
    public String generateReport() {
        ReportGeneratorVisitor generator = new ReportGeneratorVisitor();

        // iterate and apply the visitor.
        for (TrackerElement element : elements) {
            element.accept(generator);
        }

        // return the finalized report from the visitor.
        return generator.getReport();
    }

    public String getLogId() {
        return logId;
    }
}