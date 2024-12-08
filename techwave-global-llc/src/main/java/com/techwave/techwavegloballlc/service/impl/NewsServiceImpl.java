package com.techwave.techwavegloballlc.service.impl;

import com.techwave.techwavegloballlc.entity.TblNews;
import com.techwave.techwavegloballlc.exception.NotFoundException;
import com.techwave.techwavegloballlc.repository.TblNewsRepository;
import com.techwave.techwavegloballlc.response.ResponseWrapper;
import com.techwave.techwavegloballlc.response.StatusDescription;
import com.techwave.techwavegloballlc.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

    private final TblNewsRepository newsRepository;

    @Override
    public ResponseWrapper getAllNews(){
        try {
            List<TblNews> list = newsRepository.findAll();
            if(list.isEmpty()){
                throw new NotFoundException("Data Not Found");
            }
            return ResponseWrapper.builder().statusDescription(StatusDescription.builder().statusCode(200).statusMessage("Success").build()).response(list).build();
        }catch (NotFoundException e){
            return ResponseWrapper.builder().statusDescription(StatusDescription.builder().statusCode(404).statusMessage(e.getMessage()).build()).build();
        }catch (Exception e){
            return ResponseWrapper.builder().statusDescription(StatusDescription.builder().statusCode(500).statusMessage("Something went wrong.").build()).build();
        }
    }
}
