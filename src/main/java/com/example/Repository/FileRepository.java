package com.example.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Entity.fileInfo;

@Repository
public interface FileRepository extends CrudRepository<fileInfo, Integer> {

}
