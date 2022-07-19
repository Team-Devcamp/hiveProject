package com.spring.miniproject.service;

import com.spring.miniproject.domain.EventDto;

import java.util.List;
import java.util.Map;

public interface EventService {
    List<EventDto> getAllEvent() throws Exception;

    EventDto readEvent(Integer event_id) throws Exception;

    int getCountEvent() throws Exception;

    int removeEvent(Integer event_id) throws Exception;

    int writeEvent(EventDto eventDto) throws Exception;

    int modifyEvent(EventDto eventDto) throws Exception;

    List<EventDto> getEventPage(Map map) throws Exception;
}
