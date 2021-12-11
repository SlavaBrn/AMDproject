package com.vs.tp.qa.annotations;

import java.lang.annotation.*;
import org.junit.jupiter.api.extension.ExtendWith;

import com.vs.tp.qa.general.DeisabledForE2ECondition;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ExtendWith(DeisabledForE2ECondition.class)
public @interface DisabledForE2E {

}
