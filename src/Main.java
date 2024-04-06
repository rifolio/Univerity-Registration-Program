package src;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Create a new BProgramme
        BProgramme programme = new BProgramme();

        // Add chosen activities to the programme
        programme.addActivity(9 , "Basic Course", "Natural Science");
        programme.addActivity(3, "Basic Project", "Natural Science");

        programme.addActivity(2, "Module1 Course5", "Mathematics");
        programme.addActivity(1, "Module1 Course10", "Mathematics");
        programme.addActivity(1, "Module1 Project", "Physics");

        programme.addActivity(2, "Module2 Course5", "Computer Science");
        programme.addActivity(1, "Module2 Course10", "Computer Science");
        programme.addActivity(1, "Module2 Project", "Physics");

        programme.addActivity(1, "Elective Course", "Gender Studies");

        programme.addActivity(1, "Bachelor Project", "Computer Science");

//        // Print out the total ECTS for Basic Projects
//        System.out.println("Total ECTS for Basic Projects: " + programme.calculateTotalECTS("Basic Project"));

        // Retrieve the list of activities
        List<StudyActivity> activities = programme.getActivities();


        // Check if the programme is valid
        if (programme.valid()) {
            // Call pointsCounter method to get the ECTS points for each activity type
            Map<String, Integer> ectsMap = programme.pointsCounter();

//            // Print information for each activity
//            for (StudyActivity activity : activities) {
//                System.out.println("Name: " + activity.getName());
//                System.out.println("Type: " + activity.getType());
//                System.out.println("ECTS: " + activity.getECTS());
//                System.out.println("Department: " + activity.getDepartment());
//                System.out.println("___________________________________\n\n");
//            }
//
//            // Call pointsCounter method to get the counters for different types of activities
//            System.out.println("Basic Course Counter: " + programme.bCourseCounter);
//            System.out.println("Elective Course Counter: " + programme.eCourseCounter);
//            System.out.println("Module 1 Projects Counter: " + programme.m1ProjectsCounter);
//            System.out.println("Module 1 Course Counter: " + programme.m1CourseCounter);
//            System.out.println("Module 2 Projects Counter: " + programme.m2ProjectsCounter);
//            System.out.println("Module 2 Course Counter: " + programme.m2CourseCounter);
//            System.out.println("Basic Project Counter: " + programme.bProjectCounter);
//            System.out.println("Bachelor Project Counter: " + programme.bcProjectCounter);
//
            // Calculate total ECTS from the ectsMap
            int totalECTS = ectsMap.values().stream().mapToInt(Integer::intValue).sum();
            System.out.println("Total ECTS: " + totalECTS);
        } else {
            System.out.println("The programme is not valid.");
        }
    }
}
