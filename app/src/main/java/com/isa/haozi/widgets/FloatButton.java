package com.isa.haozi.widgets;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v7.widget.AppCompatImageButton;
import android.util.AttributeSet;

import com.isa.haozi.R;

/**
 * Created by Izumi on 17/8/17.
 */

public class FloatButton extends AppCompatImageButton {

    private int bgColor;
    private int bgColorPressed;

    public FloatButton(Context context) {
        super(context);
        init(context, null);
    }

    public FloatButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public FloatButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        Resources.Theme theme = context.getTheme();

        TypedArray typedArray = theme.obtainStyledAttributes(attrs, R.styleable.FloatButton, 0, 0);
        if (typedArray != null) {
            setBgColor(typedArray.getColor(R.styleable.FloatButton_bg_color, Color.BLUE));
            setBgColorPressed(typedArray.getColor(R.styleable.FloatButton_bg_color_pressed, Color.GRAY));

            StateListDrawable sld = new StateListDrawable();
            sld.addState(new int[] {android.R.attr.state_pressed}, createButton(bgColorPressed));
            sld.addState(new int[] {}, createButton(bgColor));
            setBackground(sld);

            typedArray.recycle();
        }
    }

    public void setBgColor(int color) {
        this.bgColor = color;
    }

    public void setBgColorPressed(int colorPressed) {
        this.bgColorPressed = colorPressed;
    }

    private Drawable createButton(int color) {
        OvalShape ovalShape = new OvalShape();
        ShapeDrawable sd = new ShapeDrawable(ovalShape);
        setWillNotDraw(false);
        sd.getPaint().setColor(color);

        //        OvalShape ovalShape1 = new OvalShape();
        //        ShapeDrawable sd1 = new ShapeDrawable(ovalShape1);
        //
        //        sd1.setShaderFactory(new ShapeDrawable.ShaderFactory() {
        //            @Override
        //            public Shader resize(int width, int height) {
        //                LinearGradient linearGradient = new LinearGradient(0, 0, 0, height,
        //                        new int[] {
        //                                Color.WHITE,
        //                                Color.GRAY,
        //                                Color.DKGRAY,
        //                                Color.BLACK
        //                        }, null, Shader.TileMode.REPEAT);
        //                return linearGradient;
        //            }
        //        });

        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[] {sd});
        // 设置指定索引Drawable的边界
        layerDrawable.setLayerInset(0, 5, 5, 0, 0);
        //        layerDrawable.setLayerInset(1, 0, 0, 5, 5);

        return layerDrawable;
    }
}
