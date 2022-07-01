package com.revature.repository;

import java.util.List;

public interface DAO<T> {
    T create(T e);
    List<T> getAll();
}
