import java.util.Scanner;

/**
 * @author panda
 * @description
 * @date 2020/3/15
 */
public class Test {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        input.close();

        Node[] puke = new Node[length];
        //init the Node
        for(int i=0; i<length; i++) {
            Node n = new Node();
            n.next = i+1;
            puke[i] = n;
        }
        puke[length-1].next = 0;
        //do
        for(int i=0, k=1;k<=length ;k++){
            int index = puke[i].next;
            puke[index].value = k;
            puke[i].next = puke[index].next;
            i = puke[i].next;
        }
       for (int i=0; i<length; i++)
           System.out.print(puke[i].value+" ");
        System.out.println("");
    }

    private static class Node{
        int value;
        int next;
    }
}
