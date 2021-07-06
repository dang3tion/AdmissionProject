package dao;

import model.CollegesInfo;

import java.util.ArrayList;

public interface ISearchDAO {
    ArrayList<CollegesInfo> getList(String keyword);
}
