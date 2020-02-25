package model;

public class Location {
    private String name;
    private String shortName;
    private String Type;
    private String capacity;
    private String school;
    private String active;



    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }



    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLocationType() {
        return Type;
    }

    public void setLocationType(String locationType) {
        this.Type = locationType;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }


}
