package com.xiangqin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiangqin.domain.Letter;
import com.xiangqin.repository.LetterRepository;
import com.xiangqin.service.LetterService;

@Service
public class LetterServiceImpl implements LetterService {

	@Autowired
	private LetterRepository letterRepository;

	@Override
	public Integer save(Letter letter) {
		letterRepository.save(letter);
		return letter.getId();
	}

	@Override
	public List<Letter> mList(Integer fromId) {
		return letterRepository.mList(fromId);
	}

	@Override
	public List<Letter> sList(Integer toId) {
		return letterRepository.sList(toId);
	}

}
