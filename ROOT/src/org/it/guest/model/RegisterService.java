package org.it.guest.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterService {

	@Autowired
	GuestDao dao;
	
	public int service(GuestDto dto) {
		int r = dao.insertOne(dto);
		return r;
	}
}
