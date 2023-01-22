package myUtils;

import org.apache.poi.sl.usermodel.VerticalAlignment;
import org.apache.poi.xslf.usermodel.*;

import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyFrame {

    public static void createFrame() throws IOException {
        String text = "၁။ \nပြည်ထောင်စုဖောင့်\nhello\nမင်္ဂလာပါ";

        XMLSlideShow slideShow = new XMLSlideShow();
        slideShow.setPageSize(new Dimension(DEFAULT.DEFAULT_SLIDE_WIDTH, DEFAULT.DEFAULT_SLIDE_HEIGHT));

        XSLFSlide slide = slideShow.createSlide();
        CustomAnchor anchor = new CustomAnchor();

        XSLFTextBox textBox = createTextBox(slide, anchor);

        XSLFTextParagraph paragraph = createParagraph(textBox);

        createTextRun(paragraph, text, new CustomRichText());

        createOutputFile(slideShow);

    }

    private static XSLFTextBox createTextBox(XSLFSlide slide, CustomAnchor anchor) {
        XSLFTextBox textBox = slide.createTextBox();
        textBox.setAnchor(anchor.getRectangle());
        textBox.setVerticalAlignment(VerticalAlignment.MIDDLE);
        textBox.clearText();
        return textBox;
    }

    private static XSLFTextParagraph createParagraph(XSLFTextBox textBox) {
        XSLFTextParagraph paragraph = textBox.addNewTextParagraph();
        paragraph.setSpaceBefore(DEFAULT.DEFAULT_LINE_SPACING);
        paragraph.setSpaceAfter(DEFAULT.DEFAULT_LINE_SPACING);
        return paragraph;
    }


    private static void createTextRun(XSLFTextParagraph paragraph, String textToWrite, CustomRichText richText) {
        XSLFTextRun textRun = paragraph.addNewTextRun();
        textRun.setFontFamily(richText.getFontName());
        textRun.setText(textToWrite);
        textRun.setFontFamily(richText.getFontName());
        textRun.setFontSize(richText.getFontSize());
        textRun.setFontColor(richText.getFontColor());

        textRun.setBold(richText.isBold());
        textRun.setItalic(richText.isItalic());
        textRun.setUnderlined(richText.isUnderlined());
        textRun.setStrikethrough(richText.isStrikeThrough());
        textRun.setCharacterSpacing(richText.getCharacterSpacing());
    }

    private static void createOutputFile(XMLSlideShow slideShow) throws IOException {
        FileOutputStream out = new FileOutputStream("GeneratedPPTX.pptx");
        slideShow.write(out);

        slideShow.close();
        out.close();
    }

}
