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


}
