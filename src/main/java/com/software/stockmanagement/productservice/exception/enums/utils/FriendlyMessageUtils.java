package com.software.stockmanagement.productservice.exception.enums.utils;

import com.software.stockmanagement.productservice.enums.Langueage;
import com.software.stockmanagement.productservice.exception.enums.IFriendlyMessageCode;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

@Slf4j
@UtilityClass
public class FriendlyMessageUtils {

    private static final String RESOURCE_BUNDLE_NAME= "FriendlyMessage";
    private static final String SPECIAL_CHARACTER="__";

    public static String getFriendlyMessage(Langueage langueage, IFriendlyMessageCode messageCode){
        String messageKey = null;
        try{
            Locale locale = new Locale(langueage.name());
            ResourceBundle resourceBundle = ResourceBundle.getBundle(RESOURCE_BUNDLE_NAME, locale);
            messageKey = messageCode.getClass().getSimpleName() + SPECIAL_CHARACTER + messageCode;
            return resourceBundle.getString(messageKey);
        }catch (MissingResourceException){
            log.error("Friendly message not found for key: {}", messageKey);
            return null;
        }
    }

}
