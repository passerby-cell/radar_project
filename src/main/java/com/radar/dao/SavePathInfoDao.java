package generate;

import generate.SavePathInfo;

public interface SavePathInfoDao {
    int deleteByPrimaryKey(Integer algId);

    int insert(SavePathInfo record);

    int insertSelective(SavePathInfo record);

    SavePathInfo selectByPrimaryKey(Integer algId);

    int updateByPrimaryKeySelective(SavePathInfo record);

    int updateByPrimaryKey(SavePathInfo record);
}