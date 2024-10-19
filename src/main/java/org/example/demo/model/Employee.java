package org.example.demo.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    private Integer empId;
    private String empName;
    private String email;
    private String age;
    private String mobileNo;
}
