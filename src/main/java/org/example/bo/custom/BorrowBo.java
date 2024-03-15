package org.example.bo.custom;

import org.example.bo.SuperBo;

public interface BorrowBo extends SuperBo {
    String generateNextOrderDetailId() throws Exception;

    String genarateNextBorrowId() throws Exception;
}
