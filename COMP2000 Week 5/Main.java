public class Main {
    public static void main(String[] args) {
        Container<?> strings = new Container<>();
        Container rawContainer = strings;
        rawContainer.add(1);
        System.out.println(rawContainer);
    }
}

