package org.smartweb.day6.service;

import java.util.List;

import org.smartweb.day6.ReplyMapper;
import org.smartweb.day6.domain.Criteria;
import org.smartweb.day6.domain.ReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
@Primary
public class ReplyServiceImpl implements ReplyService {
	
	@Setter(onMethod_=@Autowired)
	private ReplyMapper mapper;

	
	@Override
	public int register(ReplyVO vo) {
		
		return mapper.insert(vo);
	}

	@Override
	public ReplyVO get(Long rno) {
		
		return mapper.read(rno);
	}

	@Override
	public int modify(ReplyVO vo) {
		
		return mapper.update(vo);
	}

	@Override
	public int remove(Long rno) {
		
		return mapper.delete(rno);
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, Long bno) {

		return mapper.getListWithPaging(cri, bno);
	}


	
}
