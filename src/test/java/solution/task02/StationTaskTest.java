package solution.task02;

import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

public class StationTaskTest {

  @Test
  public void getStationByTwoFirstLettersSa() {
    test("СА",
        new StationTask.Station("САНКТ-ПЕТЕРБУРГ"),
        new StationTask.Station("САМАРА")
    );
  }

  @Test
  public void getStationByTwoFirstLettersMo() {
    test("МО",
        new StationTask.Station("МОСКВА"),
        new StationTask.Station("МОЖКА"),
        new StationTask.Station("МОЗДОК"),
        new StationTask.Station("МОСКВА")
    );
  }

  private void test(String preffix, StationTask.Station... expected) {
    StationTask stationTask = new StationTask(StationTask.STATION_LIST);
    Collection<StationTask.Station> ca = stationTask.getStationByTwoFirstLetters(preffix);
    StationTask.Station[] actual = ca.toArray(new StationTask.Station[ca.size()]);

    assertArrayEquals(expected, actual);
  }
  
}