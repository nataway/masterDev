public class MyException extends Exception {
    private int a;
    private int b;
    private int c;

    public MyException(int a, int b, int c) {
      this.a = a;
      this.b = b;
      this.c = c;
    }

    public String toString() {
        return "3 canh khong hop le";
    }
}