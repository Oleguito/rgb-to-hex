import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите цвет в формате RGB: ");
        String[] input;
        try {
            input = scanner.nextLine().trim().split(", ");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String buffer = "";
        for(String s : input) {
            int val = 0;
            try {
                val = Math.min(Integer.parseInt(s), 255);
            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
            }
            int v0 = val % 16;
            int v1 = val / 16;
            buffer += convert(v1) + convert(v0);
        }
        System.out.println(buffer);
    }

    static String convert(int val) {
        String[] vals = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        return vals[val];
    }
}