import java.util.*;
import java.util.stream.Collectors;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> numList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble).collect(Collectors.toList());

        Map<Double, Integer> countsNumbersMap = new TreeMap<>();

        for (int i = 0; i < numList.size(); i++) {
         double currentNum = numList.get(i);

    if(countsNumbersMap.containsKey(currentNum)){
        countsNumbersMap.put(currentNum,countsNumbersMap.get(currentNum) + 1);
    }else{
        countsNumbersMap.put(currentNum, 1);
    }

        }
        for (Map.Entry<Double, Integer> entry : countsNumbersMap.entrySet()) {
            System.out.printf("%.0f -> %d%n", entry.getKey(), entry.getValue());
        }


    }
}
