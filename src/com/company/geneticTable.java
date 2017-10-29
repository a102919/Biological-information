package com.company;

public class geneticTable {
    public static String change(String dna){
        if(dna.equals("UUU") || dna.equals("UUC")){
            return "F";
        }else if(dna.equals("UUA") || dna.equals("UUG") || dna.equals("CUU") || dna.equals("CUC") || dna.equals("CUA") || dna.equals("CUG")){
            return "L";
        }else if(dna.equals("AUU") || dna.equals("AUC") || dna.equals("AUA")){
            return "I";
        }else if(dna.equals("AUG")){
            return "M";
        }else if(dna.equals("GUU") || dna.equals("GUC") || dna.equals("GUA") || dna.equals("GUG")){
            return "V";
        }else if(dna.equals("UCU") || dna.equals("UCC") || dna.equals("UCA") || dna.equals("UCG")){
            return "S";
        }else if(dna.equals("CCU") || dna.equals("CCC") || dna.equals("CCA") || dna.equals("CCG")){
            return "P";
        }else if(dna.equals("ACU") || dna.equals("ACC") || dna.equals("ACA") || dna.equals("ACG")){
            return "T";
        }else if(dna.equals("GCU") || dna.equals("GCC") || dna.equals("GCA") || dna.equals("GCG")){
            return "A";
        }else if(dna.equals("UAU") || dna.equals("UAC")){
            return "Y";
        }else if(dna.equals("UAA") || dna.equals("UAG") || dna.equals("UGA")){
            return "STOP";
        }else if(dna.equals("CAU") || dna.equals("CAC")){
            return "H";
        }else if(dna.equals("CAA") || dna.equals("CAG")){
            return "Q";
        }else if(dna.equals("AAU") || dna.equals("AAC")){
            return "N";
        }else if(dna.equals("AAA") || dna.equals("AAG")){
            return "K";
        }else if(dna.equals("GAU") || dna.equals("GAC")){
            return "D";
        }else if(dna.equals("GAA") || dna.equals("GAG")){
            return "E";
        }else if(dna.equals("UGU") || dna.equals("UGC")){
            return "C";
        }else if(dna.equals("UGG")){
            return "W";
        }else if(dna.equals("CGU") || dna.equals("CGC") || dna.equals("CGA") || dna.equals("CGG") || dna.equals("AGA") || dna.equals("AGG")){
            return "R";
        }else if(dna.equals("AGU") || dna.equals("AGC")){
            return "S";
        }else if(dna.equals("GGU") || dna.equals("GGC") || dna.equals("GGA") || dna.equals("GGG")){
            return "G";
        }else {
            return null;
        }
    }
}
