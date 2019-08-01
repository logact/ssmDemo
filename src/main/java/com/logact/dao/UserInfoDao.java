package com.logact.dao;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.logact.domain.UserInfo;

public interface UserInfoDao {
	@Select("select * from user_info ")
	public List<UserInfo> listAllUserInfo();

	@Select("select * from user_info where username=#{username}")
	public UserInfo selectByName(String username);

	@Update("UPDATE user_info = #{username} ,gender = #{gender} ,password = #{password} WHERE id = #{id}")
	public void update(UserInfo userInfo);

	@Insert("INSERT INTO user_info(username,gender,password)VALUES(#{name},#{gender},#{password})")
	public void save(UserInfo userInfo);

	@Select("select * from user_info where id=#{id}")
	public UserInfo findById(Integer id);

	@DeleteProvider(type = Provider.class, method = "batchDelete")
	public void delete(Integer[] id);

	class Provider {
		/* 批量删除 */
		public String batchDelete(Integer[] id) {
			StringBuilder sb = new StringBuilder();
			sb.append("DELETE FROM student WHERE id IN (");
			for (int i = 0; i < id.length; i++) {
				sb.append("'").append(id[i]).append("'");
				if (i < id.length - 1)
					sb.append(",");
			}
			sb.append(")");
			return sb.toString();
		}
	}

}
