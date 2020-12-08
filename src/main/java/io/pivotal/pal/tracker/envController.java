package io.pivotal.pal.tracker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.*;
import java.util.Map;
import java.util.HashMap;


@RestController
public class envController {

    private final String port ;
    private final String memoryLimit;
    private final String cfInstanceIndex ;
    private final String cfInstanceAddress ;

    private envController(@Value("${port:NOT SET}") String port,
                          @Value("${memoryLimit:NOT SET}") String memoryLimit,
                          @Value("${cf.instance.index:NOT SET}") String cfInstanceIndex,
                          @Value("${cf.instance.address:NOT SET}") String cfInstanceAddress
    )
    {
        this.port =  port;
        this.memoryLimit = memoryLimit;
        this.cfInstanceIndex = cfInstanceIndex;
        this.cfInstanceAddress = cfInstanceAddress;
    }

    @GetMapping("/env")
    public Map<String, String> gerEnv() {
        Map<String, String> env = new HashMap<>();
        env.put("PORT", this.port);
        env.put("MEMORY_LIMIT", this.memoryLimit);
        env.put("CF_INSTANCE_INDEX", this.cfInstanceIndex);
        env.put("CF_INSTANCE_ADDR", this.cfInstanceAddress);
        return env;
    }
}