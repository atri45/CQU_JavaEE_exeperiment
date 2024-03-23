package cn.edu.cqu.cs.service.impl;

import cn.edu.cqu.cs.entity.Menu;
import cn.edu.cqu.cs.mapper.IMenuDao;
import cn.edu.cqu.cs.service.IMenuService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MenuServiceImpl implements IMenuService {

    private IMenuDao menuDao;

    @Override
    public List<Menu> findAll() {
        return menuDao.findAll();
    }


}
