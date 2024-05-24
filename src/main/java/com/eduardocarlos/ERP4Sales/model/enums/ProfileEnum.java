package com.eduardocarlos.ERP4Sales.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@AllArgsConstructor
@Getter
public enum ProfileEnum {

    ADMIN(1, "ROLE_ADMIN"),
    DEFAULT(2, "ROLE_DEFAULT");

    private Integer code;
    private String description;

    public static ProfileEnum toEnum(Integer code) {
        if(Objects.isNull(code)){
            return null;
        }

        for(ProfileEnum i : ProfileEnum.values()) {
            if (code.equals(i.getCode())){
                return i;
            }
        }
        throw new IllegalArgumentException("Invalid code" + code);
    }


}
