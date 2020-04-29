package introToAlgosDataStructures.sets;

public class SetsImplementation {
    Integer[] stack = new Integer[256];
    int top = -1;
    int peek = -1;
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;


    public int peek() {
        if(top==-1){
            return -1;
        }
        return stack[top];
    }

    public int pop() {
        if(top!=-1){
            int end = stack[top];
            stack[top--]=0;
            peek = stack[top];
            return end;
        }
        return -1;
    }

    public void push(Integer number) {
        stack[++top] = number;
        peek = stack[top];
        if(number>max){
            max=number;
        }
        if(number<min){
            min=number;
        }
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public static void main(String[] args) {
        SetsImplementation s = new SetsImplementation();
        s.push(2);
        s.push(7);
        s.push(1);
        s.push(8);
        s.push(3);
        System.out.println(s.getMin());
        System.out.println(s.min);
        System.out.println(s.getMax());
        System.out.println(s.max);
        System.out.println(s.peek());
        System.out.println(s.peek);


    }

}
