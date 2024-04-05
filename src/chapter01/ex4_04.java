public class ex4_04 {
    String title;
    String author;

    public ex4_04(String t) {
        title = t; author = "작자마상";
    }

    public ex4_04(String t, String a) {
        title = t; author = a;
    }

    public static void main(String[] args) {
        ex4_04 littlePrince = new ex4_04("어린왕자", "생텍쥐페리");
        ex4_04 loveStory = new ex4_04("춘향전");
        System.out.println(littlePrince.title + " " + littlePrince.author);
        System.out.println(loveStory.title + " " + loveStory.author);
    }
}
