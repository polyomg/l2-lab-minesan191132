package org.example.Databinding.Model;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Staff {
    private String id;
    private String fullname;

    @Builder.Default //nhận giá trị mặc định
    private String photo = "photo.jpg";

    @Builder.Default
    private Boolean gender = true;

    @Builder.Default
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date birthday = new Date();

    @Builder.Default
    private double salary = 12345.6789;

    @Builder.Default
    private Integer level = 0;
}
