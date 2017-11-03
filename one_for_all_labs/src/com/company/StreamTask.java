package com.company;

        import java.util.Comparator;
        import java.util.Map;
        import java.util.stream.Collectors;
        import java.util.stream.IntStream;

public class StreamTask {

    public static void main(String[] args) {
        Map<Integer, Integer> result = IntStream.of(1, 2, 3, 4, 5)
                .mapToObj(i -> i * 2)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toMap(i -> i, i -> i * 4));
    }
}
