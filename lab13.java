import java.util.ArrayList;

public class lab13 {
    private ArrayList<Integer> data = new ArrayList<>();

    public void readData(String filename) {
        try {
            java.io.BufferedReader input = new java.io.BufferedReader(
                new java.io.InputStreamReader(new java.io.FileInputStream(filename)));
            String inn;
            while ((inn = input.readLine()) != null) {
                data.add(Integer.valueOf(inn.trim()));
            }
            input.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public long getTotalCount() {
        return data.stream().count();
    }

    public long getOddCount() {
        return data.stream().filter(n -> n % 2 != 0).count();
    }

    public long getEvenCount() {
        return data.stream().filter(n -> n % 2 == 0).count();
    }

    public long getDistinctGreaterThanFiveCount() {
        return data.stream().distinct().filter(n -> n > 5).count();
    }

    public Integer[] getResult1() {
        return data.stream()
                   .filter(n -> n > 5 && n < 50 && n % 2 == 0)
                   .sorted()
                   .toArray(Integer[]::new);
    }

    public Integer[] getResult2() {
        return data.stream()
                   .map(n -> n * n * 3)
                   .limit(50)
                   .toArray(Integer[]::new);
    }

    public Integer[] getResult3() {
        return data.stream()
                   .filter(n -> n % 2 != 0)
                   .map(n -> n * 2)
                   .sorted()
                   .skip(20)
                   .distinct()
                   .toArray(Integer[]::new);
    }
}