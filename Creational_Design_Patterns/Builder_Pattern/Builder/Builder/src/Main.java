public class Main {
    public static void main(String[] args) {

        Excample build = Excample.builder()
                .name("Shukurjon")
                .id("2153")
                .count(52665L)
                .title("excapmle")
                .build();

        System.out.println(build);
    }
}