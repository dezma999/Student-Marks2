public class AssignmentMarks {
    private String courseName;
    private int assignment1;
    private int assignment2;
    private int assignment3;

    public AssignmentMarks(String courseName, int assignment1, int assignment2, int assignment3) {
        this.courseName = courseName;
        this.assignment1 = assignment1;
        this.assignment2 = assignment2;
        this.assignment3 = assignment3;
    }

    public void setMark(int assignmentNumber, int mark) {
        switch (assignmentNumber) {
            case 1:
                assignment1 = mark;
                break;
            case 2:
                assignment2 = mark;
                break;
            case 3:
                assignment3 = mark;
                break;
            default:
                System.out.println("Invalid assignment number.");
        }
    }

    public int getMark(int assignmentNumber) {
        switch (assignmentNumber) {
            case 1:
                return assignment1;
            case 2:
                return assignment2;
            case 3:
                return assignment3;
            default:
                System.out.println("Invalid assignment number.");
                return -1; // Return an invalid mark
        }
    }

    public int getAverageMark() {
        return (assignment1 + assignment2 + assignment3) / 3;
    }

    public String getGrade(int assignmentNumber) {
        int mark = getMark(assignmentNumber);
        return markToGrade(mark);
    }

    public String getAverageGrade() {
        int averageMark = getAverageMark();
        return markToGrade(averageMark);
    }

    public static String markToGrade(int mark) {
        if (mark >= 95 && mark <= 100) {
            return "A+";
        } else if (mark >= 90 && mark < 95) {
            return "A";
        } else if (mark >= 85 && mark < 90) {
            return "A-";
        } else if (mark >= 80 && mark < 85) {
            return "B+";
        } else if (mark >= 75 && mark < 80) {
            return "B";
        } else if (mark >= 70 && mark < 75) {
            return "B-";
        } else if (mark >= 65 && mark < 70) {
            return "C+";
        } else if (mark >= 60 && mark < 65) {
            return "C";
        } else if (mark >= 50 && mark < 60) {
            return "D";
        } else if (mark >= 0 && mark < 50) {
            return "F";
        } else {
            return "Invalid";
        }
    }

    public void setCourseName(String name) {
        this.courseName = name;
    }

    public String getCourseName() {
        return courseName;
    }
}
