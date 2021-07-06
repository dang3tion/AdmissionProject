package dao;

import model.CollegesInfo;

import java.util.ArrayList;

public interface IFilterDAO {
    ArrayList<CollegesInfo> getList(String[]type);
}
