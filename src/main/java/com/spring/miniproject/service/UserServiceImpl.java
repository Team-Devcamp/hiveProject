package com.spring.miniproject.service;

import com.spring.miniproject.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.miniproject.dao.UserDao;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public int insertUser(UserDto userDto) {
		return userDao.insertUser(userDto);
	}

	@Override
	public UserDto selectOneUser(String user_email) {
		return userDao.selectOneUser(user_email);
	}

	@Override
	public int updateUserPassword(UserDto userDto) {
		return userDao.updateUserPassword(userDto);
	}

	@Override
	public int deleteOneUser(String user_email) {
		return userDao.deleteOneUser(user_email);
	}

	@Override
	public int updateProfileImage(UserProfileDto userProfileDto) {
		return userDao.updateProfileImage(userProfileDto);
	}

	@Override
	public int updateImageOrigin(String user_email) {
		return userDao.updateImageOrigin(user_email);
	}

	@Override
	public int selectUserAddressCnt(int user_id) {
		return userDao.selectUserAddressCnt(user_id);
	}

	@Override
	public int selectUserId(String user_email) {
		return userDao.selectUserId(user_email);
	}

	@Override
	public int insertUserAddress(UserAddressDto userAdressDto) {
		return userDao.insertUserAddress(userAdressDto);
	}

	@Override
	public List<UserAddressDto> selectUserAddress(int user_id) {
		return userDao.selectUserAddress(user_id);
	}

	@Override
	public int deleteUserAddress(Integer address_id) {
		return userDao.deleteUserAddress(address_id);
	}

	@Override
	public int updateUserAddress(UserAddressDto userAddressDto) {
		return userDao.updateUserAddress(userAddressDto);
	}

	@Override
	public List<UserAddressDto> selectAddressList(PageHandlerDto pageHandlerDto) {
		return userDao.selectAddressList(pageHandlerDto);
	}

	@Override
	public String selectUserEmail(Map map) {
		return userDao.selectUserEmail(map);
	}

	@Override
	public List<UserPurchaseDto> selectUserPurchase(PageHandlerDto pageHandlerDto) {
		return userDao.selectUserPurchase(pageHandlerDto);
	}

	@Override
	public Integer selectUserPurchaseCnt(Integer user_id) {
		return userDao.selectUserPurchaseCnt(user_id);
	}

	@Override
	public int insertUserProductReview(ProductReviewDto productReviewDto) {
		return userDao.insertUserProductReview(productReviewDto);
	}

	@Override
	public int deleteUserProductReview(ProductReviewDto productReviewDto) {
		return userDao.deleteUserProductReview(productReviewDto);
	}

	@Override
	public List<ProductReviewDto> selectUserProductReview(PageHandlerDto pageHandlerDto) {
		return userDao.selectUserProductReview(pageHandlerDto);
	}

	@Override
	public int updateUserProductReview(ProductReviewDto productReviewDto) {
		return userDao.updateUserProductReview(productReviewDto);
	}

	@Override
	public String selectUserReviewImage(Map map) {
		return userDao.selectUserReviewImage(map);
	}

	@Override
	public int updateNewPassword(Map map) {
		return userDao.updateNewPassword(map);
	}

}

