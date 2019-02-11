package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface DemoService {
    List<Map<String, Object>> getInfo();
}
