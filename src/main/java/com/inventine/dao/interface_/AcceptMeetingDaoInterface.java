package com.inventine.dao.interface_;

import com.inventine.model.AcceptMeeting;

import java.util.List;

public interface AcceptMeetingDaoInterface{

    public boolean create(AcceptMeeting acceptMeeting);

    public AcceptMeeting getAcceptMeeting(String acceptMeetingId);

    public List<AcceptMeeting> getAllAcceptMeeting();

    public boolean update(AcceptMeeting acceptMeeting);

}