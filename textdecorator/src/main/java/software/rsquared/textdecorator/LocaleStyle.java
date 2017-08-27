package software.rsquared.textdecorator;

import android.os.Build;
import android.os.LocaleList;
import android.support.annotation.RequiresApi;
import android.text.SpannableStringBuilder;
import android.text.style.LocaleSpan;

import java.util.Locale;

/**
 * @author Rafal Zajfert
 */
@RequiresApi(api = Build.VERSION_CODES.N)
class LocaleStyle extends SpanStyle {

    private final LocaleList localeList;
    private final Locale locale;

    /**
     * @see LocaleSpan#LocaleSpan(LocaleList)
     */
    LocaleStyle(LocaleList localeList) {
        this.localeList = localeList;
        this.locale = null;
    }

    /**
     * @see LocaleSpan#LocaleSpan(Locale)
     */
    LocaleStyle(Locale locale) {
        this.localeList = null;
        this.locale = locale;
    }


    @Override
    void apply(SpannableStringBuilder builder, int start, int end) {
        if (localeList != null) {
            apply(builder, start, end, new LocaleSpan(localeList));
        } else if (locale != null) {
            apply(builder, start, end, new LocaleSpan(locale));
        }
    }
}
