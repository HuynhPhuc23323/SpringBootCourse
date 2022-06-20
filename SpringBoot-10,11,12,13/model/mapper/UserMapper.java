package milliwatt.phuc.restfulapi.usermanagement.model.mapper;

import milliwatt.phuc.restfulapi.usermanagement.entity.User;
import milliwatt.phuc.restfulapi.usermanagement.model.dto.UserDto;

public class UserMapper {
	
	public static UserDto toUserDto(User user) {
		UserDto tmp = new UserDto();
		tmp.setId(user.getId());
		tmp.setName(user.getName());
		tmp.setEmail(user.getEmail());
		tmp.setPhone(user.getPhone());
		tmp.setAvatar(user.getAvatar());
		
		return tmp;
	}
	
}
