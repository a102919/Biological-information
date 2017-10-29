package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DNABean {
    private String name;
    private List<String> DNA = new ArrayList<>();
    private Map<DNAenum,Integer> dnaMap= new HashMap<>();
    private Map<String,Integer> DNAconn = new HashMap<>() ;
    private String alldna;
    private int DNASize=0 ;

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

    public Map<String, Integer> getDNAconn() {
        return DNAconn;
    }
    public void addDNAconn(String dna, Integer count){
        DNAconn.put(dna,count);
    }

    public void clearMap(){
        DNAconn.clear();
    }

    public String getAlldna() {
        if(alldna==null)
            alldna = getDNAString();
        return alldna;
    }

    public int getDNASize() {
        return this.getDNAString().length();
    }

    public void setAlldna(String alldna) {
        this.alldna = alldna;
    }

    public String getRNA(){
        return DNAcontrol.getInstance().toRNA(this.DNA);
    }

    public List<String> getAlldanCloud(){
        List<String> AlldanCloud = new ArrayList<>();
        AlldanCloud.add(this.getRNA());
        AlldanCloud.add(this.getRNA().substring(1,getDNASize()-1));
        AlldanCloud.add(this.getRNA().substring(2,getDNASize()-1));
        String secondDNA = DNAcontrol.getInstance().toScondDNA(this.DNA);
        String secondRNA = DNAcontrol.getInstance().toRNA(secondDNA);
        //secondRNA = DNAcontrol.getInstance().rotate(secondRNA);
        AlldanCloud.add(secondRNA);
        AlldanCloud.add(secondRNA.substring(1,getDNASize()-1));
        AlldanCloud.add(secondRNA.substring(2,getDNASize()-1));
        return AlldanCloud;
    }
}
