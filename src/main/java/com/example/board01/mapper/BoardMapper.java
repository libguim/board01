package com.example.board01.mapper;

import com.example.board01.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardDTO> selectAll();
    BoardDTO selectOne(int bno);
    void insert(BoardDTO board);
    void update(BoardDTO board);
    void delete(int bno);
    void readCountUpdate(int bno);
}
