package com.company;

import java.util.*;

public class DNAAdapter {
    private readData read;
    public DNAAdapter() {
        read = new readData();
    }
    //第一題 算DNA裡面 A C G T 的數量
    public Map<DNAenum,Integer> countDNAChar(String file){
        List<String> data = read.readFile(file);
        Map<DNAenum,Integer> DNAmap = DNAcontrol.getInstance().count(data);
        return DNAmap;
    }

    //第二題 將DNA轉成RNA
    public String changeDNAToRNA(String file){
        List<String> data = read.readFile(file);
        String RNA = DNAcontrol.getInstance().toRNA(data);
        return RNA;
    }

    //第三題 找出DNA的第二對
    public String searchSecondDNA(String file){
        List<String> data = read.readFile(file);
        String secDNA = DNAcontrol.getInstance().toScondDNA(data);
        return secDNA;
    }

    //第四題 算出一個DNA堆裡面最多 GC 比例的基因列
    public DNABean searchMorstCG(String file){
        List<String> data = read.readFile(file);
        Map<String,DNABean> DNAMap = read.makeDataMap(data);
        String reternKey = null;
        float GCpersent = 0;
        for(String key:DNAMap.keySet()){
            System.out.println(key);
            List<String> DNA = DNAMap.get(key).getDNA();
            Map<DNAenum,Integer> dnaMap = DNAcontrol.getInstance().count(DNA);
            DNAMap.get(key).setDnaMap(dnaMap);
            float GCCount = DNAMap.get(key).getGCCount();
            System.out.println(GCCount);
            if(GCpersent < GCCount){
                GCpersent = GCCount;
                reternKey = key;
                System.out.println(reternKey);
            }
        }
        return DNAMap.get(reternKey);
    }

    //第五題 找出DNA裡面符合的位子
    public List<Integer> searchDNASeat(String file){
        List<String> data = read.readFile(file);
        String dna = data.get(0);
        String fragment = data.get(1);
        List<Integer> seatList = DNAcontrol.getInstance().seachMachSeat(dna,fragment);
        return seatList;
    }

    //第六題 找出DNA對裡面重合的對數
    public List<String> searchMachDNA(String file){
        List<String> DNALink = new ArrayList<>();
        List<String> data = read.readFile(file);
        Map<String,DNABean> DNAMap = read.makeDataMap(data);
        for(String key:DNAMap.keySet()){
            for(String key2:DNAMap.keySet()){
                if(key==key2)
                    continue;
                //System.out.println(key+" "+key2);
                String DNA1 = DNAMap.get(key).getDNAString();
                String DNA2 = DNAMap.get(key2).getDNAString();
                int lenght = DNA1.length();
                int lenght2 = DNA2.length();
                char checkDNA ;
                int maxMech = 3;
                String compare1 = DNA1.substring(lenght-maxMech,lenght);
                String compare2 = DNA2.substring(0,maxMech);
                if(compare1.equals(compare2) ){
                    DNALink.add(key+" "+key2);
                }

            }
        }
        return DNALink;
    }

    public String combinationDNA(String file){
        List<String> DNALink = new ArrayList<>();
        List<String> data = read.readFile(file);
        Map<String,DNABean> DNAMap = read.makeDataMap(data);

        //找出所有基因最多重複象
        find2Short(DNAMap);
        //找出最短向
        String head = "";
        head = theShortest(DNAMap, head);
        LinkedList<String> dnaLink = new LinkedList();
        for(String key:DNAMap.keySet()){
            String alldna=DNAMap.get(key).getDNAString();
            Map<String,DNABean> newDNAMap = new HashMap<>();
            newDNAMap.putAll(DNAMap);
            newDNAMap.remove(key);
            find(newDNAMap,dnaLink,DNAMap.get(key),alldna);
        }
        int Short=100000000;
        String dnaString = "";
        for(String dna:dnaLink){
            if(dna.length()<Short){
                Short = dna.length();
                dnaString = dna;
            }
        }
        return dnaString;
    }

    private void find(Map<String,DNABean> DNAMap,LinkedList<String> dnaLink,DNABean head,String allthedna){
        if(allthedna.length()>1000000000){
        }else {
            if(DNAMap.size()==1){
                //DNAMap.clear();
                dnaLink.add(allthedna);
            }
            DNABean nexthead;
            Map<String,DNABean> makeDNAMap =new HashMap<>();
            makeDNAMap.putAll(DNAMap);
            for(String key:DNAMap.keySet()){
                if(head.getDNAconn().containsKey(key)){
                    String allthedna2 =allthedna;
                    nexthead = makeDNAMap.get(key);
                    allthedna2 += nexthead.getDNAString().substring(head.getDNAconn().get(key),nexthead.getDNAString().length());
                    head = DNAMap.get(key);
                    makeDNAMap.remove(key);
                    find(makeDNAMap,dnaLink,head,allthedna2);
                }
            }
        }

    }

    private String theShortest(Map<String, DNABean> DNAMap, String head) {
        int maxdna=0;
        for(String key:DNAMap.keySet()){
            Map<String,Integer> DNAconn = DNAMap.get(key).getDNAconn();
            int max = 0;
            for(String keycon:DNAconn.keySet()){
                if(max<DNAconn.get(keycon)) {
                    max = DNAconn.get(keycon);
                }
            }
            if(max > maxdna){
                maxdna = max;
                head = key;
            }
        }
        return head;
    }

    private void find2Short(Map<String, DNABean> DNAMap) {
        for(String key:DNAMap.keySet()){
            DNAMap.get(key).clearMap();
            for(String key2:DNAMap.keySet()){
                if(key==key2)
                    continue;
                String DNA1 = DNAMap.get(key).getDNAString();
                String DNA2 = DNAMap.get(key2).getDNAString();
                int lenght = DNA1.length();
                List<Integer> seatList = DNAcontrol.getInstance().seachMachSeat(DNA2,DNA1.substring(lenght-1,lenght));
                for(int i=seatList.size()-1;i>=0;i--){
                    int ss = seatList.get(i);
                    String dd = DNA2.substring(0, ss);
                    if(DNA1.endsWith(dd)) {
                        DNAMap.get(key).addDNAconn(key2,ss);
                    }
                }
            }
        }
    }
}
