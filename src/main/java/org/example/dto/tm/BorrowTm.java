package org.example.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class BorrowTm {
    private String memberId;
    private String bookId;
    private String status;
    private LocalDate borrowDate;
    private LocalDate returnDate;
}
