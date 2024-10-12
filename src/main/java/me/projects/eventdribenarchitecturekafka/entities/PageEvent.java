package me.projects.eventdribenarchitecturekafka.entities;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class PageEvent {
    private String name;
    private String user;
    private Date date;
    private Long duration;
}
