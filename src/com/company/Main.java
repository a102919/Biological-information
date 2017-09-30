package com.company;

import java.io.IOException;
import java.util.*;

public class Main {
    private static String file = "C:\\Users\\IDBlab\\Desktop\\homework\\biological\\rosalind_revc.txt";

    public static void main(String[] args) throws IOException {
        DNAController controller = new DNAController();
        //第一題 算DNA裡面 A C G T 的數量
        Map<DNAenum,Integer>  DNAmap = controller.count(file);
        for(Object key : DNAmap.keySet()){
            System.out.print(DNAmap.get(key)+" ");
        }
        System.out.println();
        //第二題 將DNA轉成RNA
        String RNA = controller.toRNA(file);
        System.out.print(RNA);
        System.out.println();
        //第三題 找出DNA的第二對
        String secondDNA = controller.toScondDNA(file);
        System.out.print(secondDNA);
        System.out.println();

    }






}
