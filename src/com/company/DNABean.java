package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DNABean {
    private String name;
    private List<String> DNA;
    private Map<DNAenum,Integer> dnaMap= new HashMap<>();

    public DNABean(String key) {
        this.name = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getDNA() {
        return DNA;
    }

    public void setDNA(String DNA) {
        this.DNA.add(DNA);
    }

    public Map<DNAenum, Integer> getDnaMap() {
        return dnaMap;
    }

    public void setDnaMap(Map<DNAenum, Integer> dnaMap) {
        this.dnaMap = dnaMap;
    }
}
