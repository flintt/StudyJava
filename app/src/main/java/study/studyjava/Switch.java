package study.studyjava;

public class Switch {
    int a = 5;
    int b = 6;
    public Switch(int x, int y){
        a = x;
        b = y;
    }

    /**
     *
     * @param s 被增加的对象
     * @param x
     * @param y
     */
    public void changeAB(Switch s, int x, int y){
//        Switch s;
        s.a = s.a + x;
        s.b = s.b + y;

        s = new Switch(1,1); // 这里给s

    }
    public static void main(String[] args) {
        int a = 3;
        int b = 4;
        Switch s1 = new Switch(10,20);
//        s1.switchValue();
//        s1.switchValue(a, b);
        System.out.println(s1.a);
        System.out.println(s1.b);
        s1.changeAB(s1,5,5);
        System.out.println(s1.a);
        System.out.println(s1.b);
    }
    public void switchValue(){
        int tmp;
        tmp = this.a;
        this.a = this.b;
        this.b = tmp;
    }
    public void switchValue(int a, int b){
        int tmp;
        tmp = a;
        a = b;
        b = tmp;
    } // 会交换失败
}
