package org.it.guest.model;

import java.util.List;

public interface GuestDao {
	public abstract int insertOne(GuestDto dto);
	public abstract List<GuestDto> readLatest();
}
