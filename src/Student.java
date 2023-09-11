public class Student {
    public int id; // Public field for ID
    public String firstName; // Public field for first name
    public String lastName; // Public field for last name
    public AssignmentMarks mathMarks; // Public field for math marks
    public AssignmentMarks englishMarks; // Public field for English marks

    public Student(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        
    }

    public String getFullName1() {
        return firstName + " " + lastName;
    
    }

    // You can remove the getters and setters for these fields since they are public

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public AssignmentMarks getMathMarks() {
        return mathMarks;
    }

    public void setMathMarks(AssignmentMarks mathMarks) {
        this.mathMarks = mathMarks;
    }

    public AssignmentMarks getEnglishMarks() {
        return englishMarks;
    }

    public void setEnglishMarks(AssignmentMarks englishMarks) {
        this.englishMarks = englishMarks;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}



