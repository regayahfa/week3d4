package com.example.week3hw4.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@AllArgsConstructor
@Data
public class EmployeeData {

    @Size(min = 2 ,max = 8)
    @NotEmpty(message = "cannot to be null")
    private String id;
    @Size(min = 4 ,max = 10)
    @NotEmpty( message = "cannot be null")
    private String name;
    @Min(value = 25 , message = " more than 25 please")
    @NonNull
    @Positive(message = "should be real number")
//    @NotEmpty( message = "it has to be number")
    private int age;
@NotEmpty(message = "must be supervisor or coordinator only")
    private String position;
@AssertFalse
    private boolean onLeave;
@NotEmpty(message = "cannot be null")
@Pattern(regexp = "(mm/yyyy)")
//@past نقدر نستخدم هذه بعد اذا كان التاريخ بالماضي
    private int employmentYear;
@NonNull
    private int annuaLeave;

}
