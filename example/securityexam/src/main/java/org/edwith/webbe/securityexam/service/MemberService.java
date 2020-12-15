package org.edwith.webbe.securityexam.service;

import java.util.List;

import org.edwith.webbe.securityexam.dto.Member;
import org.edwith.webbe.securityexam.service.security.UserDbService;
import org.edwith.webbe.securityexam.service.security.UserEntity;
import org.edwith.webbe.securityexam.service.security.UserRoleEntity;

public interface MemberService extends UserDbService {
	public UserEntity getUser(String loginUserId);
	public List<UserRoleEntity> getUserRoles(String loginUserId);
	public Member getMemberByEmail(String loginId);
	//public void addMember(Member member, boolean bool);
}
