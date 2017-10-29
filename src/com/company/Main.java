package com.company;

import java.io.IOException;
import java.util.*;

public class Main {
    private static String file = "C:\\Users\\107computer\\IdeaProjects\\Biological-information\\file\\rosalind_gc.txt";

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

        //第四題
        DNABean dnaBean =  controller.searchMorstCG(file);
        if(dnaBean==null){
            System.out.println("bean = null");
        }
        float GCCount = dnaBean.getGCCount();
        System.out.println(dnaBean.getName()+" : "+GCCount+"%");

        //第五題
        List<Integer> seatList = controller.searchDNASeat(file);
        for(Integer seat:seatList){
            System.out.print(seat+" ");
        }
        System.out.println();

        //第六題
        List<String> DNALink = controller.searchMachDNA(file);
        for(String s:DNALink){
            System.out.println(s);
        }

        //未完成
        //第七題
        String conDNA = controller.combinationDNA(file);
        System.out.println(conDNA);
*/

        //第八題 PROT
        String  Protein = controller.changeProteinCode(file);
        System.out.println(Protein);

        //第九題 ORF
        Set<String> output = controller.searchAllProteinCode(file);
        for (String out:output)
        System.out.println(out);
    }
}
