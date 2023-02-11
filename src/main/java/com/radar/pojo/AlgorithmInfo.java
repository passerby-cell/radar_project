package com.radar.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * algorithm_info
 * @author 
 */
@Data
public class AlgorithmInfo implements Serializable {
    private String paramName;

    private Integer algId;

    private String subAlgName;

    private static final long serialVersionUID = 1L;
}