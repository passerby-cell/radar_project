package generate;

import generate.AlgorithmInfo;

public interface AlgorithmInfoDao {
    int deleteByPrimaryKey(String paramName);

    int insert(AlgorithmInfo record);

    int insertSelective(AlgorithmInfo record);

    AlgorithmInfo selectByPrimaryKey(String paramName);

    int updateByPrimaryKeySelective(AlgorithmInfo record);

    int updateByPrimaryKey(AlgorithmInfo record);
}