package org.example.DataValidation.Model;


import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Staff {
    @NotBlank(message = "Chưa nhập Email")
    @Email(message = "Email không đúng định dạng")
    private String id;
    @NotBlank(message = "Chưa nhập họ tên")
    private String fullname;

    @Builder.Default //nhận giá trị mặc định
    private String photo = "photo.jpg";

    @NotNull(message = "chưa chọn giới tính")
    private Boolean gender = true;

    @NotNull(message = "Chưa nhập ngày sinh")
    @Past(message = "ngày sinh không hợp lệ")
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date birthday = new Date();

    @Pattern(regexp = "không được nhập chữ")
    @Min(value = 1000, message = "lương tối thiểu phải là 1000")
    @NotNull(message = "Chưa nhập lương")
    private String salary;

    private Integer level;
}
