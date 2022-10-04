import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<Integer> arr =new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        System.out.println(arr.size());
        System.out.println(arr.get(0));
        List<Integer> integers = arr.subList(0, 3);
        System.out.println(integers);
    }
}
