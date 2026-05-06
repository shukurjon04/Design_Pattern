package Struct;

import Interface.FileSystem;

import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystem {

    private String name;
    private List<FileSystem> files = new ArrayList<>();

    public Folder(String name){
        this.name=name;
    }

    public void add(FileSystem file){
        files.add(file);
    }
    public void remove(FileSystem file){
        files.remove(file);
    }


    @Override
    public void show() {
        System.out.println("Folder "+name);
        for (FileSystem item : files){
            item.show();
        }
    }


}
