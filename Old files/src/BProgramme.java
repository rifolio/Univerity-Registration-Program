package src;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

//class representing a bachelor programme
class BProgramme {
    private List<StudyActivity> activities; //list of activities
    public int bCourseCounter = 0; //counter for Basic Courses
    int eCourseCounter = 0; //elective
    public int m1ProjectsCounter = 0; //module 1 project
    public int m1CourseCounter = 0; //module 1 course
    public int m2ProjectsCounter = 0; //module 2 project
    public int m2CourseCounter = 0; //module 2 course
    public int bProjectCounter = 0;
    public int bcProjectCounter = 0;
    public int totalECTSCourses = 0;
    public int totalECTSProjects = 0;
    public int totalECTSbCourse = 0;
    public int totalECTSmCourse = 0;
    public int totalECTSeCourse = 0;

    public BProgramme() {
        activities = new ArrayList<>();
    }

    public void addActivity(int n, String type, String department) {
        for (int i = 0; i < n; i++) {
            StudyActivity activity = createActivity(type, department);
            if (activity != null) {
                activities.add(activity);
            }
        }
    }

    //switch statement to create 7 different types of study activities
    private StudyActivity createActivity(String type, String department) {
        switch (type) {
//-----------------Basic-----------------------------------------------------------------
            case "Basic Course":
                bCourseCounter++; //increasing counter of activity type
                return new BasicCourse("Basic Course", 5, department, "Basic Course " + bCourseCounter);

            case "Basic Project":
                bProjectCounter++;
                return new BasicProject("Basic Project", department, "Basic Project " + bProjectCounter);

//-----------------Second module1-----------------------------------------------------------------
            case "Module1 Course5": //Module course with 5 ECTS
                m1CourseCounter++;
                return new SubjectModuleCourse("Module Course 1", 5, department, "Module Course " + m1CourseCounter);

            case "Module1 Course10": //Module course with 10 ECTS
                m1CourseCounter++;
                return new SubjectModuleCourse("Module Course 1", 10, department, "Module Course " + m1CourseCounter);

            case "Module1 Project":
                m1ProjectsCounter++;
                return new SubjectModuleProject("Module Project 1", department, "Module Project " + m1ProjectsCounter);

//-----------------Second module2-----------------------------------------------------------------
            case "Module2 Course5": //Module course with 5 ECTS
                m2CourseCounter++;
                return new SubjectModuleCourse("Module Course 2", 5, department, "Module Course " + m2CourseCounter);

            case "Module2 Course10": //Module course with 10 ECTS
                m2CourseCounter++;
                return new SubjectModuleCourse("Module Course 2", 10, department, "Module Course " + m2CourseCounter);

            case "Module2 Project":
                m2ProjectsCounter++;
                return new SubjectModuleProject("Module Project 2", department, "Module Project " + m2ProjectsCounter);

//-----------------Elective-----------------------------------------------------------------
            case "Elective Course":
                eCourseCounter++;
                return new ElectiveCourse("Elective Course", 5, department, "Elective Course " + eCourseCounter);

//-----------------Bachelor Project-----------------------------------------------------------------
            case "Bachelor Project":
                bcProjectCounter++;
                return new BachelorProject("Bachelor Project", department, "Bachelor Project");

            default:
                System.out.println("Invalid activity type: " + type);
                return null;
        }
    }

    //calculating total ECTS poinst over the whole StudyActivities list
//    public int calculateTotalECTS(String activityType) {
//        int totalECTS = 0;
//        for (StudyActivity activity : activities) {
//            if (activity.getType().equals(activityType)) {
//                totalECTS += activity.getECTS();
//            }
//        }
//        return totalECTS;
//    }


    public List<StudyActivity> getActivities() { //getter for StudyActivities
        return activities;
    }

    public Map<String, Integer> pointsCounter() {
        Map<String, Integer> ectsMap = new HashMap<>();

        for (StudyActivity activity : activities) {
            String activityType = activity.getType();
            int ects = activity.getECTS();

            ectsMap.put(activityType, ectsMap.getOrDefault(activityType, 0) + ects);
        }

        return ectsMap;
    }
    public boolean valid() {
        Map<String, Integer> ectsMap = pointsCounter();

//        // Print the contents of the ectsMap
        System.out.println("Contents of ectsMap:");
        for (Map.Entry<String, Integer> entry : ectsMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }


//         Check if all activities are unique
        if (activities.size() != ectsMap.size()) {
            return false;
        }

        System.out.println(activities.size());


        // Check if there are activities from two subject modules
        if (m1ProjectsCounter != 1 || m2ProjectsCounter != 1 || m1CourseCounter != 3 || m2CourseCounter != 3) {
            return false;
        }

        // Check if there are three basic projects and a bachelor project
        if (bProjectCounter != 3 || bcProjectCounter != 1) {
            return false;
        }

        // Check if the distribution of ECTS points is correct
        if (ectsMap.getOrDefault("Basic Course", 0) != 45 ||
                ectsMap.getOrDefault("Module Course 1", 0) != 20 ||
                ectsMap.getOrDefault("Module Course 2", 0) != 20 ||
                ectsMap.getOrDefault("Elective Course", 0) != 5 ||
                ectsMap.getOrDefault("Bachelor Project", 0) != 15 ||
                ectsMap.getOrDefault("Basic Project", 0) != 45 ||
                ectsMap.getOrDefault("Module Project 1", 0) != 15 ||
                ectsMap.getOrDefault("Module Project 2", 0) != 15) {
            return false;
        }

        return true;
    }
}