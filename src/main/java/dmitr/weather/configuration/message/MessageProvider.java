package dmitr.weather.configuration.message;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

import static dmitr.weather.configuration.message.MessageLocale.DEFAULT_LOCALE;

/**
 * Provider for getting messages from exceptionMessages.properties file
 */
@RequiredArgsConstructor
@Component
public class MessageProvider {

    private static final Object[] nullArgs = new Object[0];

    private final MessageSource messageSource;

    public String get(String code) {
        return get(code, DEFAULT_LOCALE);
    }

    public String get(String code, Locale locale) {
        return messageSource.getMessage(code, nullArgs, locale);
    }
}
