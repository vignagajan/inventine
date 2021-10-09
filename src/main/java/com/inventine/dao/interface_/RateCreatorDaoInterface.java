package com.inventine.dao.interface_;

import com.inventine.model.RateCreator;

import java.util.List;

public interface RateCreatorDaoInterface{

    public boolean create(RateCreator rateCreator);

    public RateCreator getRateCreator(String rateCreatorId);

    public List<RateCreator> getRateCreators();

    public boolean update(RateCreator rateCreator);

}