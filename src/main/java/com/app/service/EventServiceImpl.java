package com.app.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IEventDao;
import com.app.entities.Center;
import com.app.entities.Event;

@Service
@Transactional
public class EventServiceImpl implements IEventService {

	@Autowired
	private IEventDao eventDao;

	
	// to list all the event from start to end
	@Override
	public List<Event> listAllEvent() {
		
		return eventDao.findAll();
	}

	// to list the upcoming  events
	@Override
	public List<Event> listUpcomingEvents() {
		return eventDao.findFutureEvents(LocalDate.now());
	}

	@Override
	public List<Event> listEventsByCenter(Center center) {
		
		return eventDao.findByCity(center.name());
	}

	@Override
	public Event createEvent(Event event) {
		// TODO Auto-generated method stub
		return eventDao.save(event);
	}

	@Override
	public Event updateEvent(Event event) {
		return eventDao.save(event);
	}

	@Override
	public void deleteEvent(Long id) {
		eventDao.deleteById(id);
		
	}

	
}
