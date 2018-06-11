package mango.service;

import mango.common.pojo.EasyUIDataGridResult;

public interface ItemService {
    public EasyUIDataGridResult getItemList(Integer page,Integer rows);
}
