package com.jihoon.board.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jihoon.board.dto.request.board.PostBoardRequestDto;
import com.jihoon.board.dto.response.ResponseDto;
import com.jihoon.board.service.BoardService;

@RestController
@RequestMapping("/api/v1/board")
public class BoardController {
    
    private BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    //* 1.게시물 작성 */
    @PostMapping("")
    public ResponseEntity<ResponseDto> postBoard(
        @Valid @RequestBody PostBoardRequestDto requestBody
    ) {
        ResponseEntity<ResponseDto> response = boardService.postBoard(requestBody);
        return response;
    }

}
