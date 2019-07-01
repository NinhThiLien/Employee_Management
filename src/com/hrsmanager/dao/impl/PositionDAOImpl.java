package com.hrsmanager.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrsmanager.dao.PositionDAO;
import com.hrsmanager.mapper.PositionMapper;
import com.hrsmanager.model.PositionInfo;

@Service
@Transactional
public class PositionDAOImpl extends JdbcDaoSupport implements PositionDAO{

	@Autowired
	public PositionDAOImpl (DataSource dataSource) {
		this.setDataSource(dataSource);
	}
	
	@Override
	public PositionInfo findPositionInfo(Integer position_id) {
		String sql = "select *from Positions p where p.position_id = ?";
		Object[]params = new Object[] {position_id};
		PositionMapper mapper = new PositionMapper();
		try {
			PositionInfo position = this.getJdbcTemplate().queryForObject(sql, params, mapper);
			return position;
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
}
