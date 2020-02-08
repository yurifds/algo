package datastructure.week4;

public class Test {

    public static void main(String[] args) {

        Integer ip1 = 172;
        Integer ip2 = 16;
        Integer ip3 = 254;
        Integer ip4 = 1;

        Double ipInt1 = ip1 * Math.pow(2, 24);
        Double ipInt2 = ip2 * Math.pow(2, 16);
        Double ipInt3 = ip3 * Math.pow(2, 8);
        Integer result = ipInt1.intValue() + ipInt2.intValue() + ipInt3.intValue() + ip4;
        System.out.println(result);

    }
}
