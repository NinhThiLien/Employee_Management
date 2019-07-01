package com.hrsmanager.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrsmanager.dao.RoleDAO;
import com.hrsmanager.mapper.RoleMapper;
import com.hrsmanager.model.Roles;

@Service
@Transactional
public class RoleDAOImpl extends JdbcDaoSupport implements RoleDAO{
	
	@Autowired
	public RoleDAOImpl (DataSource dataSource) {
		this.setDataSource(dataSource);
	}
	
	@Override
	public Roles findRoles(Integer role_id) {
		String sql = "select *from Roles r where r.role_id = ?";
		Object[]params = new Object[] {role_id};
		RoleMapper mapper = new RoleMapper();
		try {
			Roles role = this.getJdbcTemplate().queryForObject(sql, params, mapper);
			return role;
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
}
