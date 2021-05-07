package xilalu.entity;

import lombok.Data;
import lombok.ToString;

/**
 * @author lds
 * @date 2021/1/29 8:44
 */
@Data
@ToString(callSuper = true)
public class Student extends Person{
    /**
     * 学号.
     */
    private Integer studentNo;
    private String school;
}
