package pe.example.customers.repository.implementation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import pe.example.customers.application.domain.Pagination;
import pe.example.customers.repository.interfaces.SQLHelper;
import pe.example.customers.application.domain.Customer;
import pe.example.customers.repository.interfaces.CustomerRepository;

@Repository
public class CustomerRepositoryImp implements CustomerRepository {

	@Autowired
	private SQLHelper sqlHelper;

	@Override
	public Customer getSearch(Map<String,Object> parametersJson) {
		Customer o = sqlHelper.getSearch("dbo.customer_search", parametersJson, new CustomerSearchRowMapper());

		return o;
	}

	@Override
	public List<Customer> getSearch(Map<String,Object> parametersJson, Pagination pagination) {
		List<Customer> l = sqlHelper.getSearch("dbo.customer_search", parametersJson, pagination, new CustomerSearchRowMapper());

		return l;
	}

	static class CustomerSearchRowMapper implements RowMapper<Customer> {
		@Override
		public Customer mapRow(ResultSet r, int row) throws SQLException {
			Customer o = new Customer();

			o.setId(r.getInt("id"));
			o.setTitle(r.getString("title"));
			o.setComment(r.getString("comment"));
			o.setAmountSell(r.getDouble("amount_sell"));
			o.setRegisterUserId(r.getInt("register_user_id"));
			o.setRegisterUserFullname(r.getString("register_user_fullname"));
			o.setRegisterDatetime(r.getTimestamp("register_datetime"));
			o.setActive(r.getBoolean("active"));

			return o;
		}
	}

	@Override
	public List<Customer> getFindAll(Map<String,Object> parametersJson, Pagination pagination) {
		List<Customer> l = sqlHelper.getFindAll("dbo.customer_find_all", parametersJson, pagination, new CustomerFindAllRowMapper());

		return l;
	}

	static class CustomerFindAllRowMapper implements RowMapper<Customer> {
		@Override
		public Customer mapRow(ResultSet r, int row) throws SQLException {
			Customer o = new Customer();

			o.setId(r.getInt("id"));
			o.setTitle(r.getString("title"));
			o.setComment(r.getString("comment"));
			o.setAmountSell(r.getDouble("amount_sell"));
			o.setRegisterUserId(r.getInt("register_user_id"));
			o.setRegisterUserFullname(r.getString("register_user_fullname"));
			o.setRegisterDatetime(r.getTimestamp("register_datetime"));
			o.setActive(r.getBoolean("active"));

			return o;
		}
	}

	@Override
	public void setInsertUpdate(Customer o) {
		Map<String, Object> parameters = new HashMap<String, Object>();

		parameters.put("id", o.getId());
		parameters.put("title", o.getTitle());
		parameters.put("comment", o.getComment());
		parameters.put("amount_sell", o.getAmountSell());
		parameters.put("register_user_id", o.getRegisterUserId());
		parameters.put("register_user_fullname", o.getRegisterUserFullname());
		parameters.put("register_datetime", o.getRegisterDatetime());
		parameters.put("active", o.getActive());

		int id = sqlHelper.setInsertUpdate("dbo.customer_insert_update", parameters);

		o.setId(id);
	}

}