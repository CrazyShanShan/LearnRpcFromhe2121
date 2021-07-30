package org.crazys.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/***
 * @Description: ""
 * @Author: ZBZ
 * @Date: 2021/5/28
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private Integer id;
    private String userName;
    private Boolean sex;
}
