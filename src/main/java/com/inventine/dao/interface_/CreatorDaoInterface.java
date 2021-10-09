package com.inventine.dao.interface_;

import com.inventine.model.Creator;

import java.util.List;

public interface CreatorDaoInterface{

    public boolean create(Creator creator);

    public Creator getCreator(String creatorId);

    public List<Creator> getCreators();

    public boolean update(Creator creator);

}