package com.application.courseLibrary.repository;

import com.application.courseLibrary.entity.Category;
import com.application.courseLibrary.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {


}
