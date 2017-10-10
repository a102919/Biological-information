package com.company;

import java.io.IOException;
import java.util.*;

public class Main {
    private static String file = "C:\\Users\\Alan\\IdeaProjects\\Biological-information\\file\\rosalind_gc.txt";

    public static void main(String[] args) throws IOException {
        DNAAdapter controller = new DNAAdapter();
        //第一題 算DNA裡面 A C G T 的數量
        /*
        Map<DNAenum,Integer>  DNAmap = controller.countDNAChar(file);
        for(Object key : DNAmap.keySet()){
            System.out.print(DNAmap.get(key)+" ");
        }
        System.out.println();
        //第二題 將DNA轉成RNA
        String RNA = controller.changeDNAToRNA(file);
        System.out.print(RNA);
        System.out.println();
        //第三題 找出DNA的第二對
        String secondDNA = controller.searchSecondDNA(file);
        System.out.print(secondDNA);
        System.out.println();
        */
        //第四題
        DNABean dnaBean =  controller.searchMorstCG(file);
        if(dnaBean==null){
            System.out.println("bean = null");
        }
        float GCCount = dnaBean.getGCCount();
        System.out.println(dnaBean.getName()+" : "+GCCount+"%");

    }






}
