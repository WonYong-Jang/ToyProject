package org.zerock.mapper;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {org.zerock.config.RootConfig.class})
@Log4j
public class BoardMapperTests {
    @Setter(onMethod_ = @Autowired)
    private BoardMapper mapper;
    
    @Test
    public void testGetList() {
        mapper.getList().forEach(board -> log.info(board));
    }
    
    @Test
    public void testInsert() {
        BoardVO board = new BoardVO();
        board.setTitle("새로 작성하는 글");
        board.setContent("새로 작성하는 내용");
        board.setWriter("newbie");
        
        mapper.insert(board);
        
        log.info(board);
    }
    
    @Test
    public void testInsertSelectKey() {
        BoardVO board = new BoardVO();
        board.setTitle("새로 작성하는 글 select key");
        board.setContent("새로 작성하는 내용 select key");
        board.setWriter("newbie");
        
        mapper.insertSelectKey(board);
        
        log.info(board);
    }
    
    @Test
    public void testRead() {
        BoardVO board = mapper.read(1L);
        log.info("read : "+board);
    }
    
    @Test
    public void testDelete() {
        log.info("Delete Count : " + mapper.delete(3L));
    }
    
    @Test
    public void testUpdate() {
        
        List<BoardVO> list = new ArrayList<BoardVO>();
        BoardVO board = new BoardVO();
        board.setBno(1L);
        board.setContent("1");
        board.setWriter("1");
        list.add(board);
        board = new BoardVO();
        board.setBno(2L);
        board.setContent("2");
        board.setWriter("2");
        list.add(board);
        
        mapper.updateList(list);
        
        //int count = mapper.update(board);
        log.info("update" );
    }
}
