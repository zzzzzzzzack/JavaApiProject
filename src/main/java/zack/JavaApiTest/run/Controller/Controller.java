package zack.JavaApiTest.run.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import zack.JavaApiTest.run.Run2;
import zack.JavaApiTest.run.RunRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/runs")
public class Controller {

    private final RunRepository runRepository;

    public Controller(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    // endpoint mapping scrambling? so no url injection can happen
    @GetMapping("/hello")
    String home() {
        return "Hello Runners!!";
    }

    @GetMapping("")
    List<Run2> runs() {
        return runRepository.findAll();
    }

    @GetMapping("/{id}")
    Run2 findById(@PathVariable Integer id) {
        Optional<Run2> run = runRepository.findById(id);
        if (run.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return run.get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void postRun(@RequestBody Run2 run) {
        runRepository.postRun(run);
    }

//    @GetMapping("/date")
//    Run2 findByDate(@PathVariable LocalDateTime dateTime) {
//        return runRepository.findByDate(dateTime);
//    }

}