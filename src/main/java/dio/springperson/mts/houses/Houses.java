package dio.springperson.mts.houses;

import dio.springperson.mts.character.Character;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tb_houses")
@Getter
@Setter
@NoArgsConstructor
public class Houses implements Serializable {

    @Id
    private String id;
    private String name;
    private String headOfHouse;

    @Lob
    private List<String> houseValues;

    @Lob
    private List<String> houseColors;
    private String schoolName;
    private String houseMascot;
    private String houseGhost;
    private String houseFounder;

    @OneToMany(mappedBy = "houseId")
    private List<Character> characters;

    public Houses(String id, String name, String headOfHouse,
                  List<String> houseValues, List<String> houseColors, String schoolName,
                  String houseMascot, String houseGhost, String houseFounder) {
        this.id = id;
        this.name = name;
        this.headOfHouse = headOfHouse;
        this.houseValues = houseValues;
        this.houseColors = houseColors;
        this.schoolName = schoolName;
        this.houseMascot = houseMascot;
        this.houseGhost = houseGhost;
        this.houseFounder = houseFounder;
    }
}
