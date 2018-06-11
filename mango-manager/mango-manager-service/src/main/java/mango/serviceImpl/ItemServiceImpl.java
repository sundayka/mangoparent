package mango.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mango.common.pojo.EasyUIDataGridResult;
import mango.mapper.TbItemMapper;
import mango.pojo.TbItem;
import mango.pojo.TbItemExample;
import mango.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemMapper mapper;
    @Override
    public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
        if (page==null)page=1;
        if (rows==null)rows=30;
        PageHelper.startPage(page,rows);
        TbItemExample example = new TbItemExample();
        List<TbItem> list = mapper.selectByExample(example);
        PageInfo<TbItem> info = new PageInfo<>(list);

        EasyUIDataGridResult result = new EasyUIDataGridResult();
        result.setTotal((int)info.getTotal());
        result.setRows(list);

        return result;
    }
}
