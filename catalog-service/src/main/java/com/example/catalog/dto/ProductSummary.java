package com.example.catalog.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ProductSummary(Long id, String name, Integer reviewCount, String thumbnailUrl) {}
