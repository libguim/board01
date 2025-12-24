package com.example.board01;

import com.example.board01.dto.BoardDTO;
import com.example.board01.mapper.BoardMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
@Log4j2
public class DataSourceTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private BoardMapper boardMapper;

    @Test
    public void testConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        log.info(connection);
        Assertions.assertNotNull(connection);
    }

    @Test
    public void testInsert(){
        BoardDTO dto = new BoardDTO();
        dto.setTitle("title1");
        dto.setContent("content1");
        dto.setWriter("user00");
        boardMapper.insert(dto);
    }

    @Test
    public void selectAll(){
        List<BoardDTO> dtos = boardMapper.selectAll();
        for(int i=0; i<dtos.size(); i++){
            BoardDTO dto = dtos.get(i);
            log.info(dto);
        }
    }

    @Test
    public void selectOne(){
        BoardDTO dto = boardMapper.selectOne(1);
        log.info(dto);
    }

    @Test
    public void testUpdate(){
        BoardDTO updateDto = new BoardDTO();
        updateDto.setBno(1);
        updateDto.setTitle("수정 제목");
        updateDto.setContent("수정 제목");
        updateDto.setWriter("user11");
        boardMapper.update(updateDto);
    }

    @Test
    public void testDelete(){
        boardMapper.delete(1);
    }

}
