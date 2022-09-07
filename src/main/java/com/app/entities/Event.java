package com.app.entities;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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
	private Date event_start_date;
	private Date event_end_date;
	private Time event_start_time;
	private Time event_end_time;
	private String event_poster;
	
	
}
