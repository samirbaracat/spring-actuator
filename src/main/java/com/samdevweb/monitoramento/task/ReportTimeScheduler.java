package com.samdevweb.monitoramento.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class ReportTimeScheduler {
    
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
     
    @Scheduled(fixedRate = 5000)
    public void currentTime() {
        log.info("Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
    }
    
}
