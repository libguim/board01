package com.example.board01.controller;

import com.example.board01.dto.BoardDTO;
import com.example.board01.service.BoardService;
import lombok.Getter;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Log4j2
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/list")
    public void list(Model model) {
        log.info("list");
        model.addAttribute("boardList", boardService.getList());
    }

    @GetMapping("/register")
    public void registerGet() {
        log.info("registerGet");
    }

    @PostMapping("/register")
    public String registerPost(BoardDTO boardDTO) {
        log.info("registerPost");
        boardService.register(boardDTO);
        return "redirect:/board/list";
    }

    @GetMapping({"/read","/modify"})
    public void read(@RequestParam("bno") int bno, Model model) {
        log.info("read");
        BoardDTO dto = boardService.getOne(bno);
        model.addAttribute("board", dto);
    }

    @PostMapping("/modify")
    public String modifyPost(BoardDTO boardDTO) {
        log.info("modifyPost");
        boardService.modify(boardDTO);
//        return "redirect:/board/modify?bno=" + boardDTO.getBno();
        return "redirect:/board/read";
    }

    @GetMapping("/remove")
    public String remove(int bno) {
        log.info("remove");
        boardService.remove(bno);
        return "redirect:/board/list";
    }

}
