package mapper;

import java.sql.ResultSet;

public interface RowMapper<T> {
	public T mapper(ResultSet rs);
}
