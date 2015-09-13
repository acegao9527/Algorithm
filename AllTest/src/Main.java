import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/*channels 3
cid name ctype
1 netease 0
2 iplay 0
3 appstore 1
players 7
pid name cid
1 Smith 1
2 Carter 2
3 Linda 2
4 Bush 3
5 Adam 4
6 Gates 5
7 Hill 1
prepaids 8
id pid cash
1 3 1000
2 4 3000
3 1 2000
4 6 1000
5 7 2000
6 2 2000
7 5 6000
8 3 2000*/

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Integer,Integer> channels = new HashMap<>();
        HashMap<Integer,Integer> players = new HashMap<>();
        HashMap<Integer,Integer> prepaids = new HashMap<>();

        while (in.hasNextLine()){
            String[] tmp = in.nextLine().split(" ");
            if (tmp.length==2 && tmp[0].equals("channels")){
                int count = Integer.parseInt(tmp[1]);
                String nouse = in.nextLine();
                while (count>0){
                    String[] tmp2 = in.nextLine().split(" ");
                    Integer key = Integer.parseInt(tmp2[0]);
                    if (tmp2[2]==null){
                        Integer value = -1;
                    }
                    Integer value = Integer.parseInt(tmp2[2]);
                    channels.put(key,value);
                    count--;
                }
            }

            if (tmp.length==2 && tmp[0].equals("players")){
                int count = Integer.parseInt(tmp[1]);
                String nouse = in.nextLine();
                while (count>0){
                    String[] tmp2 = in.nextLine().split(" ");
                    Integer key = Integer.parseInt(tmp2[0]);
                    Integer value = Integer.parseInt(tmp2[2]);
                    players.put(key,value);
                    count--;
                }
//                System.out.println("录入完毕2");

            }

            if (tmp.length==2 && tmp[0].equals("prepaids")){
                int count = Integer.parseInt(tmp[1]);
                String nouse = in.nextLine();
                while (count>0){
                    String[] tmp2 = in.nextLine().split(" ");
                    Integer key = Integer.parseInt(tmp2[1]);
                    Integer value = Integer.parseInt(tmp2[2]);
                    if (prepaids.containsKey(key)){
                        prepaids.put(key,value+prepaids.get(key));
                    }else {
                    prepaids.put(key,value);
                    }
                    count--;
                }
//                System.out.println("录入完毕3");
                break;
            }
        }

//        System.out.println(channels.toString());
//        System.out.println(players.toString());
//        System.out.println(prepaids.toString());

        HashMap<Integer,Integer> play_channels = new HashMap<>();
        Iterator iterator = players.entrySet().iterator();
        for (Object o : players.entrySet()) {
            Map.Entry entry = (Map.Entry) o;
            Integer key = (Integer)entry.getKey();
            Integer value = (Integer)entry.getValue();

            if (channels.containsKey(value)) {
                play_channels.put(key, channels.get(value));
            }
        }
//        System.out.println("连接完毕1");
//        System.out.println(play_channels.toString());

        HashMap<Integer,Integer> result1 = new HashMap<>();
        HashMap<Integer,Integer> result2 = new HashMap<>();
        for (Object o : play_channels.entrySet()) {
            Map.Entry entry = (Map.Entry) o;
            Integer key = (Integer) entry.getKey();
            Integer value = (Integer) entry.getValue();
            if (result2.containsKey(value)) {
                result2.put(value, result2.get(value) + 1);
            } else {
                result2.put(value, 1);
            }

            if (prepaids.containsKey(key)) {
                if (result1.containsKey(value)) {
                    result1.put(value, result1.get(value) + prepaids.get(key));
                } else {
                    result1.put(value, prepaids.get(key));
                }
            }
        }
//        System.out.println("result1");
//        System.out.println(result1.toString());
//        System.out.println("result2");
//        System.out.println(result2.toString());

        for (Object o : result1.entrySet()) {
            Map.Entry entry = (Map.Entry) o;
            Integer key = (Integer) entry.getKey();
            Integer value = (Integer) entry.getValue();
            if (result1.containsKey(key)) {
                System.out.println(key + " " + value + " " + result1.get(key));
            }
        }
    }
}
