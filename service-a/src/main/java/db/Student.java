package db;
import org.springframework.data.annotation.Id;

public class Student {
    @Id
    private String id;
    private String name;
    private int semester;

    public Student(){

    }

    public Student(String name, int semester){
        this.name = name;
        this.semester = semester;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
}
