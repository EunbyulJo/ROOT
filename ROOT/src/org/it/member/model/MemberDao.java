package org.it.member.model;

public interface MemberDao {
	public abstract int insertOne(MemberDto dto);
	public abstract MemberDto readOne(String id);
	public abstract int countMale();
	public abstract int countFemale();
}
