package pe.example.customers.service.implementation;

import java.util.List;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.example.customers.repository.interfaces.CustomerRepository;
import pe.example.customers.service.interfaces.CustomerService;
import pe.example.customers.application.domain.Customer;
import pe.example.customers.application.domain.Pagination;

@Service
public class CustomerServiceImp implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer getSelect(int id) {
		Map<String, Object> parameters = new HashMap<String, Object>();

		parameters.put("id",id);

		return customerRepository.getSearch(parameters);
	}

	@Override
	public List<Customer> getSelect(int id, Pagination pagination) {
		Map<String, Object> parameters = new HashMap<String, Object>();

		if(id > 0) parameters.put("id",id);

		return customerRepository.getSearch(parameters, pagination);
	}

	@Override
	public List<Customer> getList(int id, Pagination pagination) {
		Map<String, Object> parameters = new HashMap<String, Object>();

		if(id > 0) parameters.put("id",id);

		return customerRepository.getFindAll(parameters, pagination);
	}

	@Override
	public void setRegister(Customer o) {
		o.setRegisterDatetime(new Date());
		o.setActive(true);
		
		customerRepository.setInsertUpdate(o);
	}

	@Override
	public void setUpdate(int id,Customer o) {
		o.setId(id);
		o.setRegisterDatetime(new Date());
		
		customerRepository.setInsertUpdate(o);
	}

}