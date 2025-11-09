// main class for demonstration of the fitness tracker application.
public class FitnessTrackerApp {
    public static void main(String[] args) {
        System.out.println("--- fitness tracker application using visitor pattern ---");

        // 1. set up the daily log
        DailyLog todayLog = new DailyLog();
        System.out.printf("log id: %s\n\n", todayLog.getLogId());

        // 2. create concrete elements
        // elements are referenced by the TrackerElement interface.
        TrackerElement squats = new StrengthExercise("barbell squats", 30, 75.0);
        TrackerElement running = new CardioExercise("treadmill run", 45, 5.5);
        TrackerElement breakfast = new Meal("oatmeal", 15.0, 5.0, 50.0);
        TrackerElement dinner = new Meal("chicken salad", 40.0, 10.0, 15.0);

        // 3. add elements to the log
        todayLog.addElement(squats);
        todayLog.addElement(running);
        todayLog.addElement(breakfast);
        todayLog.addElement(dinner);

        System.out.println("--- added elements ---");
        System.out.println(squats.getDetails());
        System.out.println(running.getDetails());
        System.out.println(breakfast.getDetails());
        System.out.println(dinner.getDetails());
        System.out.println("----------------------\n");

        // 4. operation a: generate report (uses ReportGeneratorVisitor)
        String report = todayLog.generateReport();
        System.out.println("--- daily activity report ---");
        System.out.print(report);

        // 5. operation b: calculate net calories (uses CalorieCalculatorVisitor)
        int netCalories = todayLog.calculateNetCalories();

        System.out.println("--- calorie summary ---");
        System.out.printf("total consumed (positive) / burned (negative) calories:\n%d kcal\n", netCalories);

        if (netCalories < 0) {
            System.out.println("=> result: calorie deficit achieved (good for weight loss).");
        } else {
            System.out.println("=> result: calorie surplus achieved (good for muscle gain).");
        }
    }
}