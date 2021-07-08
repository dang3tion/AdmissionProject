package dao;

import model.CollegesInfo;

import java.util.ArrayList;

public interface IFilterDAO {
    ArrayList<CollegesInfo> filter(String[] type);
}
