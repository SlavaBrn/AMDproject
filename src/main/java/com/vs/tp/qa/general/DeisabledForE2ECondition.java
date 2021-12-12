package com.vs.tp.qa.general;

import static org.junit.jupiter.api.extension.ConditionEvaluationResult.disabled;
import static org.junit.jupiter.api.extension.ConditionEvaluationResult.enabled;
import static org.junit.platform.commons.util.AnnotationUtils.findAnnotation;

import java.util.Optional;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

import com.vs.tp.qa.annotations.DisabledForE2E;

public class DeisabledForE2ECondition implements ExecutionCondition {

    private static final ConditionEvaluationResult ENABLED_BY_DEFAULT = enabled("@DisabledForE2e is not present");
    static final ConditionEvaluationResult ENABLED_TEST = enabled("Running non-E2E, enabled test");
    static final ConditionEvaluationResult DISABLED_TEST = disabled("Running E2E, disabled test");

    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
        Optional<DisabledForE2E> optional = findAnnotation(context.getElement(), DisabledForE2E.class);
        if (optional.isPresent()) {
            if (Const.IS_E2E) {
                return DISABLED_TEST;
            } else {
                return ENABLED_TEST;
            }

        }
        return ENABLED_BY_DEFAULT;
    }
}
