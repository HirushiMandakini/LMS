package org.example.bo.impl;

import org.example.bo.custom.BorrowBo;
import org.example.dao.BorrowDaOImpl;

public class BorrowBoImpl implements BorrowBo {


    BorrowDaOImpl borrowDaO = new BorrowDaOImpl();
    @Override
    public String generateNextOrderDetailId() throws Exception {
        return borrowDaO.generateNextValue2();
    }
    @Override
    public String genarateNextBorrowId() throws Exception {
        return borrowDaO.generateNextValue();
    }
}
