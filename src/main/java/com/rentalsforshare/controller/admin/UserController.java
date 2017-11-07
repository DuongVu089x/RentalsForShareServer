package com.rentalsforshare.controller.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rentalsforshare.common.util.Constants;
import com.rentalsforshare.config.token.HandlerToken;
import com.rentalsforshare.entity.admin.User;
import com.rentalsforshare.service.admin.UserService;

@RestController
@RequestMapping("api/admin/user")
public class UserController {

	@Autowired
	private HandlerToken handlerToken;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> login(@RequestBody User data) throws Exception {
		System.out.println(data.getEmail());
		User user = userService.getByEmail(data.getEmail());
		if (user != null && user.getPassword().equals(data.getPassword())) {
			Map<String, String> result = new HashMap<String, String>();
			result.put("id", user.getId() + "");
			result.put("access_token",
					"Bearer " + handlerToken.createTokenForUser(Constants.STR_ROLE_USER + "-" + user.getEmail()));
			result.put("email", user.getEmail());
			result.put("username", user.getUsername());
			result.put("avatar", user.getAvatar());
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
