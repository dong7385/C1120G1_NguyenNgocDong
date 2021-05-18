package com.test_module_4.repository.request;

import com.test_module_4.model.request.Request;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {
    Page<Request> findAll(Pageable pageable);

    @Query(value = "select * " +
            "from request " +
            "where date_request between ?1 and ?2 ", nativeQuery = true)
    Page<Request> searchByDate(String startDate, String endDate, Pageable pageable);

    @Query(value = "select * " +
            "from request " +
            "order by total desc " +
            "limit ?1",nativeQuery = true)
    List<Request>searchByTop(Integer top);

}
