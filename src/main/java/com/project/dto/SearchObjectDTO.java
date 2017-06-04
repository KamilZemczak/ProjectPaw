package com.project.dto;

public class SearchObjectDTO {

    private Integer id;
    private String name;
    private String secondary;

    public SearchObjectDTO() {
    }

    public SearchObjectDTO(Integer id, String name, String secondary) {
        this.id = id;
        this.name = name;
        this.secondary = secondary;
    }

    public SearchObjectDTO(String name, String secondary) {
        this.name = name;
        this.secondary = secondary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondary() {
        return secondary;
    }

    public void setSecondary(String secondary) {
        this.secondary = secondary;
    }
}
