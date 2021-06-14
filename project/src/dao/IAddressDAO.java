package dao;

import model.AddressDetail;

public interface IAddressDAO {
	public boolean insertAddress(AddressDetail address,String id);
}
