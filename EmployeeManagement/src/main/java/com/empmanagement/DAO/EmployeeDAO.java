/*
 * COPYRIGHT. HSBC HOLDINGS PLC 2018. ALL RIGHTS RESERVED.
 *
 * This software is only to be used for the purpose for which it has been provided. No part of it is to be reproduced,
 * disassembled, transmitted, stored in a retrieval system nor translated in any human or computer language in any way or for any
 * other purposes whatsoever without the prior written consent of HSBC Holdings plc.
 */
package com.empmanagement.DAO;

import java.util.List;

import com.empmanagement.model.EmployeeDTO;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// @RepositoryRestResource
// @EnableJpaRepositories
public class EmployeeDAO implements JpaRepository<EmployeeDTO, Integer> {

	@Override
	public Page<EmployeeDTO> findAll(Pageable arg0) {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {

		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Integer arg0) {

		// TODO Auto-generated method stub

	}

	@Override
	public void delete(EmployeeDTO arg0) {

		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends EmployeeDTO> arg0) {

		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {

		// TODO Auto-generated method stub

	}

	@Override
	public boolean exists(Integer arg0) {

		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EmployeeDTO findOne(Integer arg0) {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends EmployeeDTO> S save(S arg0) {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends EmployeeDTO> long count(Example<S> arg0) {

		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends EmployeeDTO> boolean exists(Example<S> arg0) {

		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends EmployeeDTO> Page<S> findAll(Example<S> arg0, Pageable arg1) {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends EmployeeDTO> S findOne(Example<S> arg0) {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch() {

		// TODO Auto-generated method stub

	}

	@Override
	public void deleteInBatch(Iterable<EmployeeDTO> arg0) {

		// TODO Auto-generated method stub

	}

	@Override
	public List<EmployeeDTO> findAll() {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeDTO> findAll(Sort arg0) {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeDTO> findAll(Iterable<Integer> arg0) {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends EmployeeDTO> List<S> findAll(Example<S> arg0) {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends EmployeeDTO> List<S> findAll(Example<S> arg0, Sort arg1) {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {

		// TODO Auto-generated method stub

	}

	@Override
	public EmployeeDTO getOne(Integer arg0) {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends EmployeeDTO> List<S> save(Iterable<S> arg0) {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends EmployeeDTO> S saveAndFlush(S arg0) {

		// TODO Auto-generated method stub
		return null;
	}
	// public interface EmployeeDAO extends CrudRepository<EmployeeDTO,
	// Integer> {

}
