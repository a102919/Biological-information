package com.company;

import java.util.List;
import java.util.Map;

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
}
