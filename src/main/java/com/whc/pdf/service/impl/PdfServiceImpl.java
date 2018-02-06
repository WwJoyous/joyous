package com.whc.pdf.service.impl;

import com.whc.pdf.service.PdfService;
import com.whc.pdf.util.PdfReaderUtil;
import org.springframework.stereotype.Service;

/**
 * @author: whc
 * @Description:
 * @Date: Create in 14:31 2017/11/10
 */
@Service
public class PdfServiceImpl implements PdfService {

    @Override
    public String upload(byte[] file, Integer pageNo, Integer pageSize) {
        return PdfReaderUtil.readPdfToString(file, pageNo, pageSize);
    }
}
