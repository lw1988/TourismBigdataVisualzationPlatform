package com.gxu.tbvp.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.gxu.tbvp.domain.Scenic;
import com.gxu.tbvp.mapper.ScenicMapper;
import com.gxu.tbvp.service.ScenicService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service("scenicService")
public class ScenicServiceImpl extends BaseService<Scenic> implements ScenicService {


    @Resource
    private ScenicMapper scenicMapper;

    @Override
    public int getScenicByName(String title) {
        Example example = new Example(Scenic.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtil.isNotEmpty(title)){
            criteria.andEqualTo("title", title);
        }
        List<Scenic> scenicList = selectByExample(example);
        if (scenicList.size() != 0){
            return scenicList.get(0).getId();
        }
        return -1;
    }

    @Override
    public int[] selectAllScenicsId() {
        int[] scenics = scenicMapper.selectAllScenicsId();
        return scenics;
    }

    @Override
    public String selectScenicByKey(Integer key) {
        return scenicMapper.selectScenicByKey(key);
    }

    @Override
    public PageInfo<Scenic> selectByPage(Scenic scenic, int start, int length) {
        int page = start/length+1;
        Example example = new Example(Scenic.class);
        //分页查询
        PageHelper.startPage(page, length);
        List<Scenic> scenicList = selectByExample(example);
        return new PageInfo<>(scenicList);
    }

}
