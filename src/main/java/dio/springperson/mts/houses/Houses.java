package dio.springperson.mts.houses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

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
    private String houseValues;
    private String houseColors;
    private String schoolName;
    private String houseMascot;
    private String houseGhost;
    private String houseFounder;

    public Houses(String id, String name, String headOfHouse,
                  String houseValues, String houseColors, String schoolName,
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
