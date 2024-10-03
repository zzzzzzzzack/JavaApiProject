package zack.JavaApiTest.run;


import jakarta.annotation.PostConstruct;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RunRepository {
    private List<Run2> runs = new ArrayList<>();

    List<Run2> findAll() {
        return runs;
    }

    @PostConstruct
    private void init() {
        runs.add(new Run2(1, "First Run", LocalDateTime.now(), LocalDateTime.now().plusHours(1), 5, Location.OUTDOORS));

        runs.add(new Run2(2, "Second Run", LocalDateTime.now(), LocalDateTime.now().plusHours(2), 10, Location.INDOOR));

    }

}
