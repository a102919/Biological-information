package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class readData {
    public List<String> readFile(String file) {
        List<String> data = new ArrayList();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            while (br.ready()){
                data.add(br.readLine());
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public Map<String,DNABean> makeDataMap(List<String> data){
        Map<String,DNABean> map = new HashMap<>();
        String key=null;
        DNABean dnaBean = null;
        for(String d:data){
            if(d!=null){
                if(d.contains(">")){
                    key = d;
                    dnaBean = new DNABean(key);
                    map.put(key,dnaBean);
                }else if(key != null){
                    if(map.containsKey(key)) {
                        try {
                            map.get(key).setDNA(d);
                        }catch (Exception e){
                            System.out.println(e);
                        }

                    }
                }
            }
        }
        return map;
    }
}
