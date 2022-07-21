package com.spring.miniproject.dao;

import com.spring.miniproject.domain.*;

import java.util.List;
import java.util.Map;


public interface UserDao {

	public int insertUser(UserDto userDto);
	public UserDto selectOneUser(String user_email);
	public int updateUserPassword(UserDto userDto);
	public int deleteOneUser(String user_email);
	public int updateProfileImage(UserProfileDto userProfileDto);
	public int updateImageOrigin(String user_email);
	public int selectUserAddressCnt(int user_id);
	public int selectUserId(String user_email);
	public int insertUserAddress(UserAddressDto userAdressDto);
	public List<UserAddressDto> selectUserAddress(int user_id);
	public int deleteUserAddress(Integer address_id);
	public int updateUserAddress(UserAddressDto userAddressDto);
	public List<UserAddressDto> selectAddressList(PageHandlerDto pageHandlerDto);
	public String selectUserEmail(Map map);
	public List<UserPurchaseDto> selectUserPurchase(PageHandlerDto pageHandlerDto);
	public Integer selectUserPurchaseCnt(Integer user_id);
	public int insertUserProductReview(ProductReviewDto productReviewDto);
	public int deleteUserProductReview(ProductReviewDto productReviewDto);
}
