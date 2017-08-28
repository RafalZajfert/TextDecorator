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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * @author Rafal Zajfert
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class TextDecoratorBuilder {

    private final List<TextDecorator> textDecorators = new ArrayList<>();

    public TextDecoratorBuilder() {
    }

    public TextDecoratorBuilder(TextDecorator... textDecorators) {
        Collections.addAll(this.textDecorators, textDecorators);
    }

    /**
     * @see BackgroundColorSpan#BackgroundColorSpan(int)
     */
    public TextDecoratorBuilder backgroundColor(@ColorInt int color) {
        textDecorators.add(new BackgroundColorTextDecorator(color));
        return this;
    }

    /**
     * @see BackgroundColorSpan#BackgroundColorSpan(int)
     */
    public TextDecoratorBuilder backgroundColor(Context context, @ColorRes int colorRes) {
        textDecorators.add(new BackgroundColorTextDecorator(context, colorRes));
        return this;
    }

    /**
     * @see BlurMaskFilter#BlurMaskFilter(float, BlurMaskFilter.Blur)
     */
    public TextDecoratorBuilder blur(float radius, BlurMaskFilter.Blur style) {
        textDecorators.add(new BlurTextDecorator(radius, style));
        return this;
    }

    /**
     * @see Typeface#BOLD
     */
    public TextDecoratorBuilder bold() {
        textDecorators.add(new BoldTextDecorator());
        return this;
    }

    /**
     * <b>Note:</b> Movement method is needed: {@link TextView#setMovementMethod(MovementMethod) TextView.setMovementMethod(LinkMovementMethod.getInstance())}
     *
     * @see ClickableSpan#ClickableSpan()
     */
    public TextDecoratorBuilder click(View.OnClickListener listener) {
        textDecorators.add(new ClickTextDecorator(listener));
        return this;
    }

    /**
     * @see ForegroundColorSpan#ForegroundColorSpan(int)
     */
    public TextDecoratorBuilder color(@ColorInt int color) {
        textDecorators.add(new ColorTextDecorator(color));
        return this;
    }

    /**
     * @see ForegroundColorSpan#ForegroundColorSpan(int)
     */
    public TextDecoratorBuilder color(Context context, @ColorRes int colorRes) {
        textDecorators.add(new ColorTextDecorator(context, colorRes));
        return this;
    }

    /**
     * @see EmbossMaskFilter#EmbossMaskFilter(float[], float, float, float)
     */
    public TextDecoratorBuilder emboss(float[] direction, float ambient, float specular, float blurRadius) {
        textDecorators.add(new EmbossTextDecorator(direction, ambient, specular, blurRadius));
        return this;
    }

    /**
     * @see Typeface#ITALIC
     */
    public TextDecoratorBuilder italic() {
        textDecorators.add(new ItalicTextDecorator());
        return this;
    }

    /**
     * @see LocaleSpan#LocaleSpan(LocaleList)
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public TextDecoratorBuilder locale(LocaleList localeList) {
        textDecorators.add(new LocaleTextDecorator(localeList));
        return this;
    }

    /**
     * @see LocaleSpan#LocaleSpan(Locale)
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public TextDecoratorBuilder locale(Locale locale) {
        textDecorators.add(new LocaleTextDecorator(locale));
        return this;
    }

    /**
     * @see Typeface#NORMAL
     */
    public TextDecoratorBuilder normal() {
        textDecorators.add(new NormalTextDecorator());
        return this;
    }

    /**
     * @see ScaleXSpan#ScaleXSpan(float)
     */
    public TextDecoratorBuilder scaleX(float proportion) {
        textDecorators.add(new ScaleXTextDecorator(proportion));
        return this;
    }


    /**
     * @see AbsoluteSizeSpan#AbsoluteSizeSpan(int)
     */
    public TextDecoratorBuilder size(int size) {
        textDecorators.add(new SizeTextDecorator(size));
        return this;
    }

    /**
     * @see AbsoluteSizeSpan#AbsoluteSizeSpan(int, boolean)
     */
    public TextDecoratorBuilder size(int size, boolean dip) {
        textDecorators.add(new SizeTextDecorator(size, dip));
        return this;
    }

    /**
     * @see RelativeSizeSpan#RelativeSizeSpan(float)
     */
    public TextDecoratorBuilder size(float proportion) {
        textDecorators.add(new SizeTextDecorator(proportion));
        return this;
    }

    /**
     * @see StrikethroughSpan#StrikethroughSpan()
     */
    public TextDecoratorBuilder strikethrough() {
        textDecorators.add(new StrikethroughTextDecorator());
        return this;
    }

    /**
     * @see TextAppearanceSpan#TextAppearanceSpan(Context, int)
     */
    public TextDecoratorBuilder style(Context context, @StyleRes int appearance) {
        textDecorators.add(new StyleTextDecorator(context, appearance));
        return this;
    }

    /**
     * @see TextAppearanceSpan#TextAppearanceSpan(Context, int, int)
     */
    public TextDecoratorBuilder style(Context context, @StyleRes int appearance, int colorList) {
        textDecorators.add(new StyleTextDecorator(context, appearance, colorList));
        return this;
    }

    /**
     * @see TextAppearanceSpan#TextAppearanceSpan(String, int, int, ColorStateList, ColorStateList)
     */
    public TextDecoratorBuilder style(String family, int style, int size, ColorStateList color, ColorStateList linkColor) {
        textDecorators.add(new StyleTextDecorator(family, style, size, color, linkColor));
        return this;
    }

    /**
     * @see SubscriptSpan#SubscriptSpan()
     */
    public TextDecoratorBuilder subscript() {
        textDecorators.add(new SubscriptTextDecorator());
        return this;
    }

    /**
     * @see SuperscriptSpan#SuperscriptSpan()
     */
    public TextDecoratorBuilder superscript() {
        textDecorators.add(new SuperscriptTextDecorator());
        return this;
    }

    /**
     * @see TypefaceSpan#TypefaceSpan(String)
     */
    public TextDecoratorBuilder typeface(String typeface) {
        textDecorators.add(new TypefaceTextDecorator(typeface));
        return this;
    }

    /**
     * @see UnderlineSpan#UnderlineSpan()
     */
    public TextDecoratorBuilder underline() {
        textDecorators.add(new UnderlineTextDecorator());
        return this;
    }

    /**
     * @see URLSpan#URLSpan(String)
     */
    public TextDecoratorBuilder url(String url) {
        textDecorators.add(new UrlTextDecorator(url));
        return this;
    }

    List<TextDecorator> getTextDecorators() {
        return textDecorators;
    }
}
