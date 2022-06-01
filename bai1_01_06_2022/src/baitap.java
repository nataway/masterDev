import java.util.*;
import javafx.util.Pair;

public class baitap {
    public static int sumList(List<Integer> a){
        int sum = 0;
        for (int i : a){
            sum+=i;
        }
        return sum;
    }
//    m2
    public static Pair<Integer, List<Character>> maxChar (String s){
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (Character i : s.toCharArray()){
            if (map.containsKey(i)){
                map.put(i, map.get(i)+1);
            }else map.put(i,1);
        }
        int maxValueInMap=(Collections.max(map.values()));
        List<Character> rs = new ArrayList<>();
        map.forEach((key, value) -> {
            if (value == maxValueInMap){
                rs.add(key);
            }
        });
        return new Pair<>(maxValueInMap, rs);
    }
// m3
    public static List<Integer> sortASC(List<Integer> list) {
        Collections.sort(list);
        return list;
    }
    public static List<Integer> get(int n){
        Scanner sc = new Scanner(System.in);
        List<Integer> b = new ArrayList<>();
        for (int i = 0; i < n; i++){
            System.out.print("nhap phan tu "+ (i+1) + ": ");
            b.add(sc.nextInt());
        }
        return b;
    }
    public static void show(List<Integer> list) {
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

//    m4
    public static boolean checkSNT(int num){
        if (num > 3){
            if (num % 2 == 0 || num % 3 == 0) return false;
        }
        else return num > 1;
        int i = 5;
        while (i * i <= num){
            if (num % i == 0 || num %(i+2) == 0) return false;
            i+=6;
        }
        return true;
    }
//    m5
    public static String dtTamGiac(int a, int b, int c) throws MyException{
        if(a+b <= c || a+c <= b || c+b <=a ){
            throw new MyException(a,b,c);
        }
        else {
            float p = (float)(a+b+c)/2;
            float dt = (float) Math.sqrt(p*(p-a)*(p-b)*(p-c));
            return String.format("Dien Tich = %.2f",dt);
        }
    }
//    m6
    public static void m6 (int rad) {
        double dis;
        for (int row = 0; row <= 2 * rad; row++) {
            for (int col = 0; col <= 2 * rad; col++) {
                dis = Math.sqrt((row - rad) * (row - rad) + (col - rad) * (col - rad));
                if (dis > rad - 0.5 && dis < rad + 0.5)
                    System.out.print("*");
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        boolean t = true;
        while (t){
            System.out.println("-------------------------------------------------------------------");
            System.out.println("1.m1");
            System.out.println("2.m2");
            System.out.println("3.m3");
            System.out.println("4.m4");
            System.out.println("5.m5");
            System.out.println("6.m6");
            System.out.println("7.thoat");
            int number;
            Scanner sc = new Scanner(System.in);
            System.out.print("select : ");
            number = sc.nextInt();
            String S = sc.nextLine();
            switch (number){
                case 1:
                    System.out.print("Nhap so phan tu mang: ");
                    int n = sc.nextInt();
                    List<Integer> a = new ArrayList<>();
                    for (int i = 0; i < n; i++){
                        System.out.print("nhap phan tu "+ (i+1) + ": ");
                        a.add(sc.nextInt());
                    }
                    System.out.println("sum = " + sumList(a));
                    break;
                case 2:
                    System.out.print("nhap chuoi : ");
                    S = sc.nextLine();
                    Pair<Integer, List<Character>> rs = maxChar(S);
                    System.out.println("max = "+rs.getKey());
                    for (Character i : rs.getValue()){
                        System.out.printf("ky tu '%s' \n",i);
                    }

                    break;
                case 3:
                    System.out.print("Nhap so phan tu mang: ");
                    n = sc.nextInt();
                    List<Integer> b = get(n);
                    System.out.println("mang truoc khi sa xep");
                    show(b);
                    sortASC(b);
                    System.out.println("mang sau khi sa xep");
                    show(b);
                    break;
                case 4:
                    System.out.println(checkSNT(9));
                    break;
                case 5:
                    try {
                        System.out.print("Nhap canh 1: ");
                        int c1 = sc.nextInt();
                        System.out.print("Nhap canh 2: ");
                        int c2 = sc.nextInt();
                        System.out.print("Nhap canh 3 :");
                        int c3 = sc.nextInt();
                        try {
                            System.out.println(dtTamGiac(c1,c2,c3));
                        }catch (MyException me){
                            System.out.println("Loi: "+ me);
                        }
                    } catch (Exception e) {
                        System.out.println("Loi: " + e);
                    }
                    break;
                case 6:
                    System.out.print("Eradius= ");
                    int rad = sc.nextInt();
                    m6(rad);
                    break;
                case 7:
                    t = false;
                    break;
                default:
            }
//            sc.close();

        }


    }
}
