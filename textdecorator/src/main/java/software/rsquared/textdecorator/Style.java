package software.rsquared.textdecorator;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.BlurMaskFilter;
import android.graphics.EmbossMaskFilter;
import android.graphics.Typeface;
import android.os.Build;
import android.os.LocaleList;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.RequiresApi;
import android.support.annotation.StyleRes;
import android.text.SpannableStringBuilder;
import android.text.method.MovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LocaleSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TextAppearanceSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

/**
 * @author Rafal Zajfert
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public abstract class Style {

    /**
     * @see BackgroundColorSpan#BackgroundColorSpan(int)
     */
    public static Style backgroundColor(@ColorInt int color) {
        return new BackgroundColorStyle(color);
    }

    /**
     * @see BackgroundColorSpan#BackgroundColorSpan(int)
     */
    public static Style backgroundColor(Context context, @ColorRes int colorRes) {
        return new BackgroundColorStyle(context, colorRes);
    }

    /**
     * @see BlurMaskFilter#BlurMaskFilter(float, BlurMaskFilter.Blur)
     */
    public static Style blur(float radius, BlurMaskFilter.Blur style) {
        return new BlurStyle(radius, style);
    }

    /**
     * @see Typeface#BOLD
     */
    public static Style bold() {
        return new BoldStyle();
    }

    /**
     * <b>Note:</b> Movement method is needed: {@link TextView#setMovementMethod(MovementMethod) TextView.setMovementMethod(LinkMovementMethod.getInstance())}
     * @see ClickableSpan#ClickableSpan()
     */
    public static Style click(View.OnClickListener listener) {
        return new ClickStyle(listener);
    }

    /**
     * @see ForegroundColorSpan#ForegroundColorSpan(int)
     */
    public static Style color(@ColorInt int color) {
        return new ColorStyle(color);
    }

    /**
     * @see ForegroundColorSpan#ForegroundColorSpan(int)
     */
    public static Style color(Context context, @ColorRes int colorRes) {
        return new ColorStyle(context, colorRes);
    }

    /**
     * @see EmbossMaskFilter#EmbossMaskFilter(float[], float, float, float)
     */
    public static Style emboss(float[] direction, float ambient, float specular, float blurRadius) {
        return new EmbossStyle(direction, ambient, specular, blurRadius);
    }

    /**
     * @see Typeface#ITALIC
     */
    public static Style italic() {
        return new ItalicStyle();
    }

    /**
     * @see LocaleSpan#LocaleSpan(LocaleList)
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static Style locale(LocaleList localeList) {
        return new LocaleStyle(localeList);
    }

    /**
     * @see LocaleSpan#LocaleSpan(Locale)
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static Style locale(Locale locale) {
        return new LocaleStyle(locale);
    }

    /**
     * @see Typeface#NORMAL
     */
    public static Style normal() {
        return new NormalStyle();
    }

    /**
     * @see ScaleXSpan#ScaleXSpan(float)
     */
    public static Style scaleX(float proportion) {
        return new ScaleXStyle(proportion);
    }


    /**
     * @see AbsoluteSizeSpan#AbsoluteSizeSpan(int)
     */
    public static Style size(int size) {
        return new SizeStyle(size);
    }

    /**
     * @see AbsoluteSizeSpan#AbsoluteSizeSpan(int, boolean)
     */
    public static Style size(int size, boolean dip) {
        return new SizeStyle(size, dip);
    }

    /**
     * @see RelativeSizeSpan#RelativeSizeSpan(float)
     */
    public static Style size(float proportion) {
        return new SizeStyle(proportion);
    }

    /**
     * @see StrikethroughSpan#StrikethroughSpan()
     */
    public static Style strikethrough() {
        return new StrikethroughStyle();
    }

    /**
     * @see TextAppearanceSpan#TextAppearanceSpan(Context, int)
     */
    public static Style style(Context context, @StyleRes int appearance) {
        return new StyleStyle(context, appearance);
    }

    /**
     * @see TextAppearanceSpan#TextAppearanceSpan(Context, int, int)
     */
    public static Style style(Context context, @StyleRes int appearance, int colorList) {
        return new StyleStyle(context, appearance, colorList);
    }

    /**
     * @see TextAppearanceSpan#TextAppearanceSpan(String, int, int, ColorStateList, ColorStateList)
     */
    public static Style style(String family, int style, int size, ColorStateList color, ColorStateList linkColor) {
        return new StyleStyle(family, style, size, color, linkColor);
    }

    /**
     * @see SubscriptSpan#SubscriptSpan()
     */
    public static Style subscript() {
        return new SubscriptStyle();
    }

    /**
     * @see SuperscriptSpan#SuperscriptSpan()
     */
    public static Style superscript() {
        return new SuperscriptStyle();
    }

    /**
     * @see TypefaceSpan#TypefaceSpan(String)
     */
    public static Style typeface(String typeface) {
        return new TypefaceStyle(typeface);
    }

    /**
     * @see UnderlineSpan#UnderlineSpan()
     */
    public static Style underline() {
        return new UnderlineStyle();
    }

    /**
     * @see URLSpan#URLSpan(String)
     */
    public static Style url(String url) {
        return new UrlStyle(url);
    }

    abstract void apply(SpannableStringBuilder builder, int start, int end);

}
