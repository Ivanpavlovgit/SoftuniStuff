package com.example.gameshop.Util;


import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import java.util.Set;

public interface ValidationUtil {

    <E> Set<ConstraintViolation<E>> violation (E entity);

    <E> boolean isValid (E entity);

}
