package com.example.Staff.Model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Builder
public class Staff {
   private String id;
   private String name;
   @Default
   private String photo = "photo.png";
   @Default
   private Boolean gender = true;
   @Default
   private Date birthday = new Date();
   @Default
   private Double salary = 0.0;
   @Default
   private Integer level = 0;
}
