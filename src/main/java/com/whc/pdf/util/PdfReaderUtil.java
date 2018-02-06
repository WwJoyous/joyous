package com.whc.pdf.util;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.*;

public class PdfReaderUtil {

    public static String readPdfToString(byte[] bytes, Integer pageNo, Integer pageSize) {
        PDDocument document = null;
        try {
            document = PDDocument.load(bytes);

            // 获取页码
            int pages = document.getNumberOfPages();
            int startPage = 1;

            // 读文本内容
            PDFTextStripper stripper = new PDFTextStripper();
            // 设置按顺序输出
            stripper.setSortByPosition(true);

            if (pageNo != null && pageNo <= pages) {
                startPage = pageNo;
            }
            if (pageSize != null && pageSize <= pages && pageSize >= startPage) {
                pages = pageSize;
            }
            stripper.setStartPage(startPage);
            stripper.setEndPage(pages);
            return stripper.getText(document);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (document != null) {
                try {
                    document.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}