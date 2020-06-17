package service;

import domain.Province;

import java.util.List;

/**
 * @author nzy
 * @create 2020-05-11 10:07
 */
public interface ProvinceService {
    public List<Province> findAll();
    public String findAllJson();
}
