package com.company;

import java.io.IOException;
import java.util.*;

public class DNAcontrol {
    private static DNAcontrol dnAcontrol;
    private DNAcontrol() {}
    public static DNAcontrol getInstance(){
        if(dnAcontrol == null){
            dnAcontrol = new DNAcontrol();
        }
        return dnAcontrol;
    }

    public Map<DNAenum,Integer> count(List<String> data) {
        List<Character> charDNA = toChar(data);
        Map<DNAenum,Integer> DNAmap = countDNA(charDNA);
        return DNAmap;
    }

    public String toRNA(List<String> data ) {
        String RNA = "";
        for (String d:data){
            RNA += d.replaceAll("T","U");
        }
        return RNA;
    }
    public String toRNA(String data ) {
        String RNA = "";
        RNA = data.replaceAll("T","U");
        return RNA;
    }

    public String toScondDNA(List<String> data) {
        String RNA = "";
        List<Character> charDNA= toChar(data);
        for (char c: charDNA){
            RNA = searchSecondDNA(c) + RNA;
        }
        return RNA;
    }

    public String rotate(String data){
        int lenght = data.length();
        String dna = "";
        for(int i=0;i<lenght;i++){
            dna = data.charAt(i)+dna;
        }
        return dna;
    }

    private char searchSecondDNA(char c) {
        char DNA = ' ';
        switch (c){
            case 'A':
                DNA = DNAenum.T.getValue();
                break;
            case 'C':
                DNA = DNAenum.G.getValue();
                break;
            case 'G':
                DNA = DNAenum.C.getValue();
                break;
            case 'T':
                DNA = DNAenum.A.getValue();
                break;
        }
        return DNA;
    }
    private List<Character> toChar(List<String> data){
        List<Character> charData = new ArrayList<>();
        for(String d:data){
            for(int i=0; i<d.length(); i++){
                charData.add(d.charAt(i));
            }
        }
        return charData;
    }

    public Map<DNAenum,Integer> countDNA(List<Character> stringSave){
        Map<DNAenum,Integer> DNAmap= new TreeMap<>();
        initDNAmap(DNAmap);
        for(char s:stringSave){
            int dnnaCount = 0;
            switch (s){
                case 'A':
                    dnnaCount = DNAmap.get(DNAenum.A);
                    dnnaCount++;
                    DNAmap.put(DNAenum.A,dnnaCount);
                    break;
                case 'C':
                    dnnaCount = DNAmap.get(DNAenum.C);
                    dnnaCount++;
                    DNAmap.put(DNAenum.C,dnnaCount);
                    break;
                case 'G':
                    dnnaCount = DNAmap.get(DNAenum.G);
                    dnnaCount++;
                    DNAmap.put(DNAenum.G,dnnaCount);
                    break;
                case 'T':
                    dnnaCount = DNAmap.get(DNAenum.T);
                    dnnaCount++;
                    DNAmap.put(DNAenum.T,dnnaCount);
                    break;
            }
        }
        return DNAmap;
    }
    private static void initDNAmap(Map<DNAenum , Integer> DNAmap){
        for(DNAenum dna: DNAenum.values()) {
            DNAmap.put(dna,0);
        }
    }

    public List<Integer> seachMachSeat(String dna,String fragment){
        List<Integer> seatList = new ArrayList<>();
        int seat = 0,sentSeat = 0;
        int dnaSize = dna.length();
        while (true){
            seat = dna.substring(sentSeat,dnaSize).indexOf(fragment)+1;
            if(seat == 0){
                break;
            }
            sentSeat += seat;
            seatList.add(sentSeat);
        }
        return seatList;
    }

    public List<String> cutDNA(String DNA){
        List<String> threeList = new ArrayList<>();
        int DNAlength = DNA.length();
        DNAlength -= DNAlength%3;
        for(int i=0;i<DNAlength;i+=3){
            threeList.add(DNA.substring(i,i+3));
        }
        return threeList;
    }
}
