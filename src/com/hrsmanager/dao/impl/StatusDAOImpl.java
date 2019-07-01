package com.hrsmanager.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrsmanager.dao.StatusDAO;
import com.hrsmanager.mapper.StatusMapper;
import com.hrsmanager.model.Status;

@Service
@Transactional
public class StatusDAOImpl extends JdbcDaoSupport implements StatusDAO {

	@Autowired
	public StatusDAOImpl (DataSource dataSource) {
		this.setDataSource(dataSource);
	}
		
	@Override
	public Status findStatus(Integer status_id) {
		String sql = "select *from Status s where s.status_id = ?";
		Object[]params = new Object[] {status_id};
		StatusMapper mapper = new StatusMapper();
		try {
			Status status = this.getJdbcTemplate().queryForObject(sql, params, mapper);
			return status;
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
}
