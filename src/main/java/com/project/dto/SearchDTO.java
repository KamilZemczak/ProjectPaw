package com.project.dto;

import java.util.ArrayList;
import java.util.List;

public class SearchDTO {

    private String title;
    private Integer searchType = 1;
    private String query;
    List<SearchObjectDTO> resultList = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSearchType() {
        return searchType;
    }

    public void setSearchType(Integer searchType) {
        this.searchType = searchType;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public List<SearchObjectDTO> getResultList() {
        return resultList;
    }

    public void setResultList(List<SearchObjectDTO> resultList) {
        this.resultList = resultList;
    }
}
