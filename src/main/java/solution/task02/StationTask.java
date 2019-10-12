package solution.task02;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class StationTask {
  public static final List<Station> STATION_LIST = Arrays.asList(
      new Station("МОСКВА"),
      new Station("МОЖКА"),
      new Station("МОЗДОК"),
      new Station("САНКТ-ПЕТЕРБУРГ"),
      new Station("МОСКВА"),
      new Station("САМАРА")
  );

  private final Map<String, List<Station>> mapStations;

  public StationTask(List<Station> stationList) {
    mapStations = stationList.stream()
        .collect(Collectors.groupingBy(s -> s.getName().substring(0, 2)));
  }

  public Collection<Station> getStationByTwoFirstLetters(String prefix) {
    return mapStations.get(prefix);
  }

  public static class Station {
    private String name;

    public Station(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o)
        return true;
      if (o == null || getClass() != o.getClass())
        return false;
      Station station = (Station) o;
      return Objects.equals(name, station.name);
    }

    @Override
    public int hashCode() {
      return Objects.hash(name);
    }

    @Override
    public String toString() {
      return "Station{" +
          "name='" + name + '\'' +
          '}';
    }
  }

}
