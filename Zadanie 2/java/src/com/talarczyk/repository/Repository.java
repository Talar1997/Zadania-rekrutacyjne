package com.talarczyk.repository;

import java.util.List;

public interface Repository<T> {
    List<T> getAll();
}
