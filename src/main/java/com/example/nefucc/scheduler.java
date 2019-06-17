package com.example.nefucc;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
public class scheduler {
@Scheduled(fixedRate = 60*60*1000*24)
    void remind(){
    LocalDateTime.now(Clock.system(ZoneId.of("Asia/Shanghai")));
}
}
