package com.inventine.dao.interface_;

import com.inventine.model.Payout;

import java.sql.SQLException;
import java.util.List;

public interface PayoutDaoInterface {

    public boolean create(Payout payout);

    public Payout getPayout(String transactionId);

    public List<Payout> getPayouts(String condition);

    public boolean update(Payout user);

    public int getCount(String condition) throws SQLException;

}