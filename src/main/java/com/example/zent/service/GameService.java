package com.example.zent.service;

import static com.example.zent.enums.Range.PAGESIZE;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.zent.module.Game;
import com.example.zent.repository.GameRepo;

@Service
@Transactional
public class GameService {
    private GameRepo gr;

    public GameService() {
    }

    @Autowired
    public GameService(GameRepo gr) {
        this.gr = gr;
    }

    public Game create(Game g){
        return gr.save(g);
    }

    public List<Game> getByNamePaginated(String name,int page) {
        Pageable pageable = PageRequest.of(page-1,PAGESIZE.min,Sort.by("name").ascending());
        Page<Game> resultPage = gr.findByNameContaining(name,pageable);
        if(resultPage.hasContent()){
            return resultPage.getContent();
        }
        
        return new ArrayList<>();
    }

}