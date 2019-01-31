package contactsDemo;

public class IdGenerator {
    static long id = 0;

    public static String getId(){
        id++;
        return id+"";
    }
}
