package com.example.board01.service;

import com.example.board01.dto.BoardDTO;
import com.example.board01.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    // 1. 목록 조회: 결과가 여러 개이므로 List로 받음
    @Override
    public List<BoardDTO> getList(){
        return boardMapper.selectAll();
    }

    // 2. 상세 조회: 결과가 딱 하나이므로 단일 DTO로 받음
    @Override
    public BoardDTO getOne(int bno) {
        boardMapper.readCountUpdate(bno);
        return boardMapper.selectOne(bno);
    }

    @Override
    public void register(BoardDTO boardDTO) {
        boardMapper.insert(boardDTO);
    }

    @Override
    public void modify(BoardDTO boardDTO) {
        //BoardDTO 클래스 위에 붙어 있는 @Data (또는 @Getter) 어노테이션이 getBno() 자동생성해줌
        BoardDTO dto = boardMapper.selectOne(boardDTO.getBno());
        boardMapper.update(boardDTO);
    }

    @Override
    public void remove(int bno) {
        boardMapper.delete(bno);
    }

}
