package Consumer;

public class Ejercicio7 {

    interface Operar{
        int opera(int a,int b);
    }

    public static void main(String[] args) {
        Operar mult=(int a, int b)->(a*b);
        System.out.println(mult.opera(9,-7));
    }
}
