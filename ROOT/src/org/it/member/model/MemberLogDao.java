package org.it.member.model;

import java.util.HashMap;

public interface MemberLogDao {
	public abstract int insertOne(MemberLogDto logDto);
	public abstract int updateLog(String id);
	public abstract int updatePoint(String id);
}
