package com.app.service;

import java.util.List;

import com.app.entities.Center;
import com.app.entities.Event;

public interface IEventService {

	// to give the all  events(completed/scheduled)
	List<Event> listAllEvent();
	
//	to give all the upcoming/scheduled events
	List<Event> listUpcomingEvents();
	
	List<Event> listEventsByCenter(Center center);
	
	Event  createEvent(Event event);
	
	Event updateEvent(Event event);
	
	 void deleteEvent(Long id);
	
}
