import java.lang.reflect.Array;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String nameRegex = "[A-Za-z]";
        String distanceRegex = "[\\d]";
        Pattern namePattern = Pattern.compile(nameRegex);
        Pattern distancePattern = Pattern.compile(distanceRegex);

        Map<String, Integer> racers = new LinkedHashMap<>();
        for (String name : names) {
            racers.putIfAbsent(name, 0);
        }

        String line = scanner.nextLine();

        while (!line.equals("end of race")) {
            StringBuilder sb = new StringBuilder();

            Matcher nameMatcher = namePattern.matcher(line);
            while (nameMatcher.find()) {
                sb.append(nameMatcher.group());
            }
            if (names.contains(sb.toString())) {
                Matcher distanceMatcher = distancePattern.matcher(line);

                while (distanceMatcher.find()) {
                    int digit = Integer.parseInt(distanceMatcher.group());

                    racers.put(sb.toString(), racers.get(sb.toString()) + digit);
                }
            }

            line = scanner.nextLine();
        }

        List<String> sorted = racers.entrySet().stream().sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                .map(Map.Entry::getKey).collect(Collectors.toList());
        String text = "";
        for (int i = 0; i < sorted.size(); i++) {
            if (i == 3) {
                break;
            }
            if (i == 0) {
                text = "st";
            } else if (i == 1) {
                text = "nd";
            } else if(i == 2) {
                text = "rd";
            }
            System.out.printf("%d%s place: %s%n", i + 1, text, sorted.get(i));
        }


    }
}
