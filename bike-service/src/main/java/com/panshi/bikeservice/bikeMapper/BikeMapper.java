package com.panshi.bikeservice.bikeMapper;

import com.panshi.domail.BikeDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author：ZLRWJSAN
 * @date 2019/8/14 9:50
 */

@Repository
@Mapper
public interface BikeMapper {

    BikeDTO getBikeNum(int bikeId);

}
