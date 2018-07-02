package com.xiangqin.service;

import java.util.List;

import com.xiangqin.domain.Concern;

public interface ConcernService {

	Integer save(Concern c);

	List<Concern> findByOwnerId(Integer ownerId);
}
