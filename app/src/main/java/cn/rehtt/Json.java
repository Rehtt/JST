package cn.rehtt;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by dsres on 2017/6/25.
 */

public class Json {
    public String json (String str, String content){
        String[] a=str.split("\\{|\\\"|\\:|\\,|\\}");
        ArrayList<String> arrayList=new ArrayList<>();
        for (String i:a){
            arrayList.add(i);
        }

        int j=0;
        String re;
        for (String i:arrayList){
            if(i.equals(content)){
                re= arrayList.get(j+3);return re;
            }
            j++;
        }



        return "NULL";
    }
}