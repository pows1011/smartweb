package org.smartweb.day6.service;

import java.util.List;

import org.smartweb.day6.BoardMapper;
import org.smartweb.day6.domain.BoardVO;
import org.smartweb.day6.domain.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
// BoardMapper.java에 있는것을 여기서 구연


@Log4j
@Service()
@AllArgsConstructor //AllArgs = 모든 전달받는 변수  Constructor = 생성자     BoardServiceImpl의 이름으로 생성되는 매개변수를 알아서 만듬
@Primary
public class BoardServiceImpl implements BoardService{	
	/*
	  AllArg~~를 안쓸경우에는 이렇게 만들어 주어야함.
	  public BoardServiceImpl() {}
	public BoardServiceImpl(BoardVO bvo) {		
	}*/
	
	
	@Setter(onMethod_=@Autowired)
	private BoardMapper mapper;
	
	/*  Setter( ~~) 와 같은 뜻
		public void setMapper(BoardMapper mapper) {
			this.mapper=mapper;
		}*/
	

	
	
	@Override
	public void register(BoardVO board) {
		// TODO Auto-generated method stub
		mapper.insert(board);
	}

	@Override
	public BoardVO get(Long bno) {
		// TODO Auto-generated method stub
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		// TODO Auto-generated method stub
		return mapper.update(board)==1;
		
	}

	@Override
	public boolean remove(Long bno) {
		// TODO Auto-generated method stub
		return mapper.delete(bno)==1;
	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		// TODO Auto-generated method stub
		log.info("getList with Criteria : "+cri);
		return mapper.getListWithpaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getTotalCount(cri);
	}
	
	
	
	
	
}
