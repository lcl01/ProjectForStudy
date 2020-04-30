package com.itheima.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dao.CheckItemDao;
import com.itheima.pojo.CheckItem;
import entity.PageResult;
import entity.QueryPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description:
 * @Author: yp
 */
@Service(interfaceClass = CheckItemService.class)
@Transactional
public class CheckItemServiceImpl implements CheckItemService {

    @Autowired
    private CheckItemDao checkItemDao;

    /**
     * 新增检查项
     *
     * @param checkItem
     */
    @Override
    public void add(CheckItem checkItem) {
        checkItemDao.add(checkItem);
    }

    /**
     * 分页查询
     *
     * @param queryPageBean
     * @return
     */
    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        //1.调用MyBatis分页插件方法(自动帮我们做分页)  ThreadLocal, MyBatis拦截器
        PageHelper.startPage(queryPageBean.getCurrentPage(), queryPageBean.getPageSize());
        //2.调用Dao
        Page<CheckItem> page = checkItemDao.selectConditions(queryPageBean.getQueryString());
        PageResult pageResult = new PageResult(page.getTotal(), page.getResult());
        return pageResult;
    }

    /**
     * 根据id删除
     *
     * @param id
     */
    @Override
    public void delete(Integer id) {
        //1.判断当前的检查项是否被检查组引用到了
        long count =  checkItemDao.findCountByCheckItemId(id);
        if(count > 0){
            //2.有引用dao, 抛出异常
            throw new RuntimeException("此检查项被引用到了,不能删除");
        }

        //3.没有引用,调用Dao 删除
        checkItemDao.deleteById(id);

    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public CheckItem findById(Integer id) {
        return checkItemDao.findById(id);
    }

    /**
     * 更新
     *
     * @param checkItem
     */
    @Override
    public void edit(CheckItem checkItem) {
        checkItemDao.edit(checkItem);
    }
}
