package com.company;

import java.math.BigInteger;
import java.util.*;

import static java.util.Collections.emptyList;
import static java.util.Comparator.*;

public class Main {

    static class Result {
        private List<BigInteger> result;
        private Integer shift;

        Result(List<BigInteger> result, Integer shift) {
            this.result = result;
            this.shift = shift;
        }

        BigInteger firstNumber() {
            return result.get(0);
        }
    }

    static class Sequence {

        Optional<Result> indexOf(String subString) {

            //Получение результатов i-позиция j-сдвиг
            List<Result> result = new ArrayList<>();
            for (int i = 1; i <= subString.length(); i++) {
                for (int j = 0; j < i; j++) {
                    List<BigInteger> numbers = getSequenceFromString(subString, i, j,
                            result.isEmpty() ? new BigInteger(subString) : result.get(result.size() - 1).result.get(0));
                    if (!numbers.isEmpty()) {
                        result.add(new Result(numbers, j));
                    }
                }
            }
            return result
                    .stream() //конвейер
                    .sorted(comparing(Result::firstNumber))
                    .findFirst();
        }

        //Разбивает подстроку на последовательность чисел
        private List<BigInteger> getSequenceFromString(String subString, int numberLength, int offset,
                                                       BigInteger firstShouldLessThan) {
            List<BigInteger> result = new ArrayList<>();
            int index = offset; //смещение
            int innerLength = numberLength;

            
            //Разбиваем последовательность на числа
            while (index + innerLength <= subString.length()) { //index-номер символа, с которого начинаю чтение подстроки
                String numberStr = subString.substring(index, index + innerLength);
                if (numberStr.startsWith("0")) {
                    return emptyList();
                }
                result.add(new BigInteger(numberStr));
                if (result.size() > 1 && !lastNumbersAreSequent(result)) {
                    return emptyList();
                }
                if (index == 0) {
                    if (result.get(0).compareTo(firstShouldLessThan) > 0) { //передаем первое число из предыдущего результата. если текущее больше - не подходит
                        return emptyList();
                    }
                }
                index+=innerLength;
                if (result.get(result.size() - 1).toString().matches("9+")) {
                    innerLength++;
                }
            }

            //Добавляем число в конец последовательности
            if (index != subString.length()) {
                String prefix = subString.substring(index);
                if (prefix.startsWith("0")) {
                    result.add(BigInteger.ZERO);
                } else {
                    if (result.isEmpty()) {
                        result.add(new BigInteger(subString.substring(index) +
                                new BigInteger(subString.substring(0, index)).add(BigInteger.ONE)));
                    } else {
                        result.add(appendAfter(result.get(result.size() - 1), //берем из результатов последнее число
                                new BigInteger(prefix)));
                    }
                }

                if (result.size() > 1 && !lastNumbersAreSequent(result)) {
                    return emptyList();
                }
            }

            //Добавляем число в начало последовательности
            if (offset != 0) {
                result.add(0, appendBefore(result.get(0), new BigInteger(subString.substring(0, offset))));
                if (result.get(0).compareTo(firstShouldLessThan) >= 0 ||
                        result.size() > 1 && !firstNumbersAreSequent(result)) {
                    return emptyList();
                }
            }
            return result;
        }

        //Проверяем, действительно ли это последовательность натуральных чисел
        private boolean lastNumbersAreSequent(List<BigInteger> numbers) {
            if (numbers.isEmpty())
                return false;
            if (numbers.size() == 1)
                return true;
            BigInteger lastNumber = numbers.get(numbers.size() - 1);
            BigInteger prevNumber = numbers.get(numbers.size() - 2);
            return lastNumber.subtract(prevNumber).equals(BigInteger.ONE);
        }

        private boolean firstNumbersAreSequent(List<BigInteger> numbers) { //числа последовательные
            if (numbers.isEmpty())
                return false;
            if (numbers.size() == 1)
                return true;
            BigInteger firstNumber = numbers.get(0);
            BigInteger secondNumber = numbers.get(1);
            return firstNumber.compareTo(BigInteger.ZERO) > 0 &&
                    secondNumber.compareTo(BigInteger.ZERO) > 0 &&
                    secondNumber.subtract(firstNumber).equals(BigInteger.ONE);
        }

        //Добавляет число слева при ненулевом сдвиге
        private BigInteger appendBefore(BigInteger first, BigInteger suffix) {
            if (first.compareTo(BigInteger.ZERO) <= 0 || suffix.compareTo(BigInteger.ZERO) <= 0) {
                return BigInteger.ZERO;
            }
            String probablyPrev = first.subtract(BigInteger.ONE).toString();
            String suffixStr = suffix.toString();
            if (!probablyPrev.endsWith(suffixStr)) {
                return BigInteger.ZERO;
            }
            return new BigInteger(probablyPrev.substring(0, probablyPrev.length() - suffixStr.length()) + suffixStr);
        }

        //Добавляет число справа, если не удается в конце считать полное число
        private BigInteger appendAfter(BigInteger firstNumber, BigInteger prefix) {
            BigInteger probablyNext = firstNumber.add(BigInteger.ONE);
            String prefixStr = prefix.toString();
            return new BigInteger(prefixStr + probablyNext.toString().substring(prefixStr.length()));
        }

    }

    //Получение индекса в общей последовательности
    private static BigInteger getItemPosition(BigInteger item) {
        BigInteger position = BigInteger.ZERO;
        int itemLen = item.toString().length();
        for (int i = 1; i < itemLen; i++) {
            position = position.add(
                    BigInteger.valueOf(i * 9).multiply(BigInteger.TEN.pow(i - 1)));
        }
        BigInteger offset = item.subtract(BigInteger.TEN.pow(itemLen - 1));
        return position.add(offset.multiply(BigInteger.valueOf(itemLen))).add(BigInteger.ONE);
    }

    public static void main(String[] args) {
        try(Scanner s = new Scanner(System.in)) {
            while (s.hasNext()) {
                String subString = s.nextLine();
                if (!subString.matches("\\d+")) {
                    System.err.println("Неверный формат последовательности");
                    continue;
                }
                long from = System.nanoTime();
                Optional<Result> resultOptional = new Sequence().indexOf(subString);
                long until = System.nanoTime();

                if (!resultOptional.isPresent()) {
                    System.err.println("Последовательность не найдена??");
                    continue;
                }
                Result result = resultOptional.get();
                BigInteger position = getItemPosition(result.firstNumber());
                //Если есть сдвиг, то прибавляем длину до исходной подпоследовательности
                if (result.shift != 0 ) {
                    position = position.add(BigInteger.valueOf(result.firstNumber().toString().length() - result.shift));
                }
                System.out.println("Подпоследовательность - " + subString);
                System.out.println("Промежуток - " + result.result);
                System.out.println("Индекс - " + position);
                System.out.println("Время (нс) - " + (until - from));
                System.out.println("--------------------------------");
            }
        }
    }
}
