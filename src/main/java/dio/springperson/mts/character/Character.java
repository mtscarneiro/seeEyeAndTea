package dio.springperson.mts.character;


import dio.springperson.mts.houses.Houses;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_characters")
@Getter
@Setter
@NoArgsConstructor
public class Character implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String role;
    private String school;

    @ManyToOne
    @JoinColumn(name = "houses_id")
    private Houses houseId;

    private String patronous;

    public Character(String name, String role, String school, Houses houseId, String patronous) {
        this.name = name;
        this.role = role;
        this.school = school;
        this.houseId = houseId;
        this.patronous = patronous;
    }
}
