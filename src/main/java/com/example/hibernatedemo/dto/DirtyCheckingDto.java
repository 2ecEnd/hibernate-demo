package com.example.hibernatedemo.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class DirtyCheckingDto {

    private UUID bookId;

    private String newTitle;
}
