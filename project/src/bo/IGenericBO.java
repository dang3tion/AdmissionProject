package bo;

public interface IGenericBO<T> {
	public int insert(T t);
	public boolean update(T t);
	public boolean delete(T t);
	public T get(int id);
}
