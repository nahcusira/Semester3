package entities;

/**
 *
 * @author admin
 */
public class Report implements Comparable<Report> {

    private String id;
    private String studentName;
    private String courseName;
    private int totalCourse;

    public Report() {
    }

    public Report(String id, String studentName, String courseName, int totalCourse) {
        this.id = id;
        this.studentName = studentName;
        this.courseName = courseName;
        this.totalCourse = totalCourse;
    }

    
    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getTotalCourse() {
        return totalCourse;
    }

    public void setTotalCourse(int totalCourse) {
        this.totalCourse = totalCourse;
    }

    @Override
    public int compareTo(Report t) {
        return this.studentName.compareTo(t.studentName);
    }
}
