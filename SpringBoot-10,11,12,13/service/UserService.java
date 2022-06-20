package milliwatt.phuc.restfulapi.usermanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import milliwatt.phuc.restfulapi.usermanagement.entity.User;
import milliwatt.phuc.restfulapi.usermanagement.model.dto.UserDto;

@Service
public interface UserService {

	List<UserDto> getListUser();

	UserDto getUserById(int id);
	
	List<UserDto> searchUser(String keyword);
	
}
