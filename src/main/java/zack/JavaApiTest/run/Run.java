package zack.JavaApiTest.run;


import java.time.LocalDateTime;
import java.util.Objects;

// This is a POJO class that represents a Run object but is also naive in its implementation
public class Run {
    private Integer runnerId;
    private String title;
    private LocalDateTime startedOn;
    private LocalDateTime endedOn;
    private Integer miles;
    private String location;


    public Integer getRunnerId() {
        return runnerId;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getStartedOn() {
        return startedOn;
    }

    public LocalDateTime getEndedOn() {
        return endedOn;
    }

    public Integer getMiles() {
        return miles;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Run run = (Run) o;
        return Objects.equals(runnerId, run.runnerId) && Objects.equals(title, run.title) && Objects.equals(startedOn, run.startedOn) && Objects.equals(endedOn, run.endedOn) && Objects.equals(miles, run.miles) && Objects.equals(location, run.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(runnerId, title, startedOn, endedOn, miles, location);
    }


}

