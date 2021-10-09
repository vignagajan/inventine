package com.inventine.dao.interface_;

import com.inventine.model.Meeting;

import java.util.List;

public interface MeetingDaoInterface{

    public boolean create(Meeting meeting);

    public Meeting getMeeting(String meetingId);

    public List<Meeting> getMeetings();

    public boolean update(Meeting meeting);
}