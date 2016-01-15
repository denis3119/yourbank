package com.yourbank.data.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Yugov Alexandr.
 */
@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    private Long userId;

    private String email;

    private String phone;
}
