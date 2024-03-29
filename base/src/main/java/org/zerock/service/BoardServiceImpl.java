package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{
    
    @Setter(onMethod_ = @Autowired)
    private BoardMapper mapper;
    @Override
    public void register(BoardVO board) {
        // TODO Auto-generated method stub
        log.info("register......." + board);
        mapper.insertSelectKey(board);
    }

    @Override
    public BoardVO get(Long bno) {
        // TODO Auto-generated method stub
        log.info("get......"+ bno);
        return mapper.read(bno);
    }

    @Override
    public boolean modify(BoardVO board) {
        // TODO Auto-generated method stub
        log.info("modify....."+board);
        return mapper.update(board) == 1;
    }

    @Override
    public boolean remove(Long bno) {
        // TODO Auto-generated method stub
        log.info("remove....."+bno);
        return mapper.delete(bno) == 1;
    }

    @Override
    public List<BoardVO> getList() {
        // TODO Auto-generated method stub
        log.info("getList.....");
        return mapper.getList();
    }
    
}
