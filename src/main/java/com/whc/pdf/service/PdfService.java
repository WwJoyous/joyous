package com.whc.pdf.service;

/**
 * @author: whc
 * @Description:
 * @Date: Create in 14:30 2017/11/10
 */
public interface PdfService {

    String upload(byte[] file, Integer pageNo, Integer pageSize);
}
