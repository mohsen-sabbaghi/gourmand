package com.example.gourmand.dto;

import com.example.gourmand.util.GSONModel;
import com.google.gson.annotations.SerializedName;
import lombok.*;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BaseDto extends GSONModel {

    @SerializedName("id")
    private Long id;

    @SerializedName("created_at")
    private Date createdAt;
}
