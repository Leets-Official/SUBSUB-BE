package com.example.subsub.repository;

import com.example.subsub.domain.Property;
import com.example.subsub.domain.Subject;
import com.example.subsub.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    List<Subject> findAllByUser(User user);

    //각 유저의 모든-과목이름 출력기능 : 과목이름만 추출//subjectRep
    @Query("SELECT s.subjectName FROM Subject s WHERE s.user = :user")
    List<String> findAllSubjectNamesByUser(@Param("user") User user);
}
