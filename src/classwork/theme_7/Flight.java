package classwork.theme_7;

import java.time.LocalDate;

public interface Flight extends Comparable<Flight> {
    String getCode();
    String getDestination();
    LocalDate getDate();
    int getNumPassengers();

}
