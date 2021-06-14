package dao;

import java.util.List;

import mapper.RowMapper;

public interface IGenericDAO<T> {
	public List<T> query(String sql, RowMapper<T> mapper, Object...params); 
	public boolean update(String sql, Object... params);
	public int insert(String sql, Object... params);
	public boolean delete(String sql, Object...params);
	public int count(String sql, Object...params);
	public T get(String sql, Object...params);
}
