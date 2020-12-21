import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<String,String> testing = new HashMap<>();
        testing.put("charan","charan");
        testing.put("charan","harsha");
        System.out.println(testing.get("charan"));

    }
}
