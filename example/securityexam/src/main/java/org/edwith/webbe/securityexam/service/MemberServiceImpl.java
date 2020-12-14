package org.edwith.webbe.securityexam.service;

import java.util.ArrayList;
import java.util.List;

import org.edwith.webbe.securityexam.service.security.UserEntity;
import org.edwith.webbe.securityexam.service.security.UserRoleEntity;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

	@Override
	public UserEntity getUser(String loginUserId) {
		return new UserEntity("carami", "$2a$10$yqrziWvwHJRaxJHFVhjhK.Kykz8hOHCZzfyHV2B25YWz8/zz6SW.K");	
	}
	
	@Override
	public List<UserRoleEntity> getUserRoles(String loginUserId){
		List<UserRoleEntity> list = new ArrayList<>();
		list.add(new UserRoleEntity("carami", "ROLE_USER"));
		return list;
	}
}
