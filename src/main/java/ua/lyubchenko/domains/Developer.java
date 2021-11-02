package ua.lyubchenko.domains;

import lombok.*;
import ua.lyubchenko.repositories.Identity;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Developer implements Identity {
    private int id;
    private String name;
    private int age;
    private String sex;
    private String phone_number;
    private int salary;

}
