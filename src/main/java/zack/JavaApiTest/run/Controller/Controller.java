package zack.JavaApiTest.run.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zack.JavaApiTest.run.Run2;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    @GetMapping("/hello")
    String home() {
        return "Hello Runners!!";
    }
}
