package pe.example.customers.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.example.customers.api.response.PaginationResponse;
import pe.example.customers.api.query.CustomerQuery;
import pe.example.customers.api.request.CustomerRequest;
import pe.example.customers.api.response.CustomerResponse;
import pe.example.customers.application.domain.Customer;
import pe.example.customers.application.mapper.CustomerMapper;
import pe.example.customers.service.interfaces.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/{id}")
	public ResponseEntity<CustomerResponse> getSelect(@PathVariable int id) {
		Customer o = customerService.getSelect(id);

		if(o==null) return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);

		return new ResponseEntity<CustomerResponse>(CustomerMapper.ToSelectCustomerResponse(o),HttpStatus.OK);
	}

	@GetMapping("/search")
	public ResponseEntity<List<CustomerResponse>> getSelect(CustomerQuery q) {
		List<Customer> l = customerService.getSelect(q.getId(),q.getPagination());

		return new ResponseEntity<List<CustomerResponse>>(CustomerMapper.ToArraySelectCustomerResponse(l),HttpStatus.OK);
	}

	@GetMapping("/find-all")
	public ResponseEntity<PaginationResponse<CustomerResponse>> getList(CustomerQuery q) {
		List<Customer> l = customerService.getList(q.getId(),q.getPagination());

		return new ResponseEntity<PaginationResponse<CustomerResponse>>(new PaginationResponse<CustomerResponse>(q.getPagination(),CustomerMapper.ToArrayListCustomerResponse(l)),HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<CustomerResponse> setRegister(@RequestBody CustomerRequest r) {
		Customer o = CustomerMapper.FromCustomerRequest(r);

		customerService.setRegister(o);

		return new ResponseEntity<CustomerResponse>(CustomerMapper.ToRegisterCustomerResponse(o),HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CustomerResponse> setUpdate(@PathVariable int id,@RequestBody CustomerRequest r) {
		Customer o = CustomerMapper.FromCustomerRequest(r);

		customerService.setUpdate(id,o);

		return new ResponseEntity<CustomerResponse>(CustomerMapper.ToRegisterCustomerResponse(o),HttpStatus.OK);
	}

}