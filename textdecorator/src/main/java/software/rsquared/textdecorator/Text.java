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
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;
import android.text.Spannable;
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
@SuppressWarnings({"WeakerAccess", "unused"})
public class Text implements Spannable {
    private SpannableStringBuilder builder = new SpannableStringBuilder();
    private Context context;

    public Text() {
    }

    public Text(Context context) {
        this.context = context;
    }

    public Text(CharSequence text) {
        append(text, new TextDecoratorBuilder());
    }

    public Text(Context context, @StringRes int text) {
        this.context = context;
        append(text, new TextDecoratorBuilder());
    }

    public Text(Context context, CharSequence text) {
        this.context = context;
        append(text, new TextDecoratorBuilder());
    }

    public Text(CharSequence text, TextDecorator... textDecorators) {
        append(text, new TextDecoratorBuilder(textDecorators));
    }

    public Text(Context context, @StringRes int text, TextDecorator... textDecorators) {
        this.context = context;
        append(text, new TextDecoratorBuilder(textDecorators));
    }

    public Text(Context context, CharSequence text, TextDecorator... textDecorators) {
        this.context = context;
        append(text, new TextDecoratorBuilder(textDecorators));
    }

    public Text(CharSequence text, TextDecoratorBuilder styles) {
        append(text, styles);
    }

    public Text(Context context, @StringRes int text, TextDecoratorBuilder styles) {
        this.context = context;
        append(text, styles);
    }

    public Text(Context context, CharSequence text, TextDecoratorBuilder styles) {
        this.context = context;
        append(text, styles);
    }

    public Text withContext(Context context){
        this.context = context;
        return this;
    }

    /**
     * @see BackgroundColorSpan#BackgroundColorSpan(int)
     */
    public static TextDecoratorBuilder backgroundColor(@ColorInt int color) {
        return new TextDecoratorBuilder(new BackgroundColorTextDecorator(color));
    }

    /**
     * @see BackgroundColorSpan#BackgroundColorSpan(int)
     */
    public static TextDecoratorBuilder backgroundColor(Context context, @ColorRes int colorRes) {
        return new TextDecoratorBuilder(new BackgroundColorTextDecorator(context, colorRes));
    }

    /**
     * @see BlurMaskFilter#BlurMaskFilter(float, BlurMaskFilter.Blur)
     */
    public static TextDecoratorBuilder blur(float radius, BlurMaskFilter.Blur style) {
        return new TextDecoratorBuilder(new BlurTextDecorator(radius, style));
    }

    /**
     * @see Typeface#BOLD
     */
    public static TextDecoratorBuilder bold() {
        return new TextDecoratorBuilder(new BoldTextDecorator());
    }

    /**
     * <b>Note:</b> Movement method is needed: {@link TextView#setMovementMethod(MovementMethod) TextView.setMovementMethod(LinkMovementMethod.getInstance())}
     *
     * @see ClickableSpan#ClickableSpan()
     */
    public static TextDecoratorBuilder click(View.OnClickListener listener) {
        return new TextDecoratorBuilder(new ClickTextDecorator(listener));
    }

    /**
     * @see ForegroundColorSpan#ForegroundColorSpan(int)
     */
    public static TextDecoratorBuilder color(@ColorInt int color) {
        return new TextDecoratorBuilder(new ColorTextDecorator(color));
    }

    /**
     * @see ForegroundColorSpan#ForegroundColorSpan(int)
     */
    public static TextDecoratorBuilder color(Context context, @ColorRes int colorRes) {
        return new TextDecoratorBuilder(new ColorTextDecorator(context, colorRes));
    }

    /**
     * @see EmbossMaskFilter#EmbossMaskFilter(float[], float, float, float)
     */
    public static TextDecoratorBuilder emboss(float[] direction, float ambient, float specular, float blurRadius) {
        return new TextDecoratorBuilder(new EmbossTextDecorator(direction, ambient, specular, blurRadius));
    }

    /**
     * @see Typeface#ITALIC
     */
    public static TextDecoratorBuilder italic() {
        return new TextDecoratorBuilder(new ItalicTextDecorator());
    }

    /**
     * @see LocaleSpan#LocaleSpan(LocaleList)
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static TextDecoratorBuilder locale(LocaleList localeList) {
        return new TextDecoratorBuilder(new LocaleTextDecorator(localeList));
    }

    /**
     * @see LocaleSpan#LocaleSpan(Locale)
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static TextDecoratorBuilder locale(Locale locale) {
        return new TextDecoratorBuilder(new LocaleTextDecorator(locale));
    }

    /**
     * @see Typeface#NORMAL
     */
    public static TextDecoratorBuilder normal() {
        return new TextDecoratorBuilder(new NormalTextDecorator());
    }

    /**
     * @see ScaleXSpan#ScaleXSpan(float)
     */
    public static TextDecoratorBuilder scaleX(float proportion) {
        return new TextDecoratorBuilder(new ScaleXTextDecorator(proportion));
    }

    /**
     * @see AbsoluteSizeSpan#AbsoluteSizeSpan(int)
     */
    public static TextDecoratorBuilder size(int size) {
        return new TextDecoratorBuilder(new SizeTextDecorator(size));
    }

    /**
     * @see AbsoluteSizeSpan#AbsoluteSizeSpan(int, boolean)
     */
    public static TextDecoratorBuilder size(int size, boolean dip) {
        return new TextDecoratorBuilder(new SizeTextDecorator(size, dip));
    }

    /**
     * @see RelativeSizeSpan#RelativeSizeSpan(float)
     */
    public static TextDecoratorBuilder size(float proportion) {
        return new TextDecoratorBuilder(new SizeTextDecorator(proportion));
    }

    /**
     * @see StrikethroughSpan#StrikethroughSpan()
     */
    public static TextDecoratorBuilder strikethrough() {
        return new TextDecoratorBuilder(new StrikethroughTextDecorator());
    }

    /**
     * @see TextAppearanceSpan#TextAppearanceSpan(Context, int)
     */
    public static TextDecoratorBuilder style(Context context, @StyleRes int appearance) {
        return new TextDecoratorBuilder(new StyleTextDecorator(context, appearance));
    }

    /**
     * @see TextAppearanceSpan#TextAppearanceSpan(Context, int, int)
     */
    public static TextDecoratorBuilder style(Context context, @StyleRes int appearance, int colorList) {
        return new TextDecoratorBuilder(new StyleTextDecorator(context, appearance, colorList));
    }

    /**
     * @see TextAppearanceSpan#TextAppearanceSpan(String, int, int, ColorStateList, ColorStateList)
     */
    public static TextDecoratorBuilder style(String family, int style, int size, ColorStateList color, ColorStateList linkColor) {
        return new TextDecoratorBuilder(new StyleTextDecorator(family, style, size, color, linkColor));
    }

    /**
     * @see SubscriptSpan#SubscriptSpan()
     */
    public static TextDecoratorBuilder subscript() {
        return new TextDecoratorBuilder(new SubscriptTextDecorator());
    }

    /**
     * @see SuperscriptSpan#SuperscriptSpan()
     */
    public static TextDecoratorBuilder superscript() {
        return new TextDecoratorBuilder(new SuperscriptTextDecorator());
    }

    /**
     * @see TypefaceSpan#TypefaceSpan(String)
     */
    public static TextDecoratorBuilder typeface(String typeface) {
        return new TextDecoratorBuilder(new TypefaceTextDecorator(typeface));
    }

    /**
     * @see UnderlineSpan#UnderlineSpan()
     */
    public static TextDecoratorBuilder underline() {
        return new TextDecoratorBuilder(new UnderlineTextDecorator());
    }

    /**
     * @see URLSpan#URLSpan(String)
     */
    public static TextDecoratorBuilder url(String url) {
        return new TextDecoratorBuilder(new UrlTextDecorator(url));
    }


    public Text append(@StringRes int text) {
        return append(text, new TextDecoratorBuilder());
    }

    public Text append(@StringRes int text, TextDecorator... textDecorators) {
        return append(text, new TextDecoratorBuilder(textDecorators));
    }

    public Text append(@StringRes int text, TextDecoratorBuilder styles) {
        if (context == null){
            throw new NullPointerException("Context is null, please set context with withContext(Context) method");
        }
        return append(context.getString(text), styles);
    }

    public Text append(CharSequence text) {
        return append(text, new TextDecoratorBuilder());
    }

    public Text append(CharSequence text, TextDecorator... textDecorators) {
        return append(text, new TextDecoratorBuilder(textDecorators));
    }

    public Text append(CharSequence text, TextDecoratorBuilder styles) {
        int start = builder.length();
        builder.append(text);
        for (TextDecorator textDecorator : styles.getTextDecorators()) {
            textDecorator.apply(builder, start, start + text.length());
        }
        return this;
    }

    @Override
    public int length() {
        return builder.length();
    }

    @Override
    public char charAt(int index) {
        return builder.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return builder.subSequence(start, end);
    }

    @Override
    public void setSpan(Object what, int start, int end, int flags) {
        builder.setSpan(what, start, end, flags);
    }

    @Override
    public void removeSpan(Object what) {
        builder.removeSpan(what);
    }

    @Override
    public <T> T[] getSpans(int start, int end, Class<T> type) {
        return builder.getSpans(start, end, type);
    }

    @Override
    public int getSpanStart(Object tag) {
        return builder.getSpanStart(tag);
    }

    @Override
    public int getSpanEnd(Object tag) {
        return builder.getSpanEnd(tag);
    }

    @Override
    public int getSpanFlags(Object tag) {
        return builder.getSpanFlags(tag);
    }

    @Override
    public int nextSpanTransition(int start, int limit, Class type) {
        return builder.nextSpanTransition(start, limit, type);
    }

    @NonNull
    @Override
    public String toString() {
        return builder.toString();
    }

}
