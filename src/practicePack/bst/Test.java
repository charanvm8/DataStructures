package practicePack.bst;

public class Test {

    public int something(){
        Integer test = 10;
        something1(test);
        return test;
    }

    public void something1(Integer i){
        i = 20;
    }

    public static void main(String[] args) {
        Test tt = new Test();
        System.out.println(tt.something());
    }
}
