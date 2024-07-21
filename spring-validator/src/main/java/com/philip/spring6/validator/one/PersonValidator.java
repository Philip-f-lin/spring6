package com.philip.spring6.validator.one;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PersonValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
         return Person.class.equals(clazz);
    }

    // 校驗規則
    @Override
    public void validate(Object target, Errors errors) {
        // name 不能為空
        ValidationUtils.rejectIfEmpty(errors, "name", "name is empty", "name is null");
        // age 不能小於 0， 不能大於 200
        Person person = (Person) target;
        if(person.getAge() < 0){
            errors.rejectValue("age", "age.value.error", "age < 0");
        }else if(person.getAge() > 0){
            errors.rejectValue("age", "age.value.error.old", "age > 200");
        }
    }
}
