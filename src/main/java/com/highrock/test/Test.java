package com.highrock.test;

import java.sql.SQLOutput;
import java.util.*;

/**
 * @ClassName: Test
 * @Author: zjw
 * @Description: TODO
 * @Date: 2021/07/08 13:54
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        Cat c1 = new Cat("张进文");
        Cat c2 = new Cat("张进文");
        System.out.println(c1.equals(c2));

        String s1 = new String("zhang");
        String s2 = new String("zhang");
        System.out.println(s1.equals(s2));


        String str1 = "通话";
        String str2 = "重地";
        System.out.println(String.format("str1:%d | str2:%d", str1.hashCode(), str2.hashCode()));
        System.out.println(str1.equals(str2));
        System.out.println(str1 == str2);
        System.out.println(Math.round(-1.6));

        String aa = "adsfadsf";
        System.out.println(aa.indexOf("dsssss"));
        System.out.println(aa.indexOf("adsfadsf"));
        System.out.println(aa.indexOf("dsf"));

        System.out.println(aa.charAt(2));
        System.out.println(aa.charAt(1));
        System.out.println(aa.charAt(0));

        Map<String, Object> map = new HashMap<>();
        map.put("ggg", aa);


        List<String> list = new ArrayList<>();
        list.add("zhang");
        list.add("jin");
        list.add("wen");

        String[] arry = new String[]{"rrr", "eee", "tttt"};
        Arrays.asList(arry);

        System.out.println(list.toArray());


        Queue<String> queue = new LinkedList<>();
        queue.offer("String");
        queue.offer("ffff");
        System.out.println(queue.poll());
        System.out.println(queue.remove());
        System.out.println(queue.size());


        Map<String, Object> map1 = new HashMap<>();
        map1.put("a1", "zhang");
        map1.put("a2", "shang");
        map1.put("a3", "jinwen");

        for (Map.Entry<String, Object> a : map1.entrySet()) {
            System.out.println(a.getKey() + ":" + a.getValue());
        }

        List<String> list1 = new ArrayList<>();
        list1.add("zzz");
        list1.add("gggg");
        Iterator<String> it = list1.iterator();
        while (it.hasNext()) {
            String obj = it.next();
            System.out.println(obj);
        }


        //34.
        List<String> listA=new ArrayList<>();
        listA.add("x");
        Collection<String> clist = Collections.unmodifiableCollection(listA);
//        clist.add("gg");

        System.out.println(clist.size());


    }
}


class Cat {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cat(String name) {
        this.name = name;
    }
}
