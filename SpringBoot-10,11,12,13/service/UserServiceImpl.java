package milliwatt.phuc.restfulapi.usermanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import milliwatt.phuc.restfulapi.usermanagement.entity.User;
import milliwatt.phuc.restfulapi.usermanagement.exception.NotFoundException;
import milliwatt.phuc.restfulapi.usermanagement.model.dto.UserDto;
import milliwatt.phuc.restfulapi.usermanagement.model.mapper.UserMapper;

@Component
public class UserServiceImpl implements UserService {

	private static ArrayList<User> users = new ArrayList<User>();

	static {

		users.add(new User(1, "Nguyen Van A", "anguyen@gmail.com", "09999999", "avatar", "123"));
		users.add(new User(2, "Nguyen Van B", "bnguyen@gmail.com", "09222222", "avatar", "456"));
		users.add(new User(3, "Nguyen Van C", "cnguyen@gmail.com", "09333333", "avatar", "789"));

	}

	@Override
	public List<UserDto> getListUser() {
		List<UserDto> result = new ArrayList<UserDto>();
		for (User user : users) {
			result.add(UserMapper.toUserDto(user));
		}
		return result;
	}

	@Override
	public UserDto getUserById(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return UserMapper.toUserDto(user);
			}
		}
		throw new NotFoundException("User not exist in the system");
	}

	@Override
	public List<UserDto> searchUser(String keyword) {
		List<UserDto> result = new ArrayList<UserDto>();
		for (User user : users) {
			if (user.getName().contains(keyword)) {
				result.add(UserMapper.toUserDto(user));
			}
		}
		return result;
	}

}
