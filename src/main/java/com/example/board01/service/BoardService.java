package com.example.board01.service;

import com.example.board01.dto.BoardDTO;

import java.util.List;

public interface BoardService {
    List<BoardDTO> getList();
    BoardDTO getOne(int bno);
    void register(BoardDTO boardDTO);
    void modify(BoardDTO boardDTO);
    void remove(int bno);
}
