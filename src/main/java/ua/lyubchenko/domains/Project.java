package ua.lyubchenko.domains;

import lombok.*;
import ua.lyubchenko.repositories.Identity;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Project implements Identity {
    private int id;
    private String name;
    private String start;
    private int coast;
}
