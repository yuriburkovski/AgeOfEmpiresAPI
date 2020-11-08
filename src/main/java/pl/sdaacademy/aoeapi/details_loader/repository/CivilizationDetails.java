package pl.sdaacademy.aoeapi.details_loader.repository;

import javax.persistence.*;
import java.util.List;

@Entity
public class CivilizationDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String expansion;
    private String armyType;
    @ElementCollection
    private List<String> uniqueUnit;
    @ElementCollection
    private List<String> civilizationBonus;

    public CivilizationDetails() {
    }

    public CivilizationDetails(int id, String name,
                               String expansion,
                               String armyType,
                               List<String> uniqueUnit,
                               List<String> civilizationBonus) {
        this.id = id;
        this.name = name;
        this.expansion = expansion;
        this.armyType = armyType;
        this.uniqueUnit = uniqueUnit;
        this.civilizationBonus = civilizationBonus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpansion() {
        return expansion;
    }

    public void setExpansion(String expansion) {
        this.expansion = expansion;
    }

    public String getArmyType() {
        return armyType;
    }

    public void setArmyType(String armyType) {
        this.armyType = armyType;
    }

    public List<String> getUniqueUnit() {
        return uniqueUnit;
    }

    public void setUniqueUnit(List<String> uniqueUnit) {
        this.uniqueUnit = uniqueUnit;
    }

    public List<String> getCivilizationBonus() {
        return civilizationBonus;
    }

    public void setCivilizationBonus(List<String> civilizationBonus) {
        this.civilizationBonus = civilizationBonus;
    }
}
