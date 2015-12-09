package net.therap.facebook.utils;

import net.therap.facebook.entities.PersonalDetails;
import net.therap.facebook.utils.annotations.NotNull;
import net.therap.facebook.utils.annotations.Pattern;
import net.therap.facebook.utils.annotations.Size;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * @author: rafsan.jani
 * @since: 12/7/15.
 */
public class CustomValidator {
    private static final CustomValidator customValidator = new CustomValidator();
    private ArrayList<String> errors;

    private CustomValidator() {
        errors = new ArrayList<>();
    }

    public static CustomValidator getInstance() {
        return customValidator;
    }

    public boolean validate(PersonalDetails personalDetails) {
        Field[] fields = personalDetails.getClass().getDeclaredFields();
        boolean valid = true;
        for (Field field : fields) {
            Annotation[] annotations = field.getDeclaredAnnotations();
            field.setAccessible(true);
            Object object = null;
            try {
                object = field.get(personalDetails);
            } catch (Exception e) {
                valid = false;
                e.printStackTrace();
            }
            for (Annotation annotation : annotations) {
                valid = valid & isValid(object, annotation);
            }
            field.setAccessible(false);
        }
        return valid;
    }

    private boolean isValid(Object object, Annotation annotation) {
        if (annotation instanceof NotNull) {
            if (object == null || (object instanceof String && object.equals(""))) {
                return false;
            }
        } else if (annotation instanceof Size) {
            if (object instanceof String) {
                String str = (String) object;
                Size size = (Size) annotation;
                if (str.length() < size.min() || str.length() > size.max()) {
                    return false;
                }
            }
        } else if (annotation instanceof Pattern) {
            if (object instanceof String) {
                Pattern pattern = (Pattern) annotation;
                if (StringValidator.getInstance().validateString((String) object, pattern.regexp()) == false) {
                    return false;
                }
            }
        }
        return true;
    }

    public ArrayList<String> getErrors(PersonalDetails personalDetails) {
        errors = new ArrayList<>();
        Field[] fields = personalDetails.getClass().getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getDeclaredAnnotations();
            field.setAccessible(true);
            Object object = null;
            try {
                object = field.get(personalDetails);
            } catch (Exception e) {
                e.printStackTrace();
            }
            for (Annotation annotation : annotations) {
                if (isValid(object, annotation) == false) {
                    errors.add(getError(object, annotation));
                }
            }
            field.setAccessible(false);
        }

        return errors;
    }

    private String getError(Object object, Annotation annotation) {
        if (annotation instanceof NotNull) {
            if (object == null || (object instanceof String && object.equals(""))) {
                return ((NotNull) annotation).message();
            }
        } else if (annotation instanceof Size) {
            if (object instanceof String) {
                String str = (String) object;
                Size size = (Size) annotation;
                if (str.length() < size.min() || str.length() > size.max()) {
                    return size.message();
                }
            }
        } else if (annotation instanceof Pattern) {
            if (object instanceof String) {
                Pattern pattern = (Pattern) annotation;
                if (StringValidator.getInstance().validateString((String) object, pattern.regexp()) == false) {
                    return pattern.message();
                }
            }
        }
        return "default";
    }
}
