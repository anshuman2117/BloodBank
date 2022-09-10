package com.app.entities;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
 @Table(name = "events")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Event extends BaseEntity {
    @Column(length = 50)
	private String title;
    
	private String description;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate event_start_date;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date event_end_date;
	
	@DateTimeFormat(pattern = "hh:mm:ss")
	private Time event_start_time;
	
	@DateTimeFormat(pattern = "hh:mm:ss")
	private Time event_end_time;
	
	private String event_poster;
	
	
}
