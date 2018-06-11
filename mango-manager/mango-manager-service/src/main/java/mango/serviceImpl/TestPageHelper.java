package mango.serviceImpl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mango.mapper.TbItemMapper;
import mango.pojo.TbItem;
import mango.pojo.TbItemExample;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestPageHelper {
    public void testHelper(){
        //2.初始化spring 容器
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-dao.xml");
        //3.获取mapper代理对象
        TbItemMapper itemMapper = context.getBean(TbItemMapper.class);
        //1.设置分页信息
        PageHelper.startPage(1,3);//3行，紧跟着第一个查询才能被分页
        //4.调用mapper来查询
        TbItemExample example = new TbItemExample();//设置查询条件
        List<TbItem> items1 = itemMapper.selectByExample(example);
        List<TbItem> items2 = itemMapper.selectByExample(example);
        //取分页信息
        PageInfo<TbItem> info =  new PageInfo<>(items1);
        System.out.println("第一个分页的list的长度："+items1.size());
        System.out.println("第二个分页的list的长度："+items2.size());
        //5.遍历打印

        System.out.println(items1.size());
        System.out.println(info.getTotal());
        System.out.println(items1);
        System.out.println(info.getList().size());
    }

    public static void main(String[] args){
        new TestPageHelper().testHelper();
    }

}
