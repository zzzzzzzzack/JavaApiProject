package zack.JavaApiTest.run;

import java.time.LocalDateTime;

public record Run2(
        Integer id,
        String title,
        LocalDateTime startedOn,
        LocalDateTime endedOn,
        Integer miles,
        Location location
) { }

