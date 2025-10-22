package org.example.dto;


import java.io.Serializable;

public interface Report {
    Serializable getGroup();
    Double getSum();
    Double getCount();
}
