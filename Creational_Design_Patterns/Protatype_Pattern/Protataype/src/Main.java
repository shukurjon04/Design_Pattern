
public class Main {
    public static void main(String[] args) {
        child child= new child();
        child.x=10;
        child.y=20;


        child child1 = (child) child.cloneCustom();

        System.out.println("1- "+child);
        System.out.println("2- "+child1);

    }
}