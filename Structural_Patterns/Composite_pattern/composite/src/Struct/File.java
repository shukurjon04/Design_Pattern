package Struct;

import Interface.FileSystem;

import java.util.Arrays;

public class File implements FileSystem {

    private String name;

    private byte[] data;

    public File(String name,Object data){
        this.name=name;
        this.data=data.toString().getBytes();
    }

    @Override
    public void show() {
        String string = toString();
        System.out.println(string);
    }

    @Override
    public String toString() {
        return "File{" +
                "name='" + name + '\'' +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
