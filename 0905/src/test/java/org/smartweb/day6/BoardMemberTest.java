package org.smartweb.day6;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.smartweb.day6.domain.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMemberTest {
	
	
	@Setter(onMethod_=@Autowired)
	private BoardMapper boardMapper;
	
	@Test
	public void test() {
		
		
		log.info("getList");
		log.info(boardMapper.getList());
		
		/*
		BoardVO board=new BoardVO();
		board.setTitle("First Test");
		board.setContent("First Test");
		board.setWriter("hongkildong");
		
		
		boardMapper.insert(board);
		*/
		//log.info(board);
		
		
		//BoardVO board=boardMapper.read(1L);
		//boardMapper.delete(1L);
		
		BoardVO board=new BoardVO();
		board.setBno(2L);
		board.setTitle("abc");
		board.setContent("abc");
		board.setWriter("abc");
		
		int count=boardMapper.update(board);
		
		log.info("update"+count);
		

	}
}
