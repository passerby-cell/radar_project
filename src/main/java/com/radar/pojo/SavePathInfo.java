package com.radar.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * save_path_info
 * @author 
 */
@Data
public class SavePathInfo implements Serializable {
    private Integer algId;

    private String algName;

    private String savePath;

    private static final long serialVersionUID = 1L;
}