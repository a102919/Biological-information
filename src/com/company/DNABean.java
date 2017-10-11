package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DNABean {
    private String name;
    private List<String> DNA = new ArrayList<>();
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

    public String getDNAString(){
        String DNAString = "";
        for(String d:DNA){
            DNAString += d;
        }
        return DNAString;
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

    public float getGCCount(){
        int allDNA = 0, GCCount = 0;
        if(!dnaMap.isEmpty()) {
            for (DNAenum dnAenum : dnaMap.keySet()) {
                allDNA += dnaMap.get(dnAenum);
            }
            GCCount = dnaMap.get(DNAenum.G) + dnaMap.get(DNAenum.C);
            System.out.println(allDNA);
        }else {
            System.out.println("dnaMap is empty");
        }

        return ((float) GCCount*100/allDNA);
    }
}
