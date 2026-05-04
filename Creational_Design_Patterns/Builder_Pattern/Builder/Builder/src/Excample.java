public class Excample {
    private String id;
    private String name;
    private Long count;
    private String title;

    private Excample(Builder builder){
        this.id=builder.id;
        this.count= builder.count;
        this.name= builder.name;
        this.title= builder.title;
    }

    public static Builder builder(){
        return new Builder();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getCount() {
        return count;
    }

    public String getTitle() {
        return title;
    }

    public static class Builder{
        private String id;
        private String name;
        private Long count;
        private String title;

        public Builder id(String id){
            this.id=id;
            return this;
        }
        public Builder name(String name){
            this.name=name;
            return this;
        }
        public Builder count(Long count){
            this.count=count;
            return this;
        }
        public Builder title(String title){
            this.title=title;
            return this;
        }

        public Excample build(){
            return new Excample(this);
        }
    }

    @Override
    public String toString() {
        return "Excample{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", title='" + title + '\'' +
                '}';
    }
}
