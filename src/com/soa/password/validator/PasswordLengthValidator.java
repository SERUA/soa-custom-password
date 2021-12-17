package com.soa.password.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.bonitasoft.web.toolkit.client.common.i18n.AbstractI18n;
import org.bonitasoft.web.toolkit.client.data.item.attribute.validator.AbstractStringValidator;

public class PasswordLengthValidator extends AbstractStringValidator {
  protected void _check(String password) {
    AbstractI18n.LOCALE Locale = AbstractI18n.stringToLocale(this.locale);
    Pattern patternUpper = Pattern.compile("([A-Z])");
    Pattern patternLower = Pattern.compile("([a-z])");
    Pattern patternNumber = Pattern.compile("([0-9])");
    Matcher matcher = null;
    int minimalLength = 8;
    int maximumLength = 16;
    if (password.length() < minimalLength || password.length() > maximumLength) {
      addError(AbstractI18n.t_("Password is not long enough", Locale));
    } else {
      matcher = patternUpper.matcher(password);
      if (!matcher.find()) {
        addError(AbstractI18n.t_("la contraseña debe contener al menos una letra mayuscula", Locale));
      } else {
        matcher = patternLower.matcher(password);
        if (!matcher.find()) {
          addError(AbstractI18n.t_("la contraseña debe contener al menos una letra minuscula", Locale));
        } else {
          matcher = patternNumber.matcher(password);
          if (!matcher.find()) {
            System.out.println("la contrasedebe contener al menos un numero");
            addError(AbstractI18n.t_("la contraseña debe contener al menos un numero", Locale));
          } else {
            System.out.println("OK!");
          } 
        } 
      } 
    } 
  }
}
