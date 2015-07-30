package org.it.guest.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReadService {

	@Autowired
	GuestDao dao;
	
	public List<GuestDto> service() {
		List<GuestDto> list = null;
		list = dao.readLatest();
		list = list.subList(0, 4);
		return list;
	}
}
