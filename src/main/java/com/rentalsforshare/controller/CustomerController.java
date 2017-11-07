package com.rentalsforshare.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rentalsforshare.common.util.Constants;
import com.rentalsforshare.config.token.HandlerToken;
import com.rentalsforshare.entity.Customer;
import com.rentalsforshare.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private HandlerToken handlerToken;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> login(@RequestBody Customer data) throws Exception {
		Customer customer = customerService.getByEmail(data.getEmail());
		if (customer != null && passwordEncoder.matches(data.getPassword(), customer.getPassword())) {
			Map<String, String> result = new HashMap<String, String>();
			result.put("id", customer.getId() + "");
			result.put("access_token",
					"Bearer " + handlerToken.createTokenForUser(Constants.STR_ROLE_USER + "-" + customer.getEmail()));
			result.put("email", customer.getEmail());
			result.put("username", customer.getUserName());
			result.put("avatar", customer.getAvatar());

			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/get-by-email", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> getByEmail(@RequestBody Customer data)
			throws Exception {
		Customer customer = customerService.getByEmail(data.getEmail());
		if (customer != null) {
			return new ResponseEntity<>(customer, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> registerCustomer(@RequestBody Customer data) throws Exception {
		if (customerService.getByEmail(data.getEmail()) != null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		data.setPassword(passwordEncoder.encode(data.getPassword()));
		if (customerService.inserCustomer(data)) {
			Map<String, String> result = new HashMap<>();
			result.put(Constants.STR_RESULT, Constants.STR_INSERT_SUCCESS);
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> updateCustomer(@RequestParam(required = true, defaultValue = "0", value = "id") int id,
			@RequestBody Customer data) throws Exception {
		if (customerService.getById(id) == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		if (customerService.updateCustomer(data)) {
			Map<String, String> result = new HashMap<>();
			result.put(Constants.STR_RESULT, Constants.STR_UPDATE_SUCCESS);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> deleteCustomer(@RequestParam(required = true, defaultValue = "0", value = "id") int id)
			throws Exception {
		if (customerService.getById(id) != null) {
			if (customerService.deleteCustomer(id)) {
				Map<String, String> result = new HashMap<>();
				result.put(Constants.STR_RESULT, Constants.STR_DELETE_SUCCESS);
				return new ResponseEntity<>(result, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
