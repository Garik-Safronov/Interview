package hw1.task1;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {

    private String firstName;
    private String lastName;
    private String middleName;
    private String country;
    private String address;
    private String phone;
    private int age;
    private String gender;
}
