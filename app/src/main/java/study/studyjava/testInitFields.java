package study.studyjava;

public class testInitFields {
    int a;
    int b;
    static int c;
    public static void main(String[] args){
        testInitFields tif1 = new testInitFields();
        System.out.println(tif1.a);

        testInitFields tif2 = new testInitFields(2);
        System.out.println(tif2.a);
        System.out.println(tif2.b);

    }
    static {
        if (1>2){
            c = 2;
        }
    }
    {
        a = 1;
    } // 会把这个区块复制到每个constructor里面
    private testInitFields(){

    } //看起来啥也没干
    private testInitFields(int x){
        b = x;
    }
}
