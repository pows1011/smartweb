package org.smartweb.day6.service;

import java.util.List;

import org.smartweb.day6.domain.BoardVO;
import org.smartweb.day6.domain.Criteria;

public interface BoardService {

		public void register(BoardVO board); // 일시적인 기억,저장(insert)
		public BoardVO get(Long bno);		 // Read
		public boolean modify(BoardVO board);// Update
		public boolean remove(Long bno);	 // Delete
		//public List<BoardVO> getList();		 // 전체 리스트
		public List<BoardVO> getList(Criteria cri);
		public int getTotal(Criteria cri);
}
