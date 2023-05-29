package com.songinfovalidate.model;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class SongInfo implements Validator {

    private Long id;
    private String name;
    private String auth;
    private String type;

    @Override
    public boolean supports(Class<?> clazz) {
        return SongInfo.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongInfo songInfo = (SongInfo) target;
        String name = songInfo.getName();
        String auth = songInfo.getAuth();
        String type = songInfo.getType();
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        ValidationUtils.rejectIfEmpty(errors, "auth", "auth.empty");
        ValidationUtils.rejectIfEmpty(errors, "type", "type.empty");

        String nameAndAuthPattern = "^[^@ ; , . = - + ,]*$";
        String typePattern = "^[^\", , ]*$";
        if (name.length()> 800){
            errors.rejectValue("name", "name.length");
        }

        if (!name.matches(nameAndAuthPattern)) {
            errors.rejectValue("name", "name.matches");
        }

        if (auth.length()> 300){
            errors.rejectValue("auth", "auth.length");
        }

        if (!auth.matches(nameAndAuthPattern)) {
            errors.rejectValue("auth", "auth.matches");
        }


        if (type.length()> 1000){
            errors.rejectValue("type", "type.length");
        }

        if (!type.matches(typePattern)) {
            errors.rejectValue("type", "type.matches");
        }



    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuth() {
        return auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
