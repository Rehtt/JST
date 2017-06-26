package cn.rehtt;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by dsres on 2017/6/25.
 */

public class Json {
    public Json() {
    }

    public String json(String str, String content) {
        String[] a = str.split("\\{|\\\"|\\:|\\,|\\}");
        ArrayList<String> arrayList = new ArrayList();
        String[] var5 = a;
        int var6 = a.length;

        String i;
        int j;
        for(j = 0; j < var6; ++j) {
            i = var5[j];
            arrayList.add(i);
        }

        j = 0;
        String re = "";

        for(Iterator var11 = arrayList.iterator(); var11.hasNext(); ++j) {
            i = (String)var11.next();
            if(i.equals(content)) {
                re = (String)arrayList.get(j + 3) ;
            }
        }

        if(re != "") {
            return re;
        } else {
            return "NULL";
        }
    }
}