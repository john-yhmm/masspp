package myUtils;

import java.awt.Color;

public class CustomRichText {
    private String  fontName= DEFAULT.FONT_NAME_MM_DEFAULT;
    private double  fontSize= DEFAULT.FONT_SIZE_DEFAULT;
    private Color   fontColor= DEFAULT.FONT_COLOR_DEFAULT;
    private boolean isBold= DEFAULT.BOLD_DEFAULT;
    private boolean isItalic= DEFAULT.ITALIC_DEFAULT;
    private boolean isUnderlined= DEFAULT.UNDERLINED_DEFAULT;
    private boolean isStrikeThrough= DEFAULT.STRIKE_THROUGH_DEFAULT;
    private double  characterSpacing= DEFAULT.CHARACTER_SPACING_DEFAULT;

    public String getFontName() {
        return fontName;
    }

    public double getFontSize() {
        return fontSize;
    }

    public Color getFontColor() {
        return fontColor;
    }

    public boolean isBold() {
        return isBold;
    }

    public boolean isItalic() {
        return isItalic;
    }

    public boolean isUnderlined() {
        return isUnderlined;
    }

    public boolean isStrikeThrough() {
        return isStrikeThrough;
    }

    public double getCharacterSpacing() {
        return characterSpacing;
    }
}
