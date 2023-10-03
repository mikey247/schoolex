package com.mikey247.schoolex.utility;

import java.util.Optional;

public class UtilityFunctions {
    

    public static <T> T unwrapOptional(Optional<T> optional) {
        return optional.orElse(null);
    }
}
