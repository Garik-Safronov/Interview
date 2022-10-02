package hw5.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "mark")
    private int mark;

    public Student(String name, int mark) {
        this.name = name;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return String.format("Student [id = %d, name = %s, mark = %d]",id, name, mark );
    }
}
