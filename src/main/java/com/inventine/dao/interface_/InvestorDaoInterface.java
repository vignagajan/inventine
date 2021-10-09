package com.inventine.dao.interface_;

import com.inventine.model.Investor;

import java.util.List;

public interface InvestorDaoInterface{

    public boolean create(Investor investor);

    public Investor getInvestor(String investorId);

    public List<Investor> getInvestors();

    public boolean update(Investor investor);

}