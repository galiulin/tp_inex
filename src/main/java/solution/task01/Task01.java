package solution.task01;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Task01 {
  
  /** при недостаточной длине строки, дополняет ее лидирующими нулями*/
  private static final BiFunction<String, Integer, String> leadingZeros = (s, length) -> s.length() >= length ? s : String.format("%0" + (length - s.length()) + "d%s", 0, s);
  /**
   * меняем версию для naturalOrder <br>
   * param s модифицируемое значение <br>
   * param i максимальное количество знаков в сегменте
   */
  private static final BiFunction<String, Integer, String> modifyVersion = (s, i) -> Arrays.stream(s.split("\\.")).map(l -> leadingZeros.apply(l, i)).collect(Collectors.joining("."));

  public static String[] sortVersions(String[] versions) {
    return Arrays.stream(versions)
        .map(s -> new Pair<>(s, modifyVersion.apply(s, 6))) //создаем пары оригинальное значение и модифицированное (@see modifyVersion)
        .sorted(Comparator.comparing(Pair::getValue)) //сортируем пары по модифицированным значениям
        .map(Pair::getKey).toArray(String[]::new); //извлекаем из пары оригинальное значение и собираем в массиве
  }
}
