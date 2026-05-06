import Struct.File;
import Struct.Folder;

public class Main {
    public static void main(String[] args) {
        File file1 = new File("shukurjon.txt","Assalomu alaykum");
        File file2 = new File("Boqiyev.txt","Va alaykum assalom");

        Folder folder = new Folder("Java");
        folder.add(file1);
        folder.add(file2);


        Folder root = new Folder("root");
        root.add(folder);

        root.show();
    }
}