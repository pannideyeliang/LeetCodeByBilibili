package Base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {
        ArrayList<String> lis = new ArrayList<>();
        lis.add("djlaksjd");
        lis.add("dsf");
        lis.add("dasd");
        lis.add("asdsaq");
        lis.stream().filter(s -> s.startsWith("d")).filter(s -> s.length() > 3)
                .forEach(System.out::println);

        System.out.println("=======================");
        HashMap<String, Integer> map = new HashMap<>();
        map.put("aaa", 111);
        map.put("aadaa", 222);
        map.put("aqwaa", 112);
        map.put("bbb", 341);
        map.put("ccc", 2321);
        map.entrySet().stream().forEach(System.out::println);
        System.out.println("=======================");
        String[] tmp = {"a", "b", "as"};
        Arrays.stream(tmp).forEach(System.out::println);
        System.out.println("=======================");
        Stream.of(1,2,3,4,5,"tdsak","asda",Boolean.TRUE)
                .forEach(System.out::println);

    }
}
