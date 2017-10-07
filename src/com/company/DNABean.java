package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DNABean {
    private String name;
    private String DNA;
    private Map<DNAenum,Character> dnaMap= new HashMap<>();

    public DNABean(String key) {
        this.name = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDNA() {
        return DNA;
    }

    public void setDNA(String DNA) {
        this.DNA += DNA;
    }

    public Map<DNAenum, Character> getDnaMap() {
        return dnaMap;
    }

    public void setDnaMap(Map<DNAenum, Character> dnaMap) {
        this.dnaMap = dnaMap;
    }
}
