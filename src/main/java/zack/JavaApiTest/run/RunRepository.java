package zack.JavaApiTest.run;


import jakarta.annotation.PostConstruct;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RunRepository {

    private List<Run2> runs = new ArrayList<>();

    public Optional<Run2> findById(Integer id) {
        return runs.stream()
                .filter(run -> run.id() == id)
                .findFirst();
    }

    public void postRun(Run2 run) {
        runs.add(run);
    }

//    public Run2 findByDate(LocalDateTime dateTime) {
//        return runs.stream()
//                filter(run -> run.date())
//    }

    public List<Run2> findAll() {
        return runs;
    }

    @PostConstruct
    private void init() {
        runs.add(new Run2(1, "First Run", LocalDateTime.now(), LocalDateTime.now().plusHours(1), 5, Location.OUTDOORS));

        runs.add(new Run2(2, "Second Run", LocalDateTime.now(), LocalDateTime.now().plusHours(2), 10, Location.INDOOR));
    }

}
