public abstract class Father {
    int x;
    int y;

    Father(){}
    Father(Father sourse){
        this.x= sourse.x;
        this.y=sourse.y;
    }

    abstract Father cloneCustom();
}
