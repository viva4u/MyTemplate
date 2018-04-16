package com.mytemplate.service.Impl;

import com.mytemplate.mapper.CateBasicMapper.CateBasicMapper;
import com.mytemplate.model.Category;
import com.mytemplate.service.CategoryBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryBasicServiceImpl implements CategoryBasicService {
    @Autowired
    private CateBasicMapper cateBasicMapper;

    public CateBasicMapper getCateBasicMapper() {
        return cateBasicMapper;
    }

    public void setCateBasicMapper(CateBasicMapper cateBasicMapper) {
        this.cateBasicMapper = cateBasicMapper;
    }

    @Override
    public Category getCategory (Category category){
        return this.getCateBasicMapper().getCategory(category);
    }
    @Override
    public void addCategory(Category category){
        this.getCateBasicMapper().addCategory(category);
    }
}
