package org.example.dto;

import org.example.entity.Admin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class BranchDto {
    private String id;
    private String name;
    private String location;
    private String Address;
    private Admin admin;
}
