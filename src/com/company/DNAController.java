package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DNAController {

    public Map<DNAenum,Integer> count(String file) throws IOException {
        List<String> data = readData(file);
        List<Character> charDNA = toChar(data);
        Map<DNAenum,Integer> DNAmap = countDNA(charDNA);
        return DNAmap;
    }

    public String toRNA(String file) throws IOException {
        List<String> data = readData(file);
        String RNA = "";
        for (String d:data){
            RNA += d.replaceAll("T","U");
        }
        return RNA;
    }

    public String toScondDNA(String file) throws IOException {
        String RNA = "";
        List<String> data = readData(file);
        List<Character> charDNA= toChar(data);
        for (char c: charDNA){
            RNA = searchSecondDNA(c) + RNA;
        }
        return RNA;
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

    private List<String> readData(String file) throws IOException {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        List<String> data = new ArrayList();
        while (br.ready()){
            data.add(br.readLine());
        }
        fr.close();
        return data;
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
}
