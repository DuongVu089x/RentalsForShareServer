package com.rentalsforshare.service.admin;

import com.rentalsforshare.entity.admin.User;

public interface UserService {
	User getByEmail(String email);
}
