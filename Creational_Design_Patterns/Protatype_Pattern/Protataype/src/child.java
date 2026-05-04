public class child extends Father{

    int x;
    int y;

    public child(){}
    public child(child source) {
        super(source);
        this.x=source.x;
        this.y=source.y;
    }

    @Override
    Father cloneCustom() {
        return new child(this);
    }

    @Override
    public String toString() {
        return "child{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
